package com.kisanconnect.backend.service;

import java.util.List;

import com.kisanconnect.backend.entity.Admin;
import com.kisanconnect.backend.entity.Buyer;
import com.kisanconnect.backend.entity.Farmer;
import com.kisanconnect.backend.entity.Order;
import com.kisanconnect.backend.entity.Product;

public interface AdminService {
	
	String adminLogin(Admin admin);
	
	List<Buyer>getAllBuyers();
	
	List<Farmer>getAllFarmers();
	
	List<Order>getAllOrders();
	
	List<Product>getAllProducts();
	
	
	void deleteBuyerByid(Integer id);
	
	void deleteFarmerByid(Integer id);

	
}
