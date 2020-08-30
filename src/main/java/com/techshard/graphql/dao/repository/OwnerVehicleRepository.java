package com.techshard.graphql.dao.repository;

import java.util.List;

import com.techshard.graphql.dao.entity.OwnerVehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerVehicleRepository extends JpaRepository<OwnerVehicle, Integer> {

    List<OwnerVehicle> findByOwnerIdOrderByVehicleBrandNameAsc(final int ownerid);
    OwnerVehicle findOwnerVehicleById(final int id);
}
