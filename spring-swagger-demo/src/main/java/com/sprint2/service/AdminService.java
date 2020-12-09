package com.sprint2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint2.Exceptions.InvalidOperation;
import com.sprint2.model.Admin;
import com.sprint2.repository.AdminRepository;
import com.sprint2.utility.ValidateAdmin;



@Service               //@Service annotation is used to mark the class as a service provider
public class AdminService{    //AdminService should implement all the methods present in IAdminService interface
	@Autowired    // To establish a relationship with Admin repository
	private AdminRepository adminRepository;
	
	public Admin getAdminById(Integer id) {
		try {
			return adminRepository.findById(id).get();   // findById is a method present in JpaRepositiry
		}
		catch(InvalidOperation ie)
		{
			ie.printStackTrace();   //prints the default message stating the exception occured
			return null;
		}
	}
	public Admin insertAdmin(Admin admin) {
		if(admin.getAdminName().matches(ValidateAdmin.nameregex) && admin.getAdminPassword().matches(ValidateAdmin.passwordregex))
		{
			return adminRepository.save(admin);  // save() is used to insert records in the table
		}
		else{
			
			throw new InvalidOperation("Admin not inserted");  //throws User defined exception if user enters a invalid name or password
		}
	}
	
	public boolean deleteAdminbyId(Integer id) {
		try {
			adminRepository.deleteById(id);   //deleteById() is a predefined method present in JpaRepository
			return true;
		}
		catch(InvalidOperation ie)
		{
			throw new InvalidOperation("Admin not deleted");
		}
	
	}
	public List<Admin> getAllAdmins() {
		List<Admin> adminlist=new ArrayList<>(); 
		adminRepository.findAll().forEach(admin->adminlist.add(admin));   //findall method is used to get all the records present in the table.
		return adminlist;
	}
	
}
