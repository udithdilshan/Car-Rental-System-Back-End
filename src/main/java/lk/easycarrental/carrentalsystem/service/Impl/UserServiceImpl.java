package lk.easycarrental.carrentalsystem.service.Impl;

import lk.easycarrental.carrentalsystem.dto.UserDTO;
import lk.easycarrental.carrentalsystem.entity.User;
import lk.easycarrental.carrentalsystem.repo.UserRepo;
import lk.easycarrental.carrentalsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setEmail(userDTO.getEmail().toLowerCase());
        if (!repo.existsByEmail(userDTO.getEmail())) {
            userDTO.setPassword(getEncodedString(userDTO.getPassword()));
            User user = mapper.map(userDTO, User.class);
            repo.save(user);
        } else {
            throw new RuntimeException("User already exist !");
        }
    }

    private String getEncodedString(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if (repo.existsById(userDTO.getUserId())) {
            User user = mapper.map(userDTO, User.class);
            repo.save(user);
        } else {
            throw new RuntimeException("No such User for Update! ");
        }
    }

    @Override
    public UserDTO searchUser(String id) {
        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            return mapper.map(user.get(), UserDTO.class);
        } else {
            throw new RuntimeException("No User for Id " + id);
        }
    }

    @Override
    public void deleteUser(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No User for Delete Id : " + id);
        }
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<UserDTO>>() {
        }.getType());
    }
}
