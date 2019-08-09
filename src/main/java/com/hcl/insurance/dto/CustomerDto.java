package com.hcl.insurance.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto implements Serializable{

	private static final long serialVersionUID = -3307666574892692958L;

	private Long policyId;
	private String customerName;
	private String gender;
	private String DOB;
	private String email;
	private String mobileNo;
}
