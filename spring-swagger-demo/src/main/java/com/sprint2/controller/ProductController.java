package com.sprint2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint2.Exceptions.InvalidOperation;
import com.sprint2.model.Product;
import com.sprint2.repository.ProductRepository;
import com.sprint2.service.ProductService;



@CrossOrigin(origins = "http://localhost:3000")
//connect from postman as http://localhost:8082/swagger-ui.html
@RestController
@RequestMapping("/fms/m4/")
public class ProductController {
	
	Logger logger=LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRespository;
	//creating a get mapping that retrieves the detail of a specific Product
	@GetMapping("products/{productId}")
	
	public ResponseEntity <Product> getProductById(@PathVariable Integer productId)
	{
		logger.info("product service was instalized");
		return new ResponseEntity <Product>(productService.getProductById(productId),HttpStatus.OK);
	}
	
	//creating post mapping that post the Product detail in the database
	@PostMapping("/products")
	public  Product addProduct(@RequestBody Product Product)
	{
		return productService.addProduct(Product);
	}
	
	//creating put mapping that updates the Product detail
	@PutMapping("/products/{productId}")
	public ResponseEntity <Product> updateProduct(@PathVariable int productId,@RequestBody Product Product)
	{
		Product product1=productRespository.findById(productId).orElseThrow(()->new InvalidOperation("Product not exist with id:"+productId));
		product1.setProductName(Product.getProductName());
		product1.setProductDescription(Product.getProductDescription());
		Product updateProduct=productRespository.save(product1);		
		return  ResponseEntity.ok(updateProduct);
	}
	
	//creating a delete mapping that deletes a specified Product
	@DeleteMapping("/products/{productId}")
	public @ResponseBody boolean deleteProduct(@PathVariable Integer productId)
	{
		return productService.deleteProduct(productId);
	}
	
	//creating a get mapping that retrieves all the Product detail from the database
	@GetMapping(value= {"/products"})
	public @ResponseBody List<Product> getAllProduct()
	{
		List<Product> Productlist=productService.getAllProducts();
		return Productlist;
	}
	
}
