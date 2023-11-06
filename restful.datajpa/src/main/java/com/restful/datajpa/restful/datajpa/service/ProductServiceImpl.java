package com.restful.datajpa.restful.datajpa.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.restful.datajpa.restful.datajpa.dao.ProductRepository;
import com.restful.datajpa.restful.datajpa.entity.Product;
import com.restful.datajpa.restful.datajpa.exception.ProductException;
@Component
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public Product addProduct(Product newProduct) throws ProductException {
		Optional<Product> productOpt = this.productRepository.findById(newProduct.getId());
		
		if(productOpt.isPresent()) 
			throw new ProductException("Product Already Exist" + newProduct.getName());
		return this.productRepository.save(newProduct);
	}

	@Override
	public Product getProductById(Integer id) throws ProductException {
		Optional<Product> productOpt = this.productRepository.findById(id);
		if(!productOpt.isPresent()) {
			throw new ProductException("Product not fount by id --> " + id);
		}
			
		
		return productOpt.get();
	}

	@Override
	public Product deleteProductById(Integer id) throws ProductException {
		Optional<Product> productOpt = this.productRepository.findById(id);
		
		if(!productOpt.isPresent()) {
			throw new ProductException("Item not found to delete, id no. is --> " + id);
		}
		
		this.productRepository.deleteById(id);
		return null;
	}

	@Override
	public Product updateproduct(Product newProduct) throws ProductException {
		Optional<Product> productOpt = this.productRepository.findById(newProduct.getId());
		
		if(!productOpt.isPresent()) {
			throw new ProductException("Product not found of id --> " + newProduct.getId());
		}
		return this.productRepository.save(newProduct);
	}

	@Override
	public Collection<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> getAllProduct() throws ProductException {
		
		return this.productRepository.findAll();
	}



}
