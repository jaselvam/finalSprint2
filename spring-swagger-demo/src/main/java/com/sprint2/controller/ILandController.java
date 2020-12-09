package com.sprint2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.Land;

public interface ILandController {
	public @ResponseBody Land getLandBylandId(@PathVariable Integer landId);
	public @ResponseBody Land addLand(@RequestBody Land Land);
	public @ResponseBody Land updateLand(@RequestBody Land Land);
	public @ResponseBody boolean deleteLandbylandId(@PathVariable Integer landId);
	public @ResponseBody List<Land> getAllLand();
}
