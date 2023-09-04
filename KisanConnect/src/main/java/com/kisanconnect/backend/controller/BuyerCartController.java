package com.kisanconnect.backend.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kisanconnect.backend.entity.BuyerCart;
import com.kisanconnect.backend.service.BuyerCartService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/buyer-cart")
public class BuyerCartController 
{
	@Autowired
	BuyerCartService buyerCartService;
	
	@PostMapping("/add")
	public String regFarmer(@RequestBody BuyerCart cart) {
		String message = this.buyerCartService.addItem(cart);
		
		return message;
	}
	
	
	@PostMapping("/remove")
	public String removeItem(@RequestBody BuyerCart cart) {
		String message = this.buyerCartService.removeItem(cart);
		
		return message;
	}
	
}
