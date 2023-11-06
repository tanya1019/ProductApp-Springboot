package com.restful.datajpa.restful.datajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.datajpa.restful.datajpa.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
