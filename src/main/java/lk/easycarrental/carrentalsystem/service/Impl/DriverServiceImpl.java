package lk.easycarrental.carrentalsystem.service.Impl;

import lk.easycarrental.carrentalsystem.dto.DriverDTO;
import lk.easycarrental.carrentalsystem.entity.Driver;
import lk.easycarrental.carrentalsystem.repo.DriverRepo;
import lk.easycarrental.carrentalsystem.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if (!repo.existsById(driverDTO.getDriverId())){
            Driver driver=mapper.map(driverDTO,Driver.class);
            repo.save(driver);
        }else{
            throw new RuntimeException("Driver already exist !");
        }
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if (repo.existsById(driverDTO.getDriverId())){
            Driver driver=mapper.map(driverDTO,Driver.class);
            repo.save(driver);
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        Optional<Driver> driver=repo.findById(id);
        if (driver.isPresent()){
           return mapper.map(driver.get(),DriverDTO.class);
        }else {
            throw new RuntimeException("No Driver for Id "+id);
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("No Driver For delete Driver Id "+id);
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        List<Driver> all = repo.findAll();
        return mapper.map(all,new TypeToken<List<DriverDTO>>(){}.getType());
    }
}
