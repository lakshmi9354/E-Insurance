package com.hcl.insurance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Policies implements Serializable{
	
	private static final long serialVersionUID = -6520251605263639536L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long policyId;
	private String policyName;
	private String policyTenure;
	private String policyAmount;
	private String description;

}
