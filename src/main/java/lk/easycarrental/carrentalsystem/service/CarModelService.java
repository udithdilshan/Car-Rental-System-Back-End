package lk.easycarrental.carrentalsystem.service;

import lk.easycarrental.carrentalsystem.dto.CarModelDTO;
import lk.easycarrental.carrentalsystem.dto.CategoryDTO;

import java.util.List;

public interface CarModelService {
    void saveCarModel(CarModelDTO carModelDTO);

    void updateCarModel(CarModelDTO carModelDTO);

    void deleteCarModel(String carModelId);

    CarModelDTO searchCarModel(String carModelId);

    List<CarModelDTO> getAllCarModel();
}
