package com.techshard.graphql.service;

import com.techshard.graphql.dao.entity.Owner;

import com.techshard.graphql.dao.repository.OwnerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerService {

   
    private final OwnerRepository ownerRepository ;

    public OwnerService(final OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository ;
       
    }

    @Transactional
    public Owner createOwner(final String name) {
        final Owner Owner = new Owner();
        Owner.setName(name);       
     
        return this.ownerRepository.save(Owner);
    }

    @Transactional
    public Owner updateOwner(final int id, final String name) {
       Owner owner = this.ownerRepository.findOwnerById(id);

        owner.setName(name);
     
        return this.ownerRepository.save(owner);
    }

    @Transactional
    public Owner deleteOwner(final int ownerd) {
       Owner owner = this.ownerRepository.findOwnerById(ownerd);

           
        this.ownerRepository.delete(owner);

        return owner;
        
    }




    @Transactional(readOnly = true)
    public List<Owner> getAllOwners() {
        return this.ownerRepository.findAll().stream().collect(Collectors.toList());
    }

     @Transactional(readOnly = true)
    public Optional<Owner> getOwner(final int id) {
        return this.ownerRepository.findById(id);
    }

   
}
