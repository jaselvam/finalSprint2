package com.sprint2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.Admin;

public interface IAdminController {
	public @ResponseBody Admin getAdminById(@PathVariable Integer id);
	public @ResponseBody Admin insertAdmin(@RequestBody Admin admin);
	public ResponseEntity<Admin> updateAdmin(@PathVariable Integer id ,@RequestBody Admin admin);
	public @ResponseBody boolean deleteAdmin(@PathVariable Integer id);
	public @ResponseBody List<Admin> getAllAdmin();
}
