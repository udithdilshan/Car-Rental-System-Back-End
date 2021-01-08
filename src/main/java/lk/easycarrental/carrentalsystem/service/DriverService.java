package lk.easycarrental.carrentalsystem.service;

import lk.easycarrental.carrentalsystem.dto.DriverDTO;

import java.util.List;

public interface DriverService{
    void saveDriver(DriverDTO driverDTO);
    void updateDriver(DriverDTO driverDTO);
    DriverDTO searchDriver(String id);
    void deleteDriver(String id);
    List<DriverDTO> getAllDriver();
}
