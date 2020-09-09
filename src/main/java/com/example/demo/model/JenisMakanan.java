package com.example.demo.model;
import javax.persistence.Cacheable;
import javax.persistence.Entity;

import org.springframework.data.relational.core.mapping.Column;

import com.sun.istack.Nullable;


@Entity
@Cacheable
@SuppressWarnings("serial")
public class JenisMakanan extends BaseEntity {

	private String jenisMakanan;
	private String description;
	public String getJenisMakanan() {
		return jenisMakanan;
	}
	public void setJenisMakanan(String jenisMakanan) {
		this.jenisMakanan = jenisMakanan;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
