package lk.easycarrental.carrentalsystem.repo;

import lk.easycarrental.carrentalsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

//    boolean existsByEmailAndPasswordEquals(String s);
}
