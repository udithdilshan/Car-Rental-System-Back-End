package lk.easycarrental.carrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarScheduleDTO {
    private String carScheduleId;
    private String pickUpDateTime;
    private String returnDateTime;
    private CarDetailDTO carDetailDTO;
    private RentDetailDTO rentDetailDTO;
}
