package com.kisanconnect.backend.service;

import java.util.List;
import java.util.Optional;

import com.kisanconnect.backend.entity.Buyer;
import com.kisanconnect.backend.entity.BuyerCart;
import com.kisanconnect.backend.entity.Order;
import com.kisanconnect.backend.entity.Product;

public interface BuyerService {
	
	String buyerLogin(Buyer buyer);
	
	String registerBuyer(Buyer buyer);
	
	List<Product> getProductByCrop(Product prod);
	
	List<Product>getAllProducts();
	
	List<BuyerCart>getBuyerCart();
	
	List<Order>ConfirmOrders(Buyer buyer);
	
	String addOrder(Order order);
	
	Buyer getBuyers(String username);

}
