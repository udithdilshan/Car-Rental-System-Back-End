package lk.easycarrental.carrentalsystem.repo;

import lk.easycarrental.carrentalsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
