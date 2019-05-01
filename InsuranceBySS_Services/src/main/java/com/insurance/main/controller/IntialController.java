package com.insurance.main.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntialController {
	
	@PostMapping(value="/hello")
	public String index() {
		return "Hello World!!!";
	}

}
