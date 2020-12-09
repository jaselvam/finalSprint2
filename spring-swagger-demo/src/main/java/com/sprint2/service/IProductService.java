package com.sprint2.service;

import java.util.List;

import com.sprint2.model.Product;

public interface IProductService {
	public Product getProductById(Integer productId);
	public Product addProduct(Product Product);
	public boolean deleteProduct(Integer productId);
	public List<Product> getAllProducts() ;
	
}
