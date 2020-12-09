package com.sprint2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.Product;

public interface IProductController {
	public ResponseEntity <Product> getProductById(@PathVariable Integer productId);
	public  Product addProduct(@RequestBody Product Product);
	public ResponseEntity <Product> updateProduct(@PathVariable int productId,@RequestBody Product Product);
	public @ResponseBody boolean deleteProduct(@PathVariable Integer productId);
	public @ResponseBody List<Product> getAllProduct();
}
