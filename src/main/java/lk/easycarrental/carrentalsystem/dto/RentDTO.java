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
public class RentDTO {
    private String rentId;
    private String pickUpDateTime;
    private String returnDateTime;
    private String pickUpLocation;
    private String returnUpLocation;
    private String actualReturnDateTime;
    private int noOfCars;
    private String status;
    private String addedDateTime;
    private String note;
    private CustomerDTO customerDTO;
    private PaymentDTO paymentDTO;
    private CarDetailDTO carDetailDTO;
}
