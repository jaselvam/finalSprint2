package com.sprint2.service;

import java.util.List;

import com.sprint2.model.Scheduler;

public interface ISchedulerService {
	public Scheduler getSchedulerById(Integer schedulerId);
	public Scheduler addScheduler(Scheduler scheduler);
	public Scheduler updateScheduler(Integer schedulerId,Scheduler scheduler);
	public boolean deleteSchedulerbyId(Integer schedulerId);
	public List<Scheduler> getAllSchedulers();
	
}
