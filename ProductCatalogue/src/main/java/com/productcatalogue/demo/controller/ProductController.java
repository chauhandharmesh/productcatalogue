package com.productcatalogue.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalogue.demo.domain.Product;
import com.productcatalogue.demo.enums.BrandEnum;
import com.productcatalogue.demo.enums.SellerEnum;
import com.productcatalogue.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/{brand}")
	public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable(name = "brand") String brand) {

		List<Product> products = productService.getProductsByBrand(BrandEnum.valueOf(brand.toUpperCase()));
		if (products.isEmpty()) {
			return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(products, HttpStatus.OK);
		}

	}

	@GetMapping("")
	public ResponseEntity<Long> getAvailableProductsBySeller(@RequestParam(name = "sellerName") String sellerName) {
		Long count = productService.countAvailableProductBySellerName(SellerEnum.valueOf(sellerName.toUpperCase()));
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

	@PostMapping("/addProduct")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}

	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> products = productService.getAllProduct();
		if (products.isEmpty()) {
			return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(products, HttpStatus.OK);
		}
	}

}
