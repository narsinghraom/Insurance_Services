package com.insurance.main.dao;

import java.util.List;

import com.insurance.main.bean.ZipBean;



public interface DataDao 
{
	public List<ZipBean> getList();  
	public List<String> getZipList(String zip);
	public List<ZipBean> getZipData(String zip);

}
