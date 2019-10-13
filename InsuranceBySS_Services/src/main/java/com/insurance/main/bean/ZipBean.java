package com.insurance.main.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zip_table")
public class ZipBean 
{
	@Id
	private int zipCode;
	private String cityName;
	private String stateName;
	private String countryName;
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	/**
	 * @param zipCode
	 * @param cityName
	 * @param stateName
	 * @param countryName
	 */
	public ZipBean(int zipCode, String cityName, String stateName, String countryName) {
		super();
		this.zipCode = zipCode;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
	}
	/**
	 * 
	 */
	public ZipBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
