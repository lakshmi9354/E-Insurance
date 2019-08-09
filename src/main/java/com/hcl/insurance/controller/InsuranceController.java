package com.hcl.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.CustomerDto;
import com.hcl.insurance.dto.PoliciesDetailsDto;
import com.hcl.insurance.service.IInsuranceService;

@RestController
@RequestMapping("/api")
public class InsuranceController {

	@Autowired
	IInsuranceService insuranceService;
	
	@GetMapping("/policies")
	public ResponseEntity<List<PoliciesDetailsDto>> policies(){
		List<PoliciesDetailsDto> policiesDetailsDtos = insuranceService.policies();
		return new ResponseEntity<>(policiesDetailsDtos,HttpStatus.OK);
	}
	
	@PostMapping("/buyPolicy")
	public ResponseEntity<String> buyPolicy(@RequestBody CustomerDto customerDto){
		String message = insuranceService.buyPolicy(customerDto);
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
}
