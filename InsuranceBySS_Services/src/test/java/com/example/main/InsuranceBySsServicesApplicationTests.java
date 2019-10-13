package com.example.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.main.testcases.CustomerControllerTest;

@RunWith(SpringRunner.class)
@Import(CustomerControllerTest.class)
@SpringBootTest
public class InsuranceBySsServicesApplicationTests {
	

	@Test
	public void contextLoads() {
	}
	
	

}
