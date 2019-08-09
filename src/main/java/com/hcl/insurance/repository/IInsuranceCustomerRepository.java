package com.hcl.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.insurance.entity.Customer;

@Repository
public interface IInsuranceCustomerRepository extends JpaRepository<Customer, Long>{

}
