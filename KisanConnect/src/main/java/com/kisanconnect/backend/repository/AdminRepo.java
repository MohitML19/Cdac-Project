package com.kisanconnect.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kisanconnect.backend.entity.Admin;


public interface AdminRepo extends JpaRepository<Admin, Integer>
{
	
}
