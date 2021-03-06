package com.sprint2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sprint2.Exceptions.InvalidOperation;
import com.sprint2.model.Contract;
import com.sprint2.repository.ContractRepository;
import com.sprint2.utility.ValidateContract;
;


@Service
public class ContractService implements IContractService{
	@Autowired
	private ContractRepository contractRepository;
	
	//getting Contract record by using the method getContractBycontractNumber() of JpaRepository
	public Contract getContractBycontractNumber(Integer contractNumber) {
		try 
		{
			//getting a specific record by using the method findById() of JpaRepository
			return contractRepository.findById(contractNumber).get();
		}
		catch(NoSuchElementException | IllegalArgumentException  ie )
		{
			throw new InvalidOperation("Enter the correct Contract Number");
			
		}

	}
	
	//Adding Contract record by using the method addContract() of JpaRepository
	public Contract addContract(Contract Contract) {
		if(Contract!=null && Contract.getDeliveryDate().matches(ValidateContract.dateregex))
		{
			//saving a specific record by using the method save() of JpaRepository
			return contractRepository.save(Contract);
		}
		else
		{
			throw new InvalidOperation("Enter correct Contract details");
		}	
	
	}
	
	//updating Contract record by using the method updateContract() of JpaRepository
	public Contract updateContract( Contract Contract)
	{
		//validating the DeliveryDate by using the ValidateContract class
		if(Contract.getDeliveryDate().matches(ValidateContract.dateregex)) {
			System.out.println( "Contract details are successfully updated");
				return contractRepository.save(Contract);
				
		}
		else
			throw new InvalidOperation("Contract is not found with given id");
				
	}
	
	//deleting a specific Contract record by using the method deleteContractbycontractNumber() of JpaRepository
	public boolean deleteContractbycontractNumber(Integer contractNumber) 
	{
		try 
		{
			System.out.println("Please enter a Integer value : ");
			contractRepository.deleteById(contractNumber);
			System.out.println( "Contract details are successfully deleted");
			return true;
		}
		catch( IllegalArgumentException | EmptyResultDataAccessException ie)
		{
				throw new InvalidOperation("Contract not deleted \n enter the correct id");
		}
		
	}
	
	//getting all the contract details by using method List<Contract>() of JpaRepository
	public List<Contract> getAllContracts() {
		List<Contract> Contractlist=new ArrayList<Contract>();
		contractRepository.findAll().forEach(Contract->Contractlist.add(Contract));
		return Contractlist;
	
	}
		
}
