package lk.easycarrental.carrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentDetailDTO {
    private String rentDetailId;
    private boolean driverRequired;
    private double startMileage;
    private double endMileage;
    private String loseDamageWaiverPic;
    private double paymentAmount;
    private double deductAmount;
    private String string;
    private String addedDate;
    private String returnDate;
    private RentDTO rentDTO;
    private DriverDTO driverDTO;
    private CarDetailDTO carDetailDTO;
    private CarScheduleDTO carScheduleDTO;
    private DriverScheduleDTO driverScheduleDTO;
}
