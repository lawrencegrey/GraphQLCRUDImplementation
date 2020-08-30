package com.techshard.graphql.service;

import com.techshard.graphql.dao.entity.OwnerVehicle;

import com.techshard.graphql.dao.repository.OwnerVehicleRepository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerVehicleService {

    private final OwnerVehicleRepository ownerVehicleRepository ;
    

    public OwnerVehicleService(
        final OwnerVehicleRepository ownerRepository
       ) {
        this.ownerVehicleRepository = ownerRepository ;
      
       
    }

    @Transactional
    public OwnerVehicle createOwnerVehicle(final int vehicleId, final int nameId) {
        final OwnerVehicle OwnerVehicle = new OwnerVehicle();

         OwnerVehicle.setOwnerId(nameId);
         OwnerVehicle.setVehicleId(vehicleId);
            
        return this.ownerVehicleRepository.save(OwnerVehicle);
    }


    @Transactional
    public OwnerVehicle deleteOwnerVehicle(final int id) {
        OwnerVehicle ownervehicle = this.ownerVehicleRepository.findOwnerVehicleById(id);

           
        this.ownerVehicleRepository.delete(ownervehicle);

        return ownervehicle;
    }





    @Transactional(readOnly = true)
    public List<OwnerVehicle> getAllOwnerVehicles() {
        return this.ownerVehicleRepository.findAll().stream().collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OwnerVehicle> getVehicleByOwner(final int ownerid) {
        return this.ownerVehicleRepository.findByOwnerIdOrderByVehicleBrandNameAsc(ownerid).stream().collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public Optional<OwnerVehicle> getOwnerVehicle(final int id) {
        return this.ownerVehicleRepository.findById(id);
    }


}
