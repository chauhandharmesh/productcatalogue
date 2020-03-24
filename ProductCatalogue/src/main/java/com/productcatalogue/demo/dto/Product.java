package com.productcatalogue.demo.dto;

import com.productcatalogue.demo.enums.BrandEnum;
import com.productcatalogue.demo.enums.CategoryEnum;
import com.productcatalogue.demo.enums.ColorEnum;
import com.productcatalogue.demo.enums.SellerEnum;

public class Product {

	private long id;
	private String name;
	private String sku;
	private BrandEnum brand;
	private ColorEnum color;
	private String size;
	private SellerEnum seller;
	private CategoryEnum category;

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
