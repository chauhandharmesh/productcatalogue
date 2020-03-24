package com.productcatalogue.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productcatalogue.demo.domain.Product;
import com.productcatalogue.demo.enums.BrandEnum;
import com.productcatalogue.demo.enums.SellerEnum;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select count(*) from Product where seller=:sellerName")
	long countAvailableProductBySellerName(SellerEnum sellerName);

	@Query(value = "select prd from Product prd where prd.brand=:brand")
	List<Product> findProductByBrand(BrandEnum brand);

}
