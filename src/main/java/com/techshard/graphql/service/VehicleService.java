package com.techshard.graphql.service;


import com.techshard.graphql.dao.entity.Vehicle;
import com.techshard.graphql.dao.repository.VehicleRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository ;


    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository ;
       
    }

    @Transactional
    public Vehicle createVehicle(final String type,final String modelCode, final String brandName, final String launchDate) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.vehicleRepository.save(vehicle);
    }


    @Transactional
    public Vehicle updateVehicle(Vehicle info) {

        Vehicle vehicle = this.vehicleRepository.findVehicleById((info.getId()));

      
        vehicle.setType(info.getType());
        vehicle.setModelCode(info.getModelCode());
        vehicle.setBrandName(info.getBrandName());
        vehicle.setLaunchDate(info.getLaunchDate());
        return this.vehicleRepository.save(vehicle);
    }

    @Transactional
    public Vehicle deleteVehicle(final int id) {
        Vehicle vehicle = this.vehicleRepository.findVehicleById(id);

           
        this.vehicleRepository.delete(vehicle);

        return vehicle;
    }


    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles() {
        return this.vehicleRepository.findAll().stream().collect(Collectors.toList());
    }



    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleRepository.findById(id);
    }

}
