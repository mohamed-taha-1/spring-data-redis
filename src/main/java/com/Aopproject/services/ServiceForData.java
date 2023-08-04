package com.Aopproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.Aopproject.Dao.Product;
import com.Aopproject.Dao.ProductRepository;

@Service
public class ServiceForData {

	@Autowired
	ProductRepository productRepository;

	@Cacheable(value = "productCache")
	public Product getProductById(Long productId) {
		// Fetch product from the database or any other data source
		// For demonstration purposes, let's assume we are fetching the product from the
		// database
		// Replace this with your actual data retrieval logic
		Product product = productRepository.findById(productId).orElse(null);
		return product;
	}

	@CacheEvict(value = "product")
	public void updateProduct(Long productId, Product updatedProduct) {
		// Update product in the database or any other data source
		// For demonstration purposes, let's assume we are updating the product in the
		// database
		// Replace this with your actual data update logic
		Product existingProduct = productRepository.findById(productId).orElse(null);
		if (existingProduct != null) {
			existingProduct.setName(updatedProduct.getName());
			existingProduct.setPrice(updatedProduct.getPrice());
			productRepository.save(existingProduct);
		}
	}
	
	 @Cacheable(value = "allProducts", keyGenerator = "listProductsKeyGenerate")
	    public List<Product> getAllProducts() {
	        // Fetch all products from the database or any other data source
	        // Replace this with your actual data retrieval logic
	        // ...
	        return productRepository.findAll();
	    }

}
