package lk.easycarrental.carrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RentDetail {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String rentDetailId;
    boolean driverRequired;
    double startMileage;
    double endMileage;
    String loseDamageWaiverPic;
    double paymentAmount;
    double deductAmount;
    String string;
    String addedDate;
    String returnDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentId",referencedColumnName = "rentId",nullable = false)
    private Rent rent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId",referencedColumnName = "driverId")
    private Driver driver;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId",referencedColumnName = "carId",nullable = false)
    private CarDetail carDetail;

    @OneToOne(mappedBy = "rentDetail",cascade = CascadeType.ALL)
    private CarSchedule carSchedule;

    @OneToOne(mappedBy = "rentDetail",cascade = CascadeType.ALL)
    private DriverSchedule driverSchedule;

}
