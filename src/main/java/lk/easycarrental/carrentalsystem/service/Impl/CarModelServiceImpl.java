package lk.easycarrental.carrentalsystem.service.Impl;

import lk.easycarrental.carrentalsystem.dto.CarModelDTO;
import lk.easycarrental.carrentalsystem.entity.CarModel;
import lk.easycarrental.carrentalsystem.entity.Category;
import lk.easycarrental.carrentalsystem.repo.CarModelRepo;
import lk.easycarrental.carrentalsystem.repo.CategoryRepo;
import lk.easycarrental.carrentalsystem.service.CarModelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    CarModelRepo carModelRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCarModel(CarModelDTO carModelDTO) {
        if (!carModelRepo.existsByBrandName(carModelDTO.getBrandName())) {
            if (categoryRepo.existsByCategoryName(carModelDTO.getModelId())) {
                Category category = categoryRepo.findByCategoryName(carModelDTO.getModelId());
                CarModel carModel = mapper.map(carModelDTO, CarModel.class);
                carModel.setCategory(category);
                carModelRepo.save(carModel);
            }else{
                throw new RuntimeException("Category doesn,t exist !");
            }
        } else {
            throw new RuntimeException("Brand Name already exist !");
        }
    }

    @Override
    public void updateCarModel(CarModelDTO carModelDTO) {
        if (carModelRepo.existsById(carModelDTO.getModelId())) {
            carModelRepo.save(mapper.map(carModelDTO, CarModel.class));
        } else {
            throw new RuntimeException("Car Model doesn't exist!");
        }
    }

    @Override
    public void deleteCarModel(String carModelId) {
        if (carModelRepo.existsById(carModelId)) {
            carModelRepo.deleteById(carModelId);
        } else {
            throw new RuntimeException("No Car model found for " + carModelId);
        }
    }

    @Override
    public CarModelDTO searchCarModel(String carModelId) {
        Optional<CarModel> carModel = carModelRepo.findById(carModelId);
        if (carModel.isPresent()) {
            return mapper.map(carModel.get(), CarModelDTO.class);
        } else {
            throw new RuntimeException("No Car model found by " + carModelId);
        }
    }

    @Override
    public List<CarModelDTO> getAllCarModel() {
        List<CarModel> all = carModelRepo.findAll();
        return mapper.map(all, new TypeToken<List<CarModelDTO>>() {
        }.getType());
    }
}
