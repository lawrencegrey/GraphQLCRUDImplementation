package com.techshard.graphql.dao.repository;

import com.techshard.graphql.dao.entity.Owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    Owner findOwnerById(final int ownerid);
}
