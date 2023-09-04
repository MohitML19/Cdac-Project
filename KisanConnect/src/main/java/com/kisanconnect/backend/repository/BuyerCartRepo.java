package com.kisanconnect.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kisanconnect.backend.entity.BuyerCart;


public interface BuyerCartRepo extends JpaRepository<BuyerCart, Integer> {

}
