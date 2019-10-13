/**
 * 
 */
package com.insurance.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.main.bean.CustomerBean;
import com.insurance.main.dao.DataDao;

/**
 * @author Narsingh Mahankali
 *
 */

@Service
public class CustomerServiceImplementation implements CustomerService {
	@Autowired
	DataDao dao;

	@Override
	public int insertCustomerData(CustomerBean customerBean) {
		
		return dao.insertCustomerData(customerBean);
	}

	@Override
	public int updateCustomerData(CustomerBean customerBean) {
		String id = "'"+customerBean.getCustomerReferanceId()+"'";
		List<CustomerBean> customerList = dao.searchCustomerWithRefID(id);
		if(customerList == null || customerList.isEmpty()) {
			return 0;
		}
		for(CustomerBean tempCustomer : customerList) {
			if(compareString(tempCustomer.getCustomerFirstName(),customerBean.getCustomerFirstName())) {
				customerBean.setCustomerFirstName(null);
			}
			if(compareString(tempCustomer.getCustomerLastName(),customerBean.getCustomerLastName())) {
				customerBean.setCustomerLastName(null);
			}
			if(compareString(tempCustomer.getCustomerAddress(),customerBean.getCustomerAddress())) {
				customerBean.setCustomerAddress(null);
			}
			if(compareString(tempCustomer.getCustomerDOB(),customerBean.getCustomerDOB())) {
				customerBean.setCustomerDOB(null);
			}
		}
		return dao.updateCustomerData(customerBean);
	}
	
	private boolean compareString(String tempValue,String exactValue) {
		if(tempValue == null || exactValue == null) {
			return false;
		}
		return tempValue.equalsIgnoreCase(exactValue);
	}

	@Override
	public List<CustomerBean> searchCustomerWithRefID(String customerReferanceId) {
		return dao.searchCustomerWithRefID(customerReferanceId);
	}

	@Override
	public int deleteCustomerData(String customerReferanceId) {
		return dao.deleteCustomerData(customerReferanceId);
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		return dao.getAllCustomers();
	}

}
