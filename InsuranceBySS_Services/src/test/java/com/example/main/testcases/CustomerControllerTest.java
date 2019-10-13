package com.example.main.testcases;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.insurance.main.bean.CustomerBean;

@TestConfiguration
public class CustomerControllerTest {
	@LocalServerPort
    int randomServerPort;
	
	@Test
	public void testGetEmployeeListSuccess() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8055 + "/insuranceCustomer/getAll";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<List> result = restTemplate.getForEntity(uri, List.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    List<CustomerBean> responseList = (List<CustomerBean>)result.getBody();
	    Map<String, String> customerMap = (Map<String, String>) responseList.get(0);
	    
	    Assert.assertEquals("A100", customerMap.get("customerReferanceId").toString());
	}

}
