/**
 * 
 */
package com.insurance.main.service;

import java.util.List;

import com.insurance.main.bean.CustomerBean;

/**
 * @author Narsingh Mahankali
 *
 */
public interface CustomerService {
	public int insertCustomerData(CustomerBean customerBean);

	public int updateCustomerData(CustomerBean customerBean);

	public List<CustomerBean> searchCustomerWithRefID(String customerReferanceId);

	public int deleteCustomerData(String customerReferanceId);
	
	public List<CustomerBean> getAllCustomers();
}
