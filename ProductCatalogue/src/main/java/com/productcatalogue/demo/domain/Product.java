package com.productcatalogue.demo.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.productcatalogue.demo.enums.BrandEnum;
import com.productcatalogue.demo.enums.CategoryEnum;
import com.productcatalogue.demo.enums.ColorEnum;
import com.productcatalogue.demo.enums.SellerEnum;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String sku;

	@Enumerated(EnumType.STRING)
	private BrandEnum brand;

	@Enumerated(EnumType.STRING)
	private ColorEnum color;

	private String size;

	@Enumerated(EnumType.STRING)
	private SellerEnum seller;

	@Enumerated(EnumType.STRING)
	private CategoryEnum category;

	public Product() {}
	public Product(String name, String sku, BrandEnum brand, ColorEnum color, String size, SellerEnum seller,
			CategoryEnum category) {
		super();
		this.name = name;
		this.sku = sku;
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.seller = seller;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BrandEnum getBrand() {
		return brand;
	}

	public void setBrand(BrandEnum brand) {
		this.brand = brand;
	}

	public ColorEnum getColor() {
		return color;
	}

	public void setColor(ColorEnum color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public SellerEnum getSeller() {
		return seller;
	}

	public void setSeller(SellerEnum seller) {
		this.seller = seller;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}

}
