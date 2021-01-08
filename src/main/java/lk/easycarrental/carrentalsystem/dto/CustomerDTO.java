package lk.easycarrental.carrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String customerId;
    private String nic;
    private String nicPic1;
    private String nicPic2;
    private String drivingLicenseNumber;
    private String drivingLicensePic1;
    private String drivingLicensePic2;
    private boolean verified;
    private boolean activeRented;
    private String registeredDateTime;
    private UserDTO userDTO;
}
