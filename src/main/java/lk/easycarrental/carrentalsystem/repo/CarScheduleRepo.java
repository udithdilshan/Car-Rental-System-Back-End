package lk.easycarrental.carrentalsystem.repo;

import lk.easycarrental.carrentalsystem.entity.CarSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarScheduleRepo extends JpaRepository<CarSchedule,String> {
}
