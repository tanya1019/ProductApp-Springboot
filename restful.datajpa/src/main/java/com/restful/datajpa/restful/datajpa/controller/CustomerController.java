package com.restful.datajpa.restful.datajpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.datajpa.restful.datajpa.dao.AddressRepository;
import com.restful.datajpa.restful.datajpa.dao.CustomerRepository;
import com.restful.datajpa.restful.datajpa.entity.Address;
import com.restful.datajpa.restful.datajpa.entity.Customer;
import com.restful.datajpa.restful.datajpa.exception.CustomerException;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	
	@PostMapping("/customer/")
	public Customer addCustomer(@RequestBody Customer customer) {	
		return this.customerRepo.save(customer);
	}
	
	
	@PostMapping("address/{customerId}/")
	public Customer addAddressToCustomer(@RequestBody Address address, @PathVariable ("customerId") Integer id) {	
		Address newAddress = this.addressRepo.save(address);
		Optional<Customer> customerOpt = this.customerRepo.findById(id);
		Customer foundCustomer = customerOpt.get();
		foundCustomer.setAddress(newAddress);	
		return this.customerRepo.save(foundCustomer);
	}
	
	
	@GetMapping("/customer/{id}/")
	public Optional<Customer> getCustomerbyId(@PathVariable ("id") Integer id) {
		return this.customerRepo.findById(id);
	}
	
//	@DeleteMapping("/customer/address/{id}")
//	public Boolean deleteCustomer(@PathVariable ("id") Integer id) throws CustomerException{
//		
//		Optional<Customer> customerOpt = this.customerRepo.findById(id);
//		
//		if(!customerOpt.isPresent()) {
//			throw new CustomerException("Customer not found");
//		}
//		
//		Customer customer = customerOpt.get();
//		Address address = customer.getAddress();
//		customer.setAddress(null);
//		
//		customerRepo.save(customer);
//		this.addressRepo.delete(address);
//	
//		
//		
//		return true;
//	}
	
}
