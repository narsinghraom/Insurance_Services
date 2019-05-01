package com.insurance.main.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.insurance.main.bean.ZipBean;

public interface DataService {
	public List<ZipBean> getList();
	public List<String> getZipList(String zip);
	public List<ZipBean> getZipData(String zip);
}
