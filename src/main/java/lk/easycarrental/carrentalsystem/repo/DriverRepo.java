package lk.easycarrental.carrentalsystem.repo;

import lk.easycarrental.carrentalsystem.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
}
