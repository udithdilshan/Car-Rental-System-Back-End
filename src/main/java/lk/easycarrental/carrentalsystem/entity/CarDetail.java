package lk.easycarrental.carrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CarDetail {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String carId;
    private String registrationNo;
    private String mileage;
    private String color;
    private String frontPic;
    private String backPic;
    private String sidePic;
    private String interiorPic;
    private double maintenance_Km;
    private String onMaintenance;
    private boolean available;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "modelId",referencedColumnName = "modelId",nullable = false)
    private CarModel model;

    @OneToMany(mappedBy = "carDetail",cascade = CascadeType.ALL)
    private List<CarSchedule> carSchedules=new ArrayList();

//    @OneToMany(mappedBy = "carDetail", cascade = CascadeType.ALL)
//    private List<Rent> rents=new ArrayList();

    @OneToMany(mappedBy = "carDetail",cascade = CascadeType.ALL)
    private List<RentDetail> rentDetails=new ArrayList();
}
