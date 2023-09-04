package com.kisanconnect.backend.service;

import com.kisanconnect.backend.entity.Buyer;
import com.kisanconnect.backend.entity.Farmer;

public interface ProfileService {
	
	String updateFarmerProfile(String username,Farmer farmer);
	
	String updateBuyerProfile(String username,Buyer buyer);

}
