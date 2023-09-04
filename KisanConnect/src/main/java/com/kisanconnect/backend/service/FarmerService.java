package com.kisanconnect.backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.kisanconnect.backend.entity.Farmer;
import com.kisanconnect.backend.entity.Order;
import com.kisanconnect.backend.entity.Product;

public interface FarmerService {
	
	
	Farmer getFarmer(String username);
	
	String forgotPassword(Farmer farmer);
	
	String regFarmer(Farmer farmer);
	
	String loginUser(Farmer farmer);
	
	List<Order> getDetailsByFarmer(Farmer farmer);
	
	String addProduct(Product product);
	
	String getOrder(Order order);
	
	
	
	

}
