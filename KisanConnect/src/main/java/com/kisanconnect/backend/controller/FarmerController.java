package com.kisanconnect.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kisanconnect.backend.entity.Farmer;
import com.kisanconnect.backend.entity.Order;
import com.kisanconnect.backend.entity.Product;
import com.kisanconnect.backend.service.EmailService;
import com.kisanconnect.backend.service.FarmerService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/farmer")
public class FarmerController 
{
	@Autowired
	FarmerService farmerService;
	@Autowired
	EmailService emailserv;
	@GetMapping("/profile/{username}")
	public Farmer getFarmer(@PathVariable String username) {
		
		Farmer farmer = this.farmerService.getFarmer(username);
		
		return farmer;    
	}
	
	
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestBody Farmer farmer)
	{
		String message = this.farmerService.forgotPassword(farmer);
		
		return message;
	}
	
	
	
	@PostMapping("/Registration")
	public String regFarmer(@Valid @RequestBody Farmer farmer) {

		farmerService.regFarmer(farmer);
		String email=farmer.getEmail();
		emailserv.sendEmail("kisanconnect007@gmail.com", email, "Welcome to kisanconnect", "you are successfully registerd to KRISHIMANTRA with username="+farmer.getUser_name()+" and password="+farmer.getPassword());
		return "data added";
	}
	
	
	@PostMapping("/login")
	public String loginUser(@RequestBody Farmer farmer) {
	     
		String message = this.farmerService.loginUser(farmer);
			
		return message;
	}
	
	
	@PostMapping("/orders")
	public List<Order> getDetails(@RequestBody Farmer farmer)
	{
		List<Order> orderList =this.farmerService.getDetailsByFarmer(farmer);
		
		return orderList;
		
	}
	
	
	
	@PostMapping("/add-product")
	public String addProducts(@RequestBody Product product)
	{
		String message = this.farmerService.addProduct(product);
		
		return message;
		
	}
	
	@PostMapping("/orders/change-status")
	public String getOrder(@RequestBody Order order)
	{
		System.out.println("im here");
		String message = this.farmerService.getOrder(order);
		
		return message;
		
	}
	
}
