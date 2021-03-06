package com.rajhasti.springdata.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.customer.entity.Address;
import com.rajhasti.springdata.customer.entity.Customer;
import com.rajhasti.springdata.customer.repos.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerApplicationTests {
	@Autowired
	CustomerRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateCustomer() {

		Customer customer = new Customer();
		// customer.setId(1);
		customer.setName("RajHasti");
		customer.setEmail("rajglobe@gmail.com");
		Address address = new Address();
		address.setStreetAddress("870 Elmsbroook Lane");
		address.setCity("Alpharetta");
		address.setState("GA");
		address.setZipcode("30004");
		address.setCountry("US");
		customer.setAddress(address);
		repository.save(customer);
	}

	@Test
	public void testRead() {

		Customer customer = repository.findOne(1);
		assertNotNull(customer);
		assertEquals("rajglobe@gmail.com", customer.getEmail());
		System.out.println(">>>>>>>>>>" + customer.getName());
	}

	@Test
	public void testUpdate() {

		Customer customer = repository.findOne(1);
		customer.setName("Rajini Konduru");
		repository.save(customer);
	}

	@Test
	public void testDelete() {
		if (repository.exists(1)) {
			System.out.println("Deleting Customer");
			repository.delete(1);
		}

	}

	@Test
	public void testCount() {

		System.out.println("Total Customers in the systems#" + repository.count());
	}

	@Test
	public void testFindByCusByNameAndEmail() {
		List<Customer> customers = repository.findByNameAndEmail("RajHasti", "rajglobe@gmail.com");
		customers.forEach(c -> System.out.println(c.getName()));

	}

	@Test
	public void testFindByPartialEmail() {
		List<Customer> customers = repository.findByEmailLike("%gmail%");
		customers.forEach(c -> System.out.println(c.getName()));

	}

	@Test
	public void testFindByIdsIn() {
		List<Customer> customers = repository.findByIdIn(Arrays.asList(2));
		customers.forEach(c -> System.out.println(c.getName()));

	}

	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateCustomerByFirstNameAndId() {
		repository.UpdateCustomerByFirstNameAndId("VikAditya", 1);
	}

	@Test
	public void testFindAllCustomers() {
		System.out.println(repository.findAllCustomers(new PageRequest(1, 2, Direction.DESC, "name")));
	}
}
