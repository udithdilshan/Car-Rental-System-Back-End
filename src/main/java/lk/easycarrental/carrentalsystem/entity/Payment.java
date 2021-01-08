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
public class Payment {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String paymentId;
    private  double amount;
    private   String status;
    private  String paymentDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentId", referencedColumnName = "rentId", nullable = false)
    private  Rent rent;
}
