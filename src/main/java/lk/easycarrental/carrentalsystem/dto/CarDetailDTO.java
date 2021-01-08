package lk.easycarrental.carrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDetailDTO {
    private String carId;
    private String registrationNo;
    private String mileage;
    private String color;
    private String frontPic;
    private String backPic;
    private String sidePic;
    private String interiorPic;
    private double maintenance_Km;
    private String onMaintenance;
    private boolean available;
    private CarModelDTO modelDTO;
}
