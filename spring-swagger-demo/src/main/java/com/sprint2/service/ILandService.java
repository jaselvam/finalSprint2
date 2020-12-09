package com.sprint2.service;

import java.util.List;

import com.sprint2.model.Land;

public interface ILandService {
	public Land getLandBylandId(Integer landId);
	public Land addLand(Land Land);
	public Land updateLand(Land Land);
	public boolean deleteLandbylandId(Integer landId) ;
	public List<Land> getAllLands() ;
	
}
