package com.restful.datajpa.restful.datajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.datajpa.restful.datajpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
