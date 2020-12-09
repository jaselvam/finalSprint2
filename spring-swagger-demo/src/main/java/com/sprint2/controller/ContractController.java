package com.sprint2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.Contract;
import com.sprint2.service.*;


//connect from postman as http://localhost:8082/swagger-ui.html
@Controller
@RequestMapping("/Contract")
public class ContractController{
	Logger logger=LoggerFactory.getLogger(ContractController.class);
	
	//autowire the ContractService class 
	@Autowired
	private ContractService ContractService;
	
	//creating a get mapping that retrieves the detail of a specific Contract
	@GetMapping("/{contractNumber}")
	public @ResponseBody Contract getContractBycontractNumber(@PathVariable Integer contractNumber)
	{
		logger.info("product service was instalized");
		return ContractService.getContractBycontractNumber(contractNumber);
	}
	
	
	//creating post mapping that post the Contract detail in the database
	@PostMapping("/")
	public @ResponseBody Contract addContract(@RequestBody Contract Contract)
	{
		return ContractService.addContract(Contract);
	}
	
	//creating put mapping that updates the Contract detail
	@PutMapping("/{contractNumber}")
	public @ResponseBody Contract updateContract(@RequestBody Contract Contract)
	{
		return ContractService.updateContract(Contract);
	}
	
	//creating a delete mapping that deletes a specified Contract
	@DeleteMapping("/{contractNumber}")
	public @ResponseBody boolean deleteContractbycontractNumber(@PathVariable Integer contractNumber)
	{
		return ContractService.deleteContractbycontractNumber(contractNumber);
	}
	

	//creating a get mapping that retrieves all the contract detail from the database
	@GetMapping("/")
	public @ResponseBody List<Contract> getAllContract()
	{
		List<Contract> Contractlist=ContractService.getAllContracts();
		return Contractlist;
	}


	


}