package lk.easycarrental.carrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {
   @Id
   @GeneratedValue(generator = "uuid")
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   private String userId;
   private String name;
   private String email;
   private String password;
   private String address;
   private String contactNumber;
   private boolean verified;

   @Enumerated(EnumType.STRING)
   @Column(length = 10, columnDefinition = "varchar(10) default 'CUSTOMER'",nullable = false)
   private Role role;
   private String createdDate;

   @OneToOne(mappedBy = "user" , cascade =  CascadeType.ALL)
   private Admin admin;

   @OneToOne(mappedBy = "user" , cascade =  CascadeType.ALL)
   private Customer customer;

   @OneToOne(mappedBy = "user" , cascade =  CascadeType.ALL)
   private Driver driver;

}
enum Role{
   CUSTOMER,ADMIN,DRIVER
}
