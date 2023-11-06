package com.restful.datajpa.restful.datajpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.datajpa.restful.datajpa.dao.CategoryRepository;
import com.restful.datajpa.restful.datajpa.dao.ProductRepository;
import com.restful.datajpa.restful.datajpa.entity.Category;
import com.restful.datajpa.restful.datajpa.entity.Product;
import com.restful.datajpa.restful.datajpa.exception.ProductException;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProductRepository productRepo;

	@PostMapping("/category/{name1}")
	public Category addCategory(@PathVariable ("name1") String name) {
		
		Category category = new Category();
		category.setName(name);
		category = this.categoryRepo.save(category);
		return category;
		
	}
	
	@PostMapping("/category/product/{id}")
	public Category addProductToCategoryById(@PathVariable ("id") Integer id, @RequestBody Product product) throws ProductException {
		
		Optional<Category> categoryOpt = this.categoryRepo.findById(id);
		
		if(!categoryOpt.isPresent()) {
			throw new ProductException("No category present");
		}
		
		product = this.productRepo.save(product) ;
		Category category = categoryOpt.get();
		category.getProducts().add(product);
		return this.categoryRepo.save(category) ;
		
	}
	
	@DeleteMapping("/category/product/{categoryId}/{productId}")
	public Category deleteProductFromCategory(@PathVariable ("categoryId") Integer categoryId, @PathVariable ("productId") Integer productId ) throws ProductException {
		
		Optional<Category> categoryOpt = this.categoryRepo.findById(categoryId);
		
		if(!categoryOpt.isPresent()) {
			throw new ProductException("No category found");
		}
		
		Category category = categoryOpt.get();
		List<Product>  productList = category.getProducts();
		
		Optional<Product> productOpt = this.productRepo.findById(productId);
		
		if(!productOpt.isPresent()) {
			throw new ProductException("Product not found");
		}
		Product deleteProduct = productOpt.get();
		
		if(!productList.contains(deleteProduct)) {
			throw new ProductException("Product not present in the category");
		}
		
		productList.remove(deleteProduct);
		this.productRepo.delete(deleteProduct);
		 return this.categoryRepo.save(category);
	}
	
	@GetMapping("/allproducts/")
	public List<Product> getAllProducts() {
		return this.productRepo.findAll();
	}
	
}
