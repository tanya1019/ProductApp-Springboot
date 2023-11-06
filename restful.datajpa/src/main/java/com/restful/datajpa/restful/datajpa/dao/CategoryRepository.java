package com.restful.datajpa.restful.datajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.datajpa.restful.datajpa.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
