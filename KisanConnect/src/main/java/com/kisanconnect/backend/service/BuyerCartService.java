package com.kisanconnect.backend.service;

import com.kisanconnect.backend.entity.BuyerCart;

public interface BuyerCartService {
	
	String addItem(BuyerCart cart);
	
	String removeItem(BuyerCart cart);
	
	

}
