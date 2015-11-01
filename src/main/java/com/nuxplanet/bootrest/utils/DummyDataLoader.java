package com.nuxplanet.bootrest.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.nuxplanet.bootrest.model.Product;
import com.nuxplanet.bootrest.repository.ProductRepository;

@Component
/**
 * Create dummy data for development purposes
 * 
 * @author Wojciech Olech
 * @version 0.1
 *
 */
public class DummyDataLoader implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		createDummyProducts();
	}
	
	public void createDummyProducts() {
		for(int i=0; i<20; ++i) {
			productRepository.save(new Product("SKU-"+RandomStringUtils.randomAlphabetic(3), "Product-"+RandomStringUtils.randomAlphabetic(3)));
		}
	}
}
