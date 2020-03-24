package com.productcatalogue.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.productcatalogue.demo.ProductcatalogueApplication;
import com.productcatalogue.demo.domain.Product;
import com.productcatalogue.demo.enums.BrandEnum;
import com.productcatalogue.demo.enums.CategoryEnum;
import com.productcatalogue.demo.enums.ColorEnum;
import com.productcatalogue.demo.enums.SellerEnum;
import com.productcatalogue.demo.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ProductcatalogueApplication.class)
public class ProductControllerTest {

	@LocalServerPort
	private long serverPort;

	@Autowired
	private ProductRepository productRepository;

	private RestTemplate restTemplate = new RestTemplate();

	private String url = null;

	@Before
	public void initData() {

		Product product1 = new Product("Small Shirt", "SKU001", BrandEnum.ALLEN_SOLLY, ColorEnum.BLUE, "L",
				SellerEnum.SELLER1, CategoryEnum.SHIRT);
		Product product2 = new Product("Small Jeans", "SKU002", BrandEnum.MUFTI, ColorEnum.PURPLE, "40",
				SellerEnum.SELLER1, CategoryEnum.PANT);
		Product product3 = new Product("Small TSHIRT", "SKU003", BrandEnum.LEVIS, ColorEnum.RED, "M",
				SellerEnum.SELLER1, CategoryEnum.T_SHIRT);

		productRepository.saveAll(Arrays.asList(product1, product2, product3));

	}

	@Test
	public void testGetProductsByBrand() {
		url = "http://localhost:" + serverPort + "/products";
		List<Product> products = restTemplate.getForObject(url + "/MUFTI", List.class);
		Assert.assertEquals(1, products.size());
	}

	@Test
	public void testGetProductsByBrand_Rainy() {
		url = "http://localhost:" + serverPort + "/products";
		Assertions.assertThrows(HttpClientErrorException.class,
				() -> restTemplate.getForObject(url + "/Other", List.class));
	}

	@Test
	public void testGetProductsBySellerName() {
		url = "http://localhost:" + serverPort + "/products";
		Long count = restTemplate.getForObject(url + "?sellerName=SELLER1", Long.class);
		Assert.assertEquals(3, count.longValue());
	}

	@Test
	public void testGetProductsBySellerName_Rainy() {
		url = "http://localhost:" + serverPort + "/products";
		Long count = restTemplate.getForObject(url + "?sellerName=SELLER3", Long.class);
		Assert.assertEquals(0, count.longValue());
	}

}
