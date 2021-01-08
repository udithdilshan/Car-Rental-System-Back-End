package lk.easycarrental.carrentalsystem.repo;

import lk.easycarrental.carrentalsystem.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAccount,String> {
}
