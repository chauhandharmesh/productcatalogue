package com.productcatalogue.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.demo.domain.Product;
import com.productcatalogue.demo.enums.BrandEnum;
import com.productcatalogue.demo.enums.SellerEnum;
import com.productcatalogue.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public long countAvailableProductBySellerName(SellerEnum sellerName) {
		return productRepository.countAvailableProductBySellerName(sellerName);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductsByBrand(BrandEnum brand) {
		return productRepository.findProductByBrand(brand);
	}


}
