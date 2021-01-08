package lk.easycarrental.carrentalsystem.repo;

import lk.easycarrental.carrentalsystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
}
