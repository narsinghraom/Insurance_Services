/**
 * 
 */
package com.insurance.main.service;

import java.util.List;

import com.insurance.main.bean.CustomerBean;
import com.insurance.main.response.CustomerResponse;

/**
 * @author Narsingh Mahankali
 *
 */
public interface CustomerService {
	public int insertCustomerData(CustomerBean customerBean);

	public int updateCustomerData(CustomerBean customerBean);

	public CustomerResponse searchCustomerWithRefID(String customerReferanceId);

	public int deleteCustomerData(String customerReferanceId);
	
	public List<CustomerBean> getAllCustomers();
}
