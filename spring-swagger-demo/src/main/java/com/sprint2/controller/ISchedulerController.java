package com.sprint2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.Scheduler;

public interface ISchedulerController {
	public @ResponseBody Scheduler getSchedulerById(@PathVariable Integer schedulerId);
	public @ResponseBody Scheduler addScheduler(@RequestBody Scheduler scheduler);
	public @ResponseBody Scheduler updateScheduler(@PathVariable Integer schedulerId,@RequestBody Scheduler scheduler);
	public @ResponseBody boolean deleteScheduler(@PathVariable Integer schedulerId);
	public @ResponseBody List<Scheduler> getAllScheduler();
	
}
