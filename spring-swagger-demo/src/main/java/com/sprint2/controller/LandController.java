package com.sprint2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.Land;




//connect from postman as http://localhost:8080/swagger-ui.html
@Controller
@RequestMapping("/Land")
public class LandController implements ILandController{
	Logger logger=LoggerFactory.getLogger(LandController.class);
	
	//autowire the LandService class
	
	@Autowired
	private com.sprint2.service.LandService LandService;
	
	//creating a get mapping that retrieves the detail of a specific Land
	@GetMapping("/{landId}")
	public @ResponseBody Land getLandBylandId(@PathVariable Integer landId)
	{
		logger.info("land service was instalized");
		return LandService.getLandBylandId(landId);
		
	}
	//creating post mapping that post the Land detail in the database
	@PostMapping("/")
	public @ResponseBody Land addLand(@RequestBody Land Land)
	{
		return LandService.addLand(Land);
	}
	//creating put mapping that updates the Land detail
	@PutMapping("/")
	public @ResponseBody Land updateLand(@RequestBody Land Land)
	{
		return LandService.updateLand(Land);
		
	}
	//creating a delete mapping that deletes a specified Land
	
	@DeleteMapping("/{landId}")
	public @ResponseBody boolean deleteLandbylandId(@PathVariable Integer landId)
	{
		return LandService.deleteLandbylandId(landId);
	}
	
	//creating a get mapping that retrieves all the land detail from the database
	@GetMapping("/")
	public @ResponseBody List<Land> getAllLand()
	{
		List<Land> Landlist=LandService.getAllLands();
		return Landlist;
	}
	
	
	
	
	
	
}

