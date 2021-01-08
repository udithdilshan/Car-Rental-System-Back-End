package lk.easycarrental.carrentalsystem.controller;


import lk.easycarrental.carrentalsystem.dto.UserDTO;
import lk.easycarrental.carrentalsystem.service.LogInService;
import lk.easycarrental.carrentalsystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/logIn")
@CrossOrigin
public class LogInController {

    @Autowired
    LogInService logInService;

    @GetMapping
    public ResponseEntity userLogIn(@RequestHeader(value="email") String email,@RequestHeader(value = "password") String password) {
        UserDTO temp=new UserDTO();;
        temp.setEmail(email);
        temp.setPassword(password);
        UserDTO userDTO = logInService.LogInUser(temp);
        return new ResponseEntity(new StandardResponse(200, "Success", userDTO), HttpStatus.OK);
    }
}
