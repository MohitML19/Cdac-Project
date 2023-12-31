package com.kisanconnect.backend.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.kisanconnect.backend.entity.Farmer;



public interface FarmerRepo  extends JpaRepository<Farmer, Integer>
{
	

//	@Modifying
//	@Query(name="changePassword",nativeQuery=true,value="update table_emp set password=:pwd where username=:uname")
//	@Transactional
//	public void changePassword(@Param("uname") String userName,@Param("pwd") String password);
	@Query( nativeQuery = true,value="select fid from farmers where user_name=:user_name")
	public int findByName(@Param("user_name") String user_name);
	
	@Query( nativeQuery = true,value="select fid from farmers where firstname=:name")
	public int findByFid(@Param("name") String name);
	
	@Modifying
	@Transactional
	@Query( nativeQuery = true,value="update farmers set firstname=:firstname where user_name=:user_name")
	public void updateFirstName(@Param("firstname") String firstname,@Param("user_name") String user_name );
	
	@Modifying
	@Transactional
	@Query( nativeQuery = true,value="update farmers set lastname =:lastname where user_name=:user_name")
	public void updateLastName(@Param("lastname") String lastname,@Param("user_name") String user_name );
	
	@Modifying
	@Transactional
	@Query( nativeQuery = true,value="update farmers set  email =:email  where user_name=:user_name")
	public void updateEmail(@Param("email") String email,@Param("user_name") String user_name );
	
	@Modifying
	@Transactional
	@Query( nativeQuery = true,value="update farmers set  contact =:contact  where user_name=:user_name")
	public void updateContact(@Param("contact") String contact,@Param("user_name") String user_name );
	
	@Modifying
	@Transactional
	@Query( nativeQuery = true,value="update farmers set password=:password  where user_name=:user_name")
	public void updatePassword(@Param("password") String password,@Param("user_name") String user_name );
	
	@Modifying
	@Transactional
	@Query( nativeQuery = true,value="update farmers set  address =:address  where user_name=:user_name")
	public void updateAddress(@Param("address") String address,@Param("user_name") String user_name );
	
	
	
	
}
