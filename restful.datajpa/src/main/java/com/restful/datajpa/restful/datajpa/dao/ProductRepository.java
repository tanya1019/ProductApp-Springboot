package com.restful.datajpa.restful.datajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restful.datajpa.restful.datajpa.entity.Product;

//@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
