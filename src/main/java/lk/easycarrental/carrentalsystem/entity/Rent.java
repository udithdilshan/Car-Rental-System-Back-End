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
public class Rent {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String rentId;
    private String pickUpDateTime;
    private String returnDateTime;
    private String pickUpLocation;
    private String returnUpLocation;
    private String actualReturnDateTime;
    private int noOfCars;
    private String status;
    private String addedDateTime;
    private String note;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    @OneToOne(mappedBy = "rent",cascade = CascadeType.ALL)
    private Payment payment;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "carId",referencedColumnName = "carId" ,nullable = false)
//    private CarDetail carDetail;

    @OneToMany(mappedBy = "rent",cascade = CascadeType.ALL)
    private List<RentDetail> rentDetails=new ArrayList();

}
