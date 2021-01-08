package lk.easycarrental.carrentalsystem.service.Impl;

import lk.easycarrental.carrentalsystem.dto.UserDTO;
import lk.easycarrental.carrentalsystem.entity.User;
import lk.easycarrental.carrentalsystem.repo.UserRepo;
import lk.easycarrental.carrentalsystem.service.LogInService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.Optional;

@Service
@Transactional
public class LogInServiceImpl implements LogInService {

    @Autowired
    UserRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDTO LogInUser(UserDTO userDTO) {

        userDTO.setEmail(userDTO.getEmail().toLowerCase());

        if(repo.existsByEmail(userDTO.getEmail())){
            Optional<User> user =repo.findByEmail(userDTO.getEmail());
            UserDTO temp = mapper.map(user.get(), UserDTO.class);
            String decodedPassword = getDecodedString(temp.getPassword());
            temp.setPassword("");
            if (decodedPassword.compareTo(userDTO.getPassword())==0){
                return temp;
            }else {
                throw new RuntimeException("Incorrect !");
            }
        }else{
            throw new RuntimeException("No User Exist !");
        }
    }
    private String getDecodedString(String password){
        return new String(Base64.getDecoder().decode(password));
    }

}
