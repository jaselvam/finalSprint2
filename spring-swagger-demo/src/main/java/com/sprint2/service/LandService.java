package com.sprint2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint2.Exceptions.InvalidOperation;
import com.sprint2.model.Land;


//defining the business logic
@Service
public class LandService {
	@Autowired
	private com.sprint2.repository.LandRepository LandRepository;
	
	
	//getting  Land record by using the method getLandBylandId() of JpaRepository
	public Land getLandBylandId(Integer landId)
	{
		try 
		{
			return LandRepository.findById(landId).get();
		}
		catch(InvalidOperation ie)
		{
			ie.printStackTrace();
			return null;
		}
	}
	
	//Adding Land record by using the method addLand() of JpaRepository
	public Land addLand(Land Land) {
		
		
		if(Land!=null)
		{
			return LandRepository.save(Land);
		}
		else
		{	
			throw new InvalidOperation("cannot find Land");
			
		}
	
	}
	
	//updating Land record by using the method updateLand() of JpaRepository
	public Land updateLand(Land Land) {
		if( Land!=null)
		{
			LandRepository.save(Land);
			return Land;
		}
		else
		{
			throw new InvalidOperation("Land not updated");
			
		}
	}
	
	//deleting a specific Land record by using the method deleteLandbylandId() of JpaRepository
	public boolean deleteLandbylandId(Integer landId) 
	{
		if(landId!=null)
		{
			LandRepository.deleteById(landId);
			return true;
			
		}
		else
		{
			throw new InvalidOperation("Land cannot deleted");
			
		}
	
	}
	
	//getting all the Land details by using method List<Land>() of JpaRepository
	public List<Land> getAllLands() {
		List<Land> Landlist=new ArrayList<Land>();
		LandRepository.findAll().forEach(land->Landlist.add(land));
		return Landlist;
	
	}	
}

