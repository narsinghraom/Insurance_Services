package com.insurance.main;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@PostMapping(value = "myName")
	public String getValue() {
		return "Narsingh mahankali";
	}
}
