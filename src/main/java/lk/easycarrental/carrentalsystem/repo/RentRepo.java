package lk.easycarrental.carrentalsystem.repo;

import lk.easycarrental.carrentalsystem.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepo extends JpaRepository<Rent,String> {
}
