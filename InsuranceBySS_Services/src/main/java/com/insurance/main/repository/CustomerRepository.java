package com.insurance.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.main.bean.CustomerBean;

public interface CustomerRepository extends JpaRepository<CustomerBean, String>{
	
	

}
