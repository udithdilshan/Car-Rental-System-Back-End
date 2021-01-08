package lk.easycarrental.carrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private String paymentId;
    private double amount;
    private String status;
    private String paymentDateTime;
    private RentDTO rentDTO;
}
