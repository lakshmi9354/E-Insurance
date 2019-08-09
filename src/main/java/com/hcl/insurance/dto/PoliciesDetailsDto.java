package com.hcl.insurance.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PoliciesDetailsDto implements Serializable{

	private static final long serialVersionUID = 5450017987360453814L;

	private Long policyId;
	private String policyName;
	private String policyTenure;
	private String policyAmount;
	private String description;
	
}
