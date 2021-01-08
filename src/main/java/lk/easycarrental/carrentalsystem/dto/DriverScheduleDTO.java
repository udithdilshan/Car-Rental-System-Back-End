package lk.easycarrental.carrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverScheduleDTO {
    private String driveScheduleId;
    private String startDateTime;
    private String endDateTime;
    private DriverDTO driverDTO;
    private RentDetailDTO rentDetailDTO;
}
