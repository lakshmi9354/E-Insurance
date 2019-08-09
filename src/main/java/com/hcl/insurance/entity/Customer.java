package com.hcl.insurance.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Customer implements Serializable{


	private static final long serialVersionUID = -440975900514614869L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	private String customerName;
	private String gender;
	private LocalDate DOB;
	private String email;
	private String mobileNo;
	
	@OneToMany
	@JoinTable(name="CustomerPolicies",
            joinColumns = @JoinColumn( name="customerId"),
            inverseJoinColumns = @JoinColumn( name="policyId"))
	private List<Policies> policies;
	
}
