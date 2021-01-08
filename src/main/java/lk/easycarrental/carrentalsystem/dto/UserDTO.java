package lk.easycarrental.carrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
   private String userId;
   private String name;
   private String email;
   private String password;
   private String address;
   private String contactNumber;
   private String role;
   private String createdDate;
   private boolean verified;
}
