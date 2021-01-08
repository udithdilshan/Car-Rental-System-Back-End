package lk.easycarrental.carrentalsystem.controller;

import lk.easycarrental.carrentalsystem.dto.UserDTO;
import lk.easycarrental.carrentalsystem.service.UserService;
import lk.easycarrental.carrentalsystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) {
        userDTO.setVerified(false);
        userService.saveUser(userDTO);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/id")
    public ResponseEntity searchUser(@PathVariable String id) {
        UserDTO userDTO = userService.searchUser(id);
        return new ResponseEntity(new StandardResponse(200, "Success", userDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUser() {
        List<UserDTO> allUsers =userService.getAllUser();
        return new ResponseEntity(new StandardResponse(200, "Success", allUsers), HttpStatus.OK);
    }


}
