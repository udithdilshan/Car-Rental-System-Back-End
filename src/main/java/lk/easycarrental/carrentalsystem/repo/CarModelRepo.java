package lk.easycarrental.carrentalsystem.repo;

import lk.easycarrental.carrentalsystem.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepo extends JpaRepository<CarModel,String> {
    boolean existsByBrandName(String brandName);
}
