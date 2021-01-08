package lk.easycarrental.carrentalsystem.controller;

import lk.easycarrental.carrentalsystem.dto.CarModelDTO;
import lk.easycarrental.carrentalsystem.dto.CategoryDTO;
import lk.easycarrental.carrentalsystem.service.CarModelService;
import lk.easycarrental.carrentalsystem.service.CategoryService;
import lk.easycarrental.carrentalsystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/carmodel")
@CrossOrigin
public class CarModelController {
    @Autowired
    CarModelService carModelService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCarModel(@RequestBody CarModelDTO carModelDTO) {
        carModelService.saveCarModel(carModelDTO);
        return new ResponseEntity(new StandardResponse(200,"Success",null), HttpStatus.CREATED);
    }


    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCarModel(@RequestParam String id) {
        carModelService.deleteCarModel(id);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCarModel(@RequestBody CarModelDTO carModelDTO) {
        carModelService.updateCarModel(carModelDTO);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/id")
    public ResponseEntity searchCarModel(@PathVariable String id) {
        CarModelDTO carModelDTO = carModelService.searchCarModel(id);
        return new ResponseEntity(new StandardResponse(200, "Success", carModelDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCarModel() {
        List<CarModelDTO> allCarModel = carModelService.getAllCarModel();
        System.out.println(allCarModel);
        return new ResponseEntity(new StandardResponse(200, "Success", allCarModel), HttpStatus.OK);
    }

}
