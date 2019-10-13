package com.insurance.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.main.bean.ZipBean;

@RestController
public class MyController {

	@PostMapping(value = "myName")
	public List<ZipBean> getValue() {
		List<ZipBean> listOfAddress = new ArrayList<>();
		listOfAddress.add(new ZipBean(500081, "Hyderabad", "Telangana", "Ïndia"));
		return listOfAddress;
	}
}
