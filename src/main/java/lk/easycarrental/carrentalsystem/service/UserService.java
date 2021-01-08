package lk.easycarrental.carrentalsystem.service;

import lk.easycarrental.carrentalsystem.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    UserDTO searchUser(String id);

    void deleteUser(String id);

    List<UserDTO> getAllUser();
}
