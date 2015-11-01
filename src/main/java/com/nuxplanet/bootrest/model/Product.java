package com.nuxplanet.bootrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product entity
 * 
 * @author Wojciech Olech
 * @version 0.1
 */
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Global SKU identifier
	 */
	@Column(nullable=false, length=128, unique=true)
	private String SKU;

	/**
	 * Product name
	 */
	@Column(nullable=false, length=128)
	private String name;
	
	/**
	 * Create new Product with unique SKU and Name
	 * @param SKU
	 * @param name
	 */
	public Product(final String SKU, final String name) {
		this.SKU = SKU;
		this.name = name;
	}
	
	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
