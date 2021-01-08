package lk.easycarrental.carrentalsystem.service.Impl;

import lk.easycarrental.carrentalsystem.dto.CategoryDTO;
import lk.easycarrental.carrentalsystem.entity.Category;
import lk.easycarrental.carrentalsystem.repo.CategoryRepo;
import lk.easycarrental.carrentalsystem.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        if (!categoryRepo.existsByCategoryName(categoryDTO.getCategoryName())) {
            categoryRepo.save(mapper.map(categoryDTO, Category.class));
        } else {
            throw new RuntimeException("Category name already exist !");
        }
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {
        if (categoryRepo.existsById(categoryDTO.getCategoryId())) {
            categoryRepo.save(mapper.map(categoryDTO, Category.class));
        } else {
            throw new RuntimeException("Category doesn't exist!");
        }
    }

    @Override
    public void deleteCategory(String categoryId) {
        if (categoryRepo.existsById(categoryId)) {
            categoryRepo.deleteById(categoryId);
        } else {
            throw new RuntimeException("No category found for " + categoryId);
        }
    }

    @Override
    public CategoryDTO searchCategory(String categoryId) {
        Optional<Category> category = categoryRepo.findById(categoryId);
        if (category.isPresent()) {
            return mapper.map(category.get(), CategoryDTO.class);
        } else {
            throw new RuntimeException("No category found by " + categoryId);
        }
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> all = categoryRepo.findAll();
        return mapper.map(all, new TypeToken<List<CategoryDTO>>() {
        }.getType());
    }
}
