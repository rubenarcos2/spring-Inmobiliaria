package com.rarcos.real_estate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rarcos.real_estate.models.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

}
