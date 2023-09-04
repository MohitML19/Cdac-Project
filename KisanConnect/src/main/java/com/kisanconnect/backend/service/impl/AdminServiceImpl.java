package com.kisanconnect.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kisanconnect.backend.entity.Admin;
import com.kisanconnect.backend.entity.Buyer;
import com.kisanconnect.backend.entity.Farmer;
import com.kisanconnect.backend.entity.Order;
import com.kisanconnect.backend.entity.Product;
import com.kisanconnect.backend.repository.AdminRepo;
import com.kisanconnect.backend.repository.BuyerRepo;
import com.kisanconnect.backend.repository.FarmerRepo;
import com.kisanconnect.backend.repository.OrderRepo;
import com.kisanconnect.backend.repository.ProductRepo;
import com.kisanconnect.backend.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	BuyerRepo buyerRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	FarmerRepo farmerRepo;

	@Override
	public String adminLogin(Admin admin) {
		//System.out.println(admin.getPassword());
		//System.out.println(admin.getUser_name());
		List<Admin> adminList = adminRepo.findAll();              
		
		String passMsg = "pass" ;
		String failMsg = "fail" ;
		
		for(Admin adminobj : adminList )
		{
		if(adminobj.getUser_name().equals(admin.getUser_name()) && adminobj.getPassword().equals(admin.getPassword()))
			{
				
				return passMsg ;
			}
		}
	
	return failMsg;
	}
	

	@Override
	public List<Buyer> getAllBuyers() {
		List<Buyer> buyerList = buyerRepo.findAll();
		return buyerList;
	}
	

	@Override
	public List<Farmer> getAllFarmers() {
		List<Farmer> farmerList = farmerRepo.findAll();              
		return farmerList;
	}
	

	@Override
	public List<Order> getAllOrders() {
		List<Order> farmerList = orderRepo.findAll();              
		
		return farmerList;
	}

	
	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = productRepo.findAll();              
		
		return productList;
	}
	
	@Override
	public void deleteBuyerByid(Integer id)
	{
		buyerRepo.deleteById(id);
	}
	
	@Override
	public void deleteFarmerByid(Integer id)
	{
		farmerRepo.deleteById(id);
	}


}
