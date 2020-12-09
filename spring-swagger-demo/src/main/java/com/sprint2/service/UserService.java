package com.sprint2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint2.Exceptions.InvalidOperation;
import com.sprint2.model.User;
import com.sprint2.repository.UserRepository;




@Service    //@Service annotation is used to mark the class as a service provider
public class UserService implements IUserService

{

	@Autowired     // To establish relationship between UserRepository and UserService
	private UserRepository userrepository;
	
	public String login(User user) {
		
		String userName=user.getUserName();
		User loginUser=userrepository.findById(userName).get();  //findById is used to find any particular record using id
		if(loginUser==null)
		{
			
			try {
			throw new InvalidOperation("Please enter correct details");
			}
			catch(InvalidOperation ie)       // throws the user defined exceptionwhen details entered by the user is does not match the record in database
			{
				System.out.println(ie);
			}
		}
		else
		{
			String pwd=loginUser.getUserPassword();
			String uname=loginUser.getUserName();
			if(pwd.equals(user.getUserPassword()) && uname.equalsIgnoreCase(user.getUserName()))
			{
				return loginUser.getUserName()+" has successfully logged in";
			}
		}
		return null;
	}
	
	public User insertUser(User user) {
		if(user!=null)
		{
			return userrepository.save(user);  //Save() method is used to insert record into the table.
		}
		else
		{
			throw new InvalidOperation("user not added");
		}
	}
	public boolean deleteAdminbyName(String userName) {
		if(userName!=null) {
			userrepository.deleteById(userName);  //DeleteById method is presesnt in JpaRepository used to delete a record based on Id
			return true;
		}
		else
		{
			throw new InvalidOperation("User deleted");
		}
	}
	
	public String logout(User user) {
		return  user.getUserName()+ " has logged out successfully";
	}
	


}
