package lk.easycarrental.carrentalsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.easycarrental.carrentalsystem.dto.CustomerDTO;
import lk.easycarrental.carrentalsystem.service.CustomerService;
import lk.easycarrental.carrentalsystem.utill.FileUploadLocations;
import lk.easycarrental.carrentalsystem.utill.StandardResponse;
import org.apache.commons.io.IOUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ModelMapper mapper;

    ObjectMapper objectMapper = new ObjectMapper();

    @PutMapping
    public ResponseEntity addCustomer(@RequestPart(value = "nic1") MultipartFile nic1,
                                      @RequestPart(value = "nic2") MultipartFile nic2,
                                      @RequestPart(value = "licence1") MultipartFile licence1,
                                      @RequestPart(value = "licence2") MultipartFile licence2,
                                      @RequestParam(value = "customerDTO") String dto) throws JsonProcessingException {

        CustomerDTO customerDTO = objectMapper.readValue(dto, CustomerDTO.class);

        customerDTO.setNicPic1("NIC1_" + customerDTO.getCustomerId() + ".jpg");
        customerDTO.setNicPic2("NIC2_" + customerDTO.getCustomerId() + ".jpg");
        customerDTO.setDrivingLicensePic1("Driving1_" + customerDTO.getCustomerId() + ".jpg");
        customerDTO.setDrivingLicensePic2("Driving2_" + customerDTO.getCustomerId() + ".jpg");

        System.out.println(customerDTO.getNic());
        System.out.println(customerDTO.getDrivingLicenseNumber());
        MultipartFile multipartFiles[] = new MultipartFile[]{nic1, nic2, licence1, licence2};
        for (int i = 0; i < multipartFiles.length; i++) {
            System.out.println(multipartFiles[i].getOriginalFilename());
        }
        customerService.saveCustomer(multipartFiles, customerDTO);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/id")
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDTO customerDTO = customerService.searchCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Success", customerDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomer() {
        List<CustomerDTO> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity(new StandardResponse(200, "Success", allCustomer), HttpStatus.OK);
    }


    @GetMapping(path = "/{id}/{file}" )
    public Resource sendPic(@PathVariable String id, @PathVariable String file) {
        System.out.println(id);
        System.out.println(file);
            Path pathToFile= Paths.get(FileUploadLocations.CUSTOMER+id+"/" + file);
            Resource resource=null;
        try {
            resource=new UrlResource(pathToFile.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println(resource.exists());
        System.out.println(resource.getFilename());
        try {
            System.out.println(resource.getURL());
            System.out.println(resource.getURI());
            System.out.println(resource.getDescription());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resource;
    }
}

