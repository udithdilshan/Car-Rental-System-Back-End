package lk.easycarrental.carrentalsystem.repo;

import lk.easycarrental.carrentalsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {
    boolean existsByCategoryName(String name);
    Category findByCategoryName(String categoryName);
}
