package lk.easycarrental.carrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO {
    private String bankAccountId;
    private String bankAccountNo;
    private String bankName;
    private String bankBranch;
    private String addedDateTime;
    private AdminDTO adminDTO;
}
