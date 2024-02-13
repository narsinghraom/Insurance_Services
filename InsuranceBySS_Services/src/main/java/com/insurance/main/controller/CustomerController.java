package com.insurance.main.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.main.bean.CustomerBean;
import com.insurance.main.response.CreateResponse;
import com.insurance.main.response.CustomerResponse;
import com.insurance.main.service.CustomerService;

@RestController
@RequestMapping("/insuranceCustomer")
@CrossOrigin("http://localhost:4200")//angular
public class CustomerController {
	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/createCustomer")
    public ResponseEntity<CreateResponse> createCustomer(@RequestBody CustomerBean customerBean){
    	int updated = customerService.insertCustomerData(customerBean);
    	CreateResponse createResponse = new CreateResponse();
    	if(updated>0) {
    		createResponse.setCustomerId(customerBean.getCustomerReferanceId());
    		createResponse.setStatus(HttpStatus.CREATED.name());
    		return new ResponseEntity<CreateResponse>(createResponse,HttpStatus.CREATED);
    	}
        return new ResponseEntity<CreateResponse>(HttpStatus.NO_CONTENT);
    }
	
	@GetMapping("/getAll")
    public ResponseEntity<List<CustomerBean>> getAllCustomers() {
        List<CustomerBean> list = customerService.getAllCustomers();
        LOGGER.info("List Of Customers:"+list);
        return new ResponseEntity<List<CustomerBean>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("get/{refId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("refId") String refId){
    	CustomerResponse customerBean = customerService.searchCustomerWithRefID(refId);
    	if(customerBean != null) {
    		return new ResponseEntity<CustomerResponse>(customerBean, new HttpHeaders(), HttpStatus.OK);
    	}
 
        return new ResponseEntity<CustomerResponse>(customerBean, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
 
    
 
    @DeleteMapping("/deleteCustomer/{referanceId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("referanceId") String id){
    	int result = customerService.deleteCustomerData(id);
    	if(result>0) {
    		return new ResponseEntity<String>("Deleted Successfully", new HttpHeaders(), HttpStatus.OK);
    	}
    	return new ResponseEntity<String>("Id not exist", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
    
    @PutMapping("/updateCustomer")
    public ResponseEntity<CustomerBean> UpdateCustomer(@RequestBody CustomerBean customerBean){
    	int updated = customerService.updateCustomerData(customerBean);
    	if(updated>0) {
    		return new ResponseEntity<CustomerBean>(HttpStatus.CREATED);
    	}
        return new ResponseEntity<CustomerBean>(HttpStatus.NO_CONTENT);
    }
	

}
