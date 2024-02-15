package com.insurance.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurance.main.bean.CustomerBean;

public interface CustomerRepository extends JpaRepository<CustomerBean, String>{

	@Query("select customerFirstName from CustomerBean")
	List<String> findByCustomerFirstName();
	
	

}
