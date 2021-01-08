package lk.easycarrental.carrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarModelDTO {
    private String modelId;
    private String type;
    private String brandName;
    private int noOfPassenger;
    private String transmissionType;
    private String fuelType;
    private double dailyRate;
    private double monthlyRate;
    private int freeKmForDay;
    private int freeKmForMonth;
    private double pricePerKm;
    private CategoryDTO categoryDTO;
}
