package com.app.services;

import java.util.List;

import com.app.dto.RailwayDTO;
import com.app.entity.Category;
import com.app.entity.Railway;

public interface RailwayServices {
	// display
	//List<Railway> getDetails();

	// display by category
	List<Railway> getDetailsCategory(Category category);

	// display by id
	Railway getById(Long id);

	// insert
	Railway addDetails(Railway railway);

	// delete
	String deleteRailway(Long id);

	// update
	Railway updateDetails(Railway railway);
	
	
	//display DTO
	List<RailwayDTO> getDetails();

}
