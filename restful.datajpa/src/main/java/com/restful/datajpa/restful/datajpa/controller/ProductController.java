package com.restful.datajpa.restful.datajpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.datajpa.restful.datajpa.entity.Product;
import com.restful.datajpa.restful.datajpa.exception.ProductException;
import com.restful.datajpa.restful.datajpa.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String getGreeting() {
		return "Hello";
	}
	
	@PostMapping("/product")
	public Product addproduct(@Valid @RequestBody Product newproduct) throws ProductException{
		
		try {
			return this.productService.addProduct(newproduct);
		}catch (ProductException e) {
			throw e;
		}
	}
	
	@GetMapping("/getproduct/{id}")
	public Product getProductById(@PathVariable ("id") Integer id) throws ProductException {
		return this.productService.getProductById(id);
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product newProduct) throws ProductException {
		return this.productService.updateproduct(newProduct);
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deleteProductbyId(@PathVariable ("id") Integer id) throws ProductException{
		Product product = this.productService.deleteProductById(id);
		return new ResponseEntity<Product> (product, HttpStatus.OK);
		
	
	}
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts() throws ProductException {
		return this.productService.getAllProduct();
	}
	
	
	
		
	
}
