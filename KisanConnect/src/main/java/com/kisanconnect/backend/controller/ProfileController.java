package com.kisanconnect.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kisanconnect.backend.entity.Buyer;
import com.kisanconnect.backend.entity.Farmer;
import com.kisanconnect.backend.repository.BuyerCartRepo;
import com.kisanconnect.backend.repository.BuyerRepo;
import com.kisanconnect.backend.repository.FarmerRepo;
import com.kisanconnect.backend.repository.OrderRepo;
import com.kisanconnect.backend.repository.ProductRepo;
import com.kisanconnect.backend.service.ProfileService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("change-profile")
public class ProfileController 
{
	@Autowired
	ProfileService profileService ;
	
	
	
	@PostMapping("farmer/{username}")
	public String updateFarmerProfile(@PathVariable String username,@RequestBody Farmer farmer)
	{
		String message = this.profileService.updateFarmerProfile(username,farmer);
		
		return message;
	}
	
	@PostMapping("buyer/{username}")
	public String updateBuyerProfile(@PathVariable String username,@RequestBody Buyer buyer)
	{
		String message = this.profileService.updateBuyerProfile(username,buyer);
		
		return message;
	}
}
