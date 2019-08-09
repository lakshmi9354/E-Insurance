package com.hcl.insurance.service;

import java.util.List;

import com.hcl.insurance.dto.CustomerDto;
import com.hcl.insurance.dto.PoliciesDetailsDto;

public interface IInsuranceService {

	public List<PoliciesDetailsDto> policies();
	public String buyPolicy(CustomerDto customerDto);
}
