package com.rajhasti.springdata.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.product.entity.Product;
import com.rajhasti.springdata.product.repos.ProductRepository;

/**
 * @author rajasekhar_hasti
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {
	@Autowired
	ProductRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("IPhone");
		product.setDesc("Awesome!!");
		product.setPrice(1000d);
		repository.save(product);
	}

}
