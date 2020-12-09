package com.sprint2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.Contract;

public interface IContractController {
	public @ResponseBody Contract getContractBycontractNumber(@PathVariable Integer contractNumber);
	public @ResponseBody Contract addContract(@RequestBody Contract Contract);
	public @ResponseBody Contract updateContract(@RequestBody Contract Contract);
	public @ResponseBody boolean deleteContractbycontractNumber(@PathVariable Integer contractNumber);
	public @ResponseBody List<Contract> getAllContract();
	
}
