package com.kisanconnect.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kisanconnect.backend.entity.Buyer;
import com.kisanconnect.backend.entity.BuyerCart;
import com.kisanconnect.backend.entity.Order;
import com.kisanconnect.backend.entity.Product;
import com.kisanconnect.backend.exceptions.ResourceNotFoundException;
import com.kisanconnect.backend.repository.BuyerCartRepo;
import com.kisanconnect.backend.repository.BuyerRepo;
import com.kisanconnect.backend.repository.FarmerRepo;
import com.kisanconnect.backend.repository.OrderRepo;
import com.kisanconnect.backend.repository.ProductRepo;
import com.kisanconnect.backend.service.BuyerService;

@Service
public class BuyerServiceImpl implements BuyerService {
	
	@Autowired
	BuyerRepo buyerRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	BuyerCartRepo buyercartRepo;
	
	@Autowired
	FarmerRepo farmerRepo;

	@Override
	public String buyerLogin(Buyer buyer) {
		
		//System.out.println(buyer.getPassword());
		//System.out.println(buyer.getUser_name());
		List<Buyer> buyerList = buyerRepo.findAll();              
		
		String passMsg = "pass" ;
		String failMsg = "fail" ;
		
		for(Buyer buyerobj : buyerList )
		{
		if(buyerobj.getUser_name().equals(buyer.getUser_name()) && buyerobj.getPassword().equals(buyer.getPassword()))
			{
				
				return passMsg ;
			}
		}
	
	     return failMsg;
	}
	

	@Override
	public String registerBuyer(Buyer buyer) {
		 
		buyerRepo.save(buyer);
		String  email = buyer.getEmail();
		EmailServiceImpl.sendMail(email);
	     
		return "register_success";
	}

	@Override
	public List<Product> getProductByCrop(Product prod) {
		
		String item = prod.getCrop();
		List<Product> productList = productRepo.findProduct(item);              
	
		return productList;
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<Product> productList = productRepo.findAll();              
		
		return productList;
	}

	@Override
	public List<BuyerCart> getBuyerCart() {
		
		List<BuyerCart> cartlist = buyercartRepo.findAll();              
		
		return cartlist;
	}

	@Override
	public List<Order> ConfirmOrders(Buyer buyer) {
		
		//System.out.println(buyer.getUser_name());
		String uname = buyer.getUser_name();
		
		int bid = buyerRepo.findByName(uname);
		
		List<Order> orderList = orderRepo.findByBId(bid);  
		
		return orderList;
	}

	@Override
	public String addOrder(Order order) {
		
		String buyeruname = order.getBuyer().getUser_name();
		
		//System.out.println(buyeruname);
		int bid = buyerRepo.findByName(buyeruname);
		order.getBuyer().setBid(bid);
			
		String farmername = order.getFarmer().getFirstname();
		//System.out.println(farmername);
		int fid = farmerRepo.findByFid(farmername);
		order.getFarmer().setFid(fid);
		orderRepo.save(order);
		     
		return "added";
	}

	@Override
	public Buyer getBuyers(String username) {
		//System.out.println("im here");
		
		int bid = buyerRepo.findByName(username);
        
		Buyer buyer =buyerRepo.findById(bid).orElseThrow(()-> new ResourceNotFoundException("buyer", "Id", bid));
		
		return buyer;
	}

}
