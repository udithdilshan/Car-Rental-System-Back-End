package lk.easycarrental.carrentalsystem.service;

import lk.easycarrental.carrentalsystem.dto.CustomerDTO;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface CustomerService {
    void saveCustomer(MultipartFile[] multipartFiles, CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO);

    CustomerDTO searchCustomer(String id);

    void deleteCustomer(String id);

    List<CustomerDTO> getAllCustomer();

}
