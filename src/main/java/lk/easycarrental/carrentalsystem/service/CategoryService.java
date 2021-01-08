package lk.easycarrental.carrentalsystem.service;

import lk.easycarrental.carrentalsystem.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    void addCategory(CategoryDTO categoryDTO);

    void updateCategory(CategoryDTO categoryDTO);

    void deleteCategory(String categoryId);

    CategoryDTO searchCategory(String categoryId);

    List<CategoryDTO> getAllCategory();

}
