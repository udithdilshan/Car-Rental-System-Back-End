package lk.easycarrental.carrentalsystem.service.Impl;

import lk.easycarrental.carrentalsystem.dto.CustomerDTO;
import lk.easycarrental.carrentalsystem.dto.UserDTO;
import lk.easycarrental.carrentalsystem.entity.Customer;
import lk.easycarrental.carrentalsystem.entity.User;
import lk.easycarrental.carrentalsystem.repo.CustomerRepo;
import lk.easycarrental.carrentalsystem.repo.UserRepo;
import lk.easycarrental.carrentalsystem.service.CustomerService;
import lk.easycarrental.carrentalsystem.service.UserService;
import lk.easycarrental.carrentalsystem.utill.FileUploadLocations;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    UserService userService;

    @Override
    public void saveCustomer(MultipartFile[] multipartFiles, CustomerDTO customerDTO) {
        if (userRepo.existsById(customerDTO.getCustomerId())) {
            if (!customerRepo.existsById(customerDTO.getCustomerId())) {
                String nicPic1 = customerDTO.getNicPic1();
                String nicPic2 = customerDTO.getNicPic2();
                String licensePic1 = customerDTO.getDrivingLicensePic1();
                String licensePic2 = customerDTO.getDrivingLicensePic2();
                String[] names = new String[]{nicPic1, nicPic2, licensePic1, licensePic2};
                for (int i = 0; i < names.length; i++) {
                    System.out.println(names[i]);
                }

                String directoryName = FileUploadLocations.CUSTOMER + customerDTO.getCustomerId();
                File directory = new File(directoryName);
                if (!directory.exists()) {
                    System.out.println(directoryName);
                    directory.mkdirs();
                }
                List<String> urls = new ArrayList<>();
                for (int i = 0; i < names.length; i++) {
                    try {
                        File convertFile = new File(directoryName, names[i]);
                        convertFile.createNewFile();
                        FileOutputStream fout = new FileOutputStream(convertFile);
                        fout.write(multipartFiles[i].getBytes());
                        fout.close();
//                        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(FileUploadLocations.CUSTOMER_DOWNLOAD_PATH+customerDTO.getCustomerId()+"/")
//                                .path(names[i]).toUriString();
//                        urls.add(fileDownloadUri);
//                        System.out.println(fileDownloadUri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//                customerDTO.setNicPic1(urls.get(0));
//                customerDTO.setNicPic2(urls.get(1));
//                customerDTO.setDrivingLicensePic1(urls.get(2));
//                customerDTO.setDrivingLicensePic2(urls.get(3));

                UserDTO userDTO = userService.searchUser(customerDTO.getCustomerId());
                User user = mapper.map(userDTO, User.class);
                user.setVerified(true);
                Customer customer = mapper.map(customerDTO, Customer.class);
                customer.setUser(user);
                customerRepo.save(customer);

            } else {
                throw new RuntimeException("Customer already exist !");
            }
        } else {
            throw new RuntimeException("User doesn't exist !");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())) {
            Customer customer = mapper.map(customerDTO, Customer.class);
            customerRepo.save(customer);
        } else {
            throw new RuntimeException("Such Customer does not exist!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("No Customer for Id " + id);
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new RuntimeException("No Customer for Delete Id " + id);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }
}
