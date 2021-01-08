package lk.easycarrental.carrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarSchedule {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String carScheduleId;
    private String pickUpDateTime;
    private String returnDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "carId", nullable = false)
    private CarDetail carDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentDetailId",referencedColumnName = "rentDetailId" ,nullable = false)
    private RentDetail rentDetail;
}
