package com.nuxplanet.bootrest.repository;

import static org.junit.Assert.fail;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.*;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.*;
import com.nuxplanet.bootrest.BootRestApplication;

/**
 * 
 * 
 * @author Wojciech Olech
 * @version 0.1
 */
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootRestApplication.class)
@DatabaseSetup(ProductRepositoryTests.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { ProductRepositoryTests.DATASET })
@DirtiesContext
public class ProductRepositoryTests {
	protected static final String DATASET = "classpath:datasets/products.xml";
	@Autowired
	private ProductRepository repository;

	@Test
	public void shouldFindByName() {
		assertThat(repository.findByName("Name-1"))
			.hasSize(1);
	}
}
