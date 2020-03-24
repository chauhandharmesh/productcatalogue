package com.productcatalogue.demo.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.productcatalogue.demo.domain.Product;
import com.productcatalogue.demo.enums.BrandEnum;
import com.productcatalogue.demo.enums.SellerEnum;
import com.productcatalogue.demo.repository.ProductRepository;

@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

	@Mock
	public ProductRepository productRepository;

	@InjectMocks
	public ProductServiceImpl productServiceImpl = new ProductServiceImpl();

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCountAvailableProductBySellerName() {
		Mockito.when(productRepository.countAvailableProductBySellerName(Mockito.any(SellerEnum.class))).thenReturn(2L);
		Assert.assertEquals(2, productServiceImpl.countAvailableProductBySellerName(SellerEnum.SELLER1));

	}

	@Test
	public void testAddProduct() {
		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(new Product());
		productServiceImpl.addProduct(new Product());
		Mockito.verify(productRepository);
	}

	@Test
	public void testGetProductsByBrand() {
		Mockito.when(productRepository.findProductByBrand(Mockito.any(BrandEnum.class)))
				.thenReturn(Arrays.asList(new Product()));
		Assert.assertEquals(1, productServiceImpl.getProductsByBrand(BrandEnum.ALLEN_SOLLY).size());

	}

}
