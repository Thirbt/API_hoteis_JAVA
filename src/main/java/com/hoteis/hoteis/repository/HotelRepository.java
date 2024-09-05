package com.hoteis.hoteis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoteis.hoteis.models.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    
}
