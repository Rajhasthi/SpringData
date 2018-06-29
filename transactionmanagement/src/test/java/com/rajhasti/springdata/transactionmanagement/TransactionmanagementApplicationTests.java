package com.rajhasti.springdata.transactionmanagement;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.transactionmanagement.services.BankAccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionmanagementApplicationTests {
	
	@Autowired
	BankAccountService service;

	@Test

	public void testTransfer()  {
		service.transfer(500);
	}

}
