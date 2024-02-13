/**
 * 
 */
package com.insurance.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.main.bean.CustomerBean;
import com.insurance.main.dao.DataDao;
import com.insurance.main.logics.CustomerRefId;
import com.insurance.main.repository.CustomerRepository;
import com.insurance.main.response.CustomerResponse;

/**
 * @author Narsingh Mahankali
 *
 */

@Service
public class CustomerServiceImplementation implements CustomerService {
	/*
	 * @Autowired DataDao dao;
	 */
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public int insertCustomerData(CustomerBean customerBean) {
		if(customerBean != null && customerBean.getCustomerReferanceId() == null) {
			customerBean.setCustomerReferanceId(CustomerRefId.getCustomerRefId());
		}
		customerRepo.save(customerBean);
		//return dao.insertCustomerData(customerBean);
		return 1;
	}

	@Override
	public int updateCustomerData(CustomerBean customerBean) {
		//String id = "'"+customerBean.getCustomerReferanceId()+"'";
		//List<CustomerBean> customerList = dao.searchCustomerWithRefID(id);
		/*
		 * Optional<CustomerBean> customerList =
		 * customerRepo.findById(customerBean.getCustomerReferanceId());
		 * 
		 * if(!customerList.isPresent()) { return 0; } customerList.ifPresent(val -> {
		 * if(compareString(val.getCustomerFirstName(),customerBean.getCustomerFirstName
		 * ())) { customerBean.setCustomerFirstName(null); }
		 * if(compareString(val.getCustomerLastName(),customerBean.getCustomerLastName()
		 * )) { customerBean.setCustomerLastName(null); }
		 * if(compareString(val.getCustomerAddress(),customerBean.getCustomerAddress()))
		 * { customerBean.setCustomerAddress(null); }
		 * if(compareString(val.getCustomerDOB(),customerBean.getCustomerDOB())) {
		 * customerBean.setCustomerDOB(null); }
		 * 
		 * 
		 * });
		 */
		/*
		 * for(CustomerBean tempCustomer : customerList) {
		 * if(compareString(tempCustomer.getCustomerFirstName(),customerBean.
		 * getCustomerFirstName())) { customerBean.setCustomerFirstName(null); }
		 * if(compareString(tempCustomer.getCustomerLastName(),customerBean.
		 * getCustomerLastName())) { customerBean.setCustomerLastName(null); }
		 * if(compareString(tempCustomer.getCustomerAddress(),customerBean.
		 * getCustomerAddress())) { customerBean.setCustomerAddress(null); }
		 * if(compareString(tempCustomer.getCustomerDOB(),customerBean.getCustomerDOB())
		 * ) { customerBean.setCustomerDOB(null); } }
		 */
		customerRepo.save(customerBean);
		return 1;//dao.updateCustomerData(customerBean);
	}
	
	private boolean compareString(String tempValue,String exactValue) {
		if(tempValue == null || exactValue == null) {
			return false;
		}
		return tempValue.equalsIgnoreCase(exactValue);
	}

	@Override
	public CustomerResponse searchCustomerWithRefID(String customerReferanceId) {
		List<CustomerResponse> response = new ArrayList<>();
		Optional<CustomerBean> customerList = customerRepo.findById(customerReferanceId);
		customerList.ifPresent(val -> {
			CustomerResponse res = new CustomerResponse();
			res.setCustomerReferanceId(val.getCustomerReferanceId());
			res.setCustomerFirstName(val.getCustomerFirstName());
			res.setCustomerLastName(val.getCustomerLastName());
			res.setCustomerDOB(val.getCustomerDOB());
			res.setCustomerAddress(val.getCustomerAddress());
			response.add(res);
		});
		
		return response != null && !response.isEmpty() ? response.get(0) : null;
	}

	@Override
	public int deleteCustomerData(String customerReferanceId) {
		//return dao.deleteCustomerData(customerReferanceId);
		try {
			customerRepo.deleteById(customerReferanceId);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		return customerRepo.findAll();
		//return dao.getAllCustomers();
	}

}
