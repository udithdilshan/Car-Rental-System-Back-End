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
public class Driver {
    @Id
    private String driverId;
    private String drivingLicenseNumber;
    private String drivingLicensePic1;
    private String drivingLicensePic2;
    private String registeredDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<DriverSchedule> driverSchedules = new ArrayList();

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    private List<RentDetail> rentDetails=new ArrayList();

}
