package lk.easycarrental.carrentalsystem.controller;


import lk.easycarrental.carrentalsystem.dto.CategoryDTO;
import lk.easycarrental.carrentalsystem.dto.UserDTO;
import lk.easycarrental.carrentalsystem.service.CategoryService;
import lk.easycarrental.carrentalsystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.addCategory(categoryDTO);
        return new ResponseEntity(new StandardResponse(200,"Success",null), HttpStatus.CREATED);
    }


    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCategory(@RequestParam String id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategory(categoryDTO);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/id")
    public ResponseEntity searchCategory(@PathVariable String id) {
        CategoryDTO categoryDTO = categoryService.searchCategory(id);
        return new ResponseEntity(new StandardResponse(200, "Success", categoryDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCategory() {
        List<CategoryDTO> allCategory = categoryService.getAllCategory();
        return new ResponseEntity(new StandardResponse(200, "Success", allCategory), HttpStatus.OK);
    }


}
