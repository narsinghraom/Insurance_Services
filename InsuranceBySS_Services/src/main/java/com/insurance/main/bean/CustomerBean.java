package com.insurance.main.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_TABLE")
public class CustomerBean {

	@Id
	private String customerReferanceId;
	private String customerFirstName;
	private String customerLastName;
	private String customerAddress;
	private String customerDOB;
	/**
	 * @return the customerReferanceId
	 */
	public String getCustomerReferanceId() {
		return this.customerReferanceId;
	}
	/**
	 * @param customerReferanceId the customerReferanceId to set
	 */
	public void setCustomerReferanceId(String customerReferanceId) {
		this.customerReferanceId = customerReferanceId;
	}
	/**
	 * @return the customerFirstName
	 */
	public String getCustomerFirstName() {
		return this.customerFirstName;
	}
	/**
	 * @param customerFirstName the customerFirstName to set
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	/**
	 * @return the customerLastName
	 */
	public String getCustomerLastName() {
		return this.customerLastName;
	}
	/**
	 * @param customerLastName the customerLastName to set
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return this.customerAddress;
	}
	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	/**
	 * @return the customerDOB
	 */
	public String getCustomerDOB() {
		return this.customerDOB;
	}
	/**
	 * @param customerDOB the customerDOB to set
	 */
	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}
	
}
