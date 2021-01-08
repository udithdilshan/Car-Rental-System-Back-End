package lk.easycarrental.carrentalsystem.repo;

import lk.easycarrental.carrentalsystem.entity.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDetailRepo extends JpaRepository<CarDetail,String> {
}
