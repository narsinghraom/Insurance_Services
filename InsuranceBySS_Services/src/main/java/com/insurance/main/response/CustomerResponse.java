package com.insurance.main.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CustomerResponse {

	private String customerReferanceId;
	private String customerFirstName;
	private String customerLastName;
	private String customerAddress;
	private String customerDOB;
}
