package com.restful.datajpa.restful.datajpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	Integer id;
	Integer doorno;
	String city;
	String country;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDoorno() {
		return doorno;
	}
	public void setDoorno(Integer doorno) {
		this.doorno = doorno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address(Integer id, Integer doorno, String city, String country) {
		super();
		this.id = id;
		this.doorno = doorno;
		this.city = city;
		this.country = country;
	}
	public Address() {
		super();
	}
	
}
