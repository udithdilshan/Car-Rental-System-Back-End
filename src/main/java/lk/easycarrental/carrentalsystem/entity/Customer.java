package lk.easycarrental.carrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    private String customerId;
    private String nic;
    private String nicPic1;
    private String nicPic2;
    private String drivingLicenseNumber;
    private String drivingLicensePic1;
    private String drivingLicensePic2;
    private boolean verified;
    private boolean activeRented;
    private String registeredDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId" , nullable = false)
    private User user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Rent> rents=new ArrayList();

}
