package com.cartservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class CartController {
	
	@Autowired
	private ProductDaoService productDaoService;
	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */	
		
	
	/*
	 * @GetMapping(value = "/products") private List<Product> findAllProducts(){
	 * return productDaoService.findAll(); }
	 */
	 	
	 
	/*Delete the product*/
	@DeleteMapping(value = "/products/{deleteByProductId}")
	private void deleteProduct(@PathVariable int deleteByProductId) throws ProductNotFoundException{
		Product product = productDaoService.deleteByProductId(deleteByProductId);
		if (product == null) {
			throw new ProductNotFoundException ("productId="+deleteByProductId);
		}
	}
	
	/*Add the product*/
	@PostMapping(value = "/addProduct") 
	private void addProduct(@RequestBody Product product){ 
		productDaoService.addProduct(product); 
	}

}
