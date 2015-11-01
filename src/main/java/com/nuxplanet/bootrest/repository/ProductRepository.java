package com.nuxplanet.bootrest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nuxplanet.bootrest.model.Product;

/**
 * REST CRUD Product repository, for reading, updating, deleting and creating new products
 * 
 * @author Wojciech Olech
 *@version 0.1
 */
@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	
	/**
	 * Find all products with the same name
	 * @param name
	 * @return
	 */
	List<Product> findByName(@Param("name") String name);
}
