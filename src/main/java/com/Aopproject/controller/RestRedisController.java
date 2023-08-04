package com.Aopproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Aopproject.Dao.Product;
import com.Aopproject.services.ServiceForData;

@RestController
public class RestRedisController {

	private final ServiceForData productService;

	public RestRedisController(ServiceForData productService) {
		this.productService = productService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		if (product != null) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	 @GetMapping("/products")
	    public ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> products = productService.getAllProducts();

	        if (!products.isEmpty()) {
	            return ResponseEntity.ok(products);
	        } else {
	            return ResponseEntity.noContent().build();
	        }
	    }

}
