package com.sprint2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sprint2.Exceptions.InvalidOperation;
import com.sprint2.model.Product;
import com.sprint2.repository.ProductRepository;



@Service
public class ProductService {
	@Autowired ProductRepository productRepository;
	
	public Product getProductById(Integer productId)
	{
		try 
		{	
			return productRepository.findById(productId).orElse(null);
		}
		catch(NoSuchElementException | IllegalArgumentException  ie )
		{
			throw new InvalidOperation("Product details are not found with given product id");
			
		}
	}
	public Product addProduct(Product Product)
	{
		try 
		{
			return productRepository.save(Product);
		}
		catch(InvalidOperation ie)
		{
			throw new InvalidOperation("Enter correct product details");
		}	
	}
	
	
	public boolean deleteProduct(Integer productId) 
	{		
		try 
		{
			System.out.println("Please enter a Integer value : ");
			productRepository.deleteById(productId);
			System.out.println( "product details are successfully deleted");
			return true;
		}
		catch( IllegalArgumentException | EmptyResultDataAccessException ie)
		{
				throw new InvalidOperation("Product not deleted \n enter the correct id");
		}
		
	}
	public List<Product> getAllProducts() {
		List<Product> Productlist=new ArrayList<Product>();
		System.out.println("Products");
		
		return productRepository.findAll();
	
	}
	
}