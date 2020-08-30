package com.techshard.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.techshard.graphql.dao.entity.Owner;
import com.techshard.graphql.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OwnerQuery implements GraphQLQueryResolver {

    @Autowired
    private OwnerService ownerService;

    public List<Owner> getOwners() {
        return this.ownerService.getAllOwners();
    }


    public Optional<Owner> getOwner(final int id) {
        return this.ownerService.getOwner(id);
    }
}
