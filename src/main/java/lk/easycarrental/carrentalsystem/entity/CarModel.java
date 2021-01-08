package lk.easycarrental.carrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CarModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String modelId;
    String type;
    String brandName;
    int noOfPassenger;
    String transmissionType;
    String fuelType;
    double dailyRate;
    double monthlyRate;
    int freeKmForDay;
    int freeKmForMonth;
    double pricePerKm;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "model",cascade = CascadeType.ALL)
    private List<CarDetail> carDetails=new ArrayList();
}
