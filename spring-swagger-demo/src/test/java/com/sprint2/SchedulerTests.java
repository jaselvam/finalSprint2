package com.sprint2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sprint2.controller.SchedulerController;
import com.sprint2.model.Scheduler;
import com.sprint2.service.SchedulerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;



@ExtendWith(MockitoExtension.class)
public class SchedulerTests 
{
	@Mock
	SchedulerService schedulerService;
	
	@InjectMocks
	SchedulerController schedulerController;
	
	@Test
	public void testupdateScheduler()
	{
		Scheduler scheduler=new Scheduler(16,"janani","9784512634","1003");
		Mockito.when(schedulerController.updateScheduler(scheduler)).thenReturn(scheduler);
		assertEquals(scheduler,schedulerController.updateScheduler(scheduler));

	}
	@Test
    public void testgetAllSchedulers() {
        List<Scheduler> scheduler=new ArrayList<Scheduler>();
        Mockito.when(schedulerController.getAllScheduler()).thenReturn(scheduler);
        assertEquals(scheduler,schedulerController.getAllScheduler());

    }
	@Test
	public void testaddScheduler() 
	{
		Scheduler s1=new Scheduler(19,"john","9236514780","1007");
		Mockito.when(schedulerController.addScheduler(s1)).thenReturn(s1);
	    assertEquals(s1,schedulerController.addScheduler(s1));
	}
	@Test
    public void testgetSchedulerById() 
	{
		Scheduler scheduler=new Scheduler();
        Mockito.when(schedulerController.getSchedulerById(16)).thenReturn(scheduler);
        assertEquals(scheduler,schedulerController.getSchedulerById(16));

    }
	@Test
	 public void testdeleteScheduler() {
		 Boolean str1= true;
		 int schedulerId=15;
		 Mockito.when(schedulerController.deleteScheduler(schedulerId)).thenReturn(str1);
		    assertEquals(str1,schedulerController.deleteScheduler(schedulerId));
	 }
}

