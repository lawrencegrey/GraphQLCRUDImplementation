package com.techshard.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.techshard.graphql.dao.entity.OwnerVehicle;

import com.techshard.graphql.service.OwnerVehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OwnerVehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private OwnerVehicleService ownerVehicleService;


    public List<OwnerVehicle> getOwnerVehicles() {
        return this.ownerVehicleService.getAllOwnerVehicles();
    }

    public List<OwnerVehicle> getVehiclesByOwner(final int ownerid) {
        return this.ownerVehicleService.getVehicleByOwner(ownerid);
    }




    public Optional<OwnerVehicle> getOwnerVehicle(final int id) {
        return this.ownerVehicleService.getOwnerVehicle(id);
    }
}
