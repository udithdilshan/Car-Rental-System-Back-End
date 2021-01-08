package lk.easycarrental.carrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DriverSchedule {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String driveScheduleId;
    private String startDateTime;
    private String endDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId",referencedColumnName ="driverId",nullable = false)
    private Driver driver;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentDetailId",referencedColumnName = "rentDetailId",nullable = false)
    private RentDetail rentDetail;
}
