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
public class DriverDTO {
    private String driverId;
    private String drivingLicenseNumber;
    private String drivingLicensePic1;
    private String drivingLicensePic2;
    private String registeredDateTime;
    private UserDTO userDTO;
}
