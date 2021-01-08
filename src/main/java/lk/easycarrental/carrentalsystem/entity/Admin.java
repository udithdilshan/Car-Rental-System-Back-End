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
public class Admin {
    @Id
    String adminId;
    String createdDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId",nullable = false)
    User user;

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    private List<BankAccount> bankAccounts=new ArrayList();

}
