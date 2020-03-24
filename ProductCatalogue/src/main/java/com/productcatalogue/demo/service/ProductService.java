package com.productcatalogue.demo.service;

import java.util.List;

import com.productcatalogue.demo.domain.Product;
import com.productcatalogue.demo.enums.BrandEnum;
import com.productcatalogue.demo.enums.SellerEnum;

public interface ProductService {

	long countAvailableProductBySellerName(SellerEnum sellerEnum);

	void addProduct(Product product);

	List<Product> getAllProduct();
	
	List<Product> getProductsByBrand(BrandEnum brand);

}
