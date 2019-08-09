package com.hcl.insurance.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.CustomerDto;
import com.hcl.insurance.dto.PoliciesDetailsDto;
import com.hcl.insurance.entity.Customer;
import com.hcl.insurance.entity.Policies;
import com.hcl.insurance.repository.IInsuranceCustomerRepository;
import com.hcl.insurance.repository.IInsurancePoliciesRepository;

@Service
public class InsuranceServiceImpl implements IInsuranceService{

	@Autowired
	IInsurancePoliciesRepository insuranceRepository;
	
	@Autowired
	IInsuranceCustomerRepository insuranceCustomerRepository;
	
	@Override
	public List<PoliciesDetailsDto> policies() {
		List<Policies> policies = insuranceRepository.findAll();
		List<PoliciesDetailsDto> policiesDetailsDtos = new ArrayList<PoliciesDetailsDto>();
		PoliciesDetailsDto policiesDetailsDto = null;
		for(Policies policy : policies) {
			policiesDetailsDto = new PoliciesDetailsDto();
			BeanUtils.copyProperties(policy, policiesDetailsDto);
			policiesDetailsDtos.add(policiesDetailsDto);
		}
		return policiesDetailsDtos;
	}

	@Override
	public String buyPolicy(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		insuranceCustomerRepository.save(customer);
		return "Purchased Successfully.";
	}

	
	static boolean validPhoneNumber(Long number) {
		String num = number.toString();
		Pattern p = Pattern.compile("^[0-9]{10}$");
		Matcher m = p.matcher(num);
		return (m.find() && m.group().equals(num));
	}

	static boolean validAge(LocalDate date1) {
		boolean result = false;
		int birthYear = date1.getYear();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int age = year - birthYear;
		if (age > 18) {
			result = true;
		}
		return result;
	}

	static boolean emailValidation(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
	static boolean nameValidation(String name) {
		String regex = "^[a-zA-Z]*$";
		return name.matches(regex);
	}
}
