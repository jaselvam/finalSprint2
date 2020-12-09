package com.sprint2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint2.Exceptions.InvalidOperation;
import com.sprint2.model.Scheduler;
import com.sprint2.repository.SchedulerRepository;
import com.sprint2.utility.SchedulerValidations;



//defining the logic for Scheduler
@Service
public class SchedulerService implements ISchedulerService{

	//Autowire the SchedulerRepository interface
	@Autowired
	private SchedulerRepository schedulerRepository;
	

	//Getting a specific record by using the method findById() of JpaRepository
	public Scheduler getSchedulerById(Integer schedulerId) {
		// TODO Auto-generated method stub
		
		try {
			return schedulerRepository.findById(schedulerId).get();
		}
		catch(InvalidOperation ie)
		{
			ie.printStackTrace();
			return null;
		}
	}

	//Inserting the Scheduler details into the database using the save() of JpaRepository
	public Scheduler addScheduler(Scheduler scheduler) {
		// TODO Auto-generated method stub
		
		String contactinfo=scheduler.getSchedulerContact();
		
		if(contactinfo.matches(SchedulerValidations.contactregex))
		{
			return schedulerRepository.save(scheduler);
		}
		
		else{
			
			throw new InvalidOperation("scheduler not inserted");
		}
	}

	//Updating a specific record by using the method save() of JpaRepository
	public Scheduler updateScheduler(Integer schedulerId,Scheduler scheduler) 
	{
		// TODO Auto-generated method stub
		
			if(scheduler!=null && scheduler.getSchedulerContact().matches(SchedulerValidations.contactregex))
			{
				schedulerRepository.save(scheduler);
				return scheduler;
			}
			else
			{
				throw new InvalidOperation("scheduler not updated");
				
			}
	}

	//Deleting a specific record by using the method deleteById() of JpaRepository
	public boolean deleteSchedulerbyId(Integer schedulerId) 
	{
		try 
		{
			schedulerRepository.deleteById(schedulerId);
			return true;
		}
		catch(InvalidOperation ie)
		{
			throw new InvalidOperation("Scheduler not deleted");
		}
	}


	//Getting all Scheduler record by using the method findAll() of JpaRepository
	public List<Scheduler> getAllSchedulers() 
	{
		List<Scheduler> schedulerlist=new ArrayList<Scheduler>();
		schedulerRepository.findAll().forEach(scheduler->schedulerlist.add(scheduler));
		return schedulerlist;
	}

}

