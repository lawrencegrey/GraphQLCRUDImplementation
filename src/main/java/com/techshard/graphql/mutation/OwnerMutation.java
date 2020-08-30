package com.techshard.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.techshard.graphql.dao.entity.Owner;

import com.techshard.graphql.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class OwnerMutation implements GraphQLMutationResolver {

    @Autowired
    private OwnerService ownerService;
   

    public Owner createOwner(final String name) {
        return this.ownerService.createOwner(name);
    }

    public Owner updateOwner(final int id, final String name)
    {
        return this.ownerService.updateOwner(id, name);
    }

    public Owner deleteOwner(final int id)
    {
        return this.ownerService.deleteOwner(id);
    }
   
}
