package com.sprint2.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.sprint2.Exceptions.InvalidOperation;
import com.sprint2.model.Admin;
import com.sprint2.repository.AdminRepository;
import com.sprint2.service.AdminService;



@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/fms/m1/")              //Maps a specific request path or pattern onto a controller
public class AdminController implements IAdminController{
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired                   // To establish relationship with admin service
	private AdminService adminService;
	
	@Autowired
	private AdminRepository adminrepo;
	
	@GetMapping("/admins/{id}")                // To get the admin record based on admin id
	public @ResponseBody Admin getAdminById(@PathVariable Integer id)
	{
		logger.info("User is trying to get records based on id. ");
		return adminService.getAdminById(id);
		
	}
	@PostMapping("/admins")           // @PostMapping is used to insert admin records 
	public @ResponseBody Admin insertAdmin(@RequestBody Admin admin)
	{
		return adminService.insertAdmin(admin);
	}
	@PutMapping("/admins/{id}")              //@PutMapping is used to update admin records
	public ResponseEntity<Admin> updateAdmin(@PathVariable Integer id ,@RequestBody Admin admin)
	{
		Admin admin1=adminrepo.findById(id).orElseThrow(()->new InvalidOperation("Admin not exist with id:"+id));
		admin1.setAdminName(admin.getAdminName());
		admin1.setAdminPassword(admin.getAdminPassword());
		Admin updatedadmin= adminrepo.save(admin1);
		return ResponseEntity.ok(updatedadmin);
		
	}
	
	@DeleteMapping("/admins/{id}")       // @DeleteMapping is used to delete admin records
	public @ResponseBody boolean deleteAdmin(@PathVariable Integer id)
	{
		return adminService.deleteAdminbyId(id);
	}
	
	@GetMapping("/admins")             // To get all the records in the table
	public @ResponseBody List<Admin> getAllAdmin()
	{
		List<Admin> adminlist=adminService.getAllAdmins();
		return adminlist;
	}
	
	
	
	
	
	
}
