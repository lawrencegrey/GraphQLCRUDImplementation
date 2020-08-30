package com.techshard.graphql.mutation;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.techshard.graphql.dao.entity.OwnerVehicle;
import com.techshard.graphql.service.OwnerVehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class OwnerVehicleMutation implements GraphQLMutationResolver {

    @Autowired
    private OwnerVehicleService ownerVehicleService;
   

    public OwnerVehicle createOwnerVehicle(final int vehicleId, final int nameId) {
        return this.ownerVehicleService.createOwnerVehicle(vehicleId, nameId);
    }

    public OwnerVehicle deleteOwnerVehicle(final int id)
    {
         return this.ownerVehicleService.deleteOwnerVehicle(id);

          
    }

   
}
