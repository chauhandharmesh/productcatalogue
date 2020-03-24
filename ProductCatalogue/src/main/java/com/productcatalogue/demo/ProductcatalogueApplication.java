package com.productcatalogue.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.productcatalogue.demo.domain.Product;
import com.productcatalogue.demo.enums.BrandEnum;
import com.productcatalogue.demo.enums.CategoryEnum;
import com.productcatalogue.demo.enums.ColorEnum;
import com.productcatalogue.demo.enums.SellerEnum;
import com.productcatalogue.demo.repository.ProductRepository;

@SpringBootApplication
public class ProductcatalogueApplication {

	@Autowired
	private ProductRepository productRepository;

	@Bean
	public CommandLineRunner addData() {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				Product product1 = new Product("Small Shirt", "SKU001", BrandEnum.ALLEN_SOLLY, ColorEnum.BLUE, "L",
						SellerEnum.SELLER1, CategoryEnum.SHIRT);
				Product product2 = new Product("Small Jeans", "SKU002", BrandEnum.MUFTI, ColorEnum.PURPLE, "40",
						SellerEnum.SELLER1, CategoryEnum.PANT);
				Product product3 = new Product("Small TSHIRT", "SKU003", BrandEnum.LEVIS, ColorEnum.RED, "M",
						SellerEnum.SELLER1, CategoryEnum.T_SHIRT);

				productRepository.saveAll(Arrays.asList(product1, product2, product3));
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogueApplication.class, args);
	}

}
