package com.restful.datajpa.restful.datajpa.service;

import java.util.Collection;
import java.util.List;

import com.restful.datajpa.restful.datajpa.entity.Product;
import com.restful.datajpa.restful.datajpa.exception.ProductException;

public interface ProductService {
	
	Product addProduct(Product newProduct) throws ProductException;
	List<Product> getAllProduct() throws ProductException;
	
	Product getProductById(Integer id) throws ProductException;
	Product deleteProductById(Integer id) throws ProductException;
	Product updateproduct(Product newProduct) throws ProductException;
	
	Collection<Product> getAllProducts();

	
	
	
	

}
