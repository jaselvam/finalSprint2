package com.sprint2.service;

import java.util.List;

import com.sprint2.model.Contract;

public interface IContractService {
	public Contract getContractBycontractNumber(Integer contractNumber);
	public Contract addContract(Contract Contract);
	public Contract updateContract( Contract Contract);
	public boolean deleteContractbycontractNumber(Integer contractNumber);
	public List<Contract> getAllContracts();
	
}
