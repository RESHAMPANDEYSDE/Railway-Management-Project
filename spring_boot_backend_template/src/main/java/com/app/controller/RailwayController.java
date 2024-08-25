package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RailwayDTO;
import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.repository.RailwayRepository;
import com.app.services.RailwayServices;



@RestController
@RequestMapping("/railway")
public class RailwayController {
	@Autowired
	private RailwayServices railwayServices;
	
	/*
	 * @GetMapping public List<Railway> getAllDetails(){ return
	 * railwayServices.getDetails(); }
	 */
	
	@PostMapping
	public Railway addAllDetails(@RequestBody Railway railway)
	{
		return railwayServices.addDetails(railway);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteId(@PathVariable Long id)
	{
		String railway=railwayServices.deleteRailway(id);
		
		if(railway==null)
		{
			return new ResponseEntity<>("Invalid id",HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(railway);
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Railway>>  getDetailsCategory(Category category)
	{
		List<Railway> railways= railwayServices.getDetailsCategory(category);
		if(railways.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(railways);
	}

	@PutMapping
	public Railway update(@RequestBody Railway railway)
	{
		return railwayServices.updateDetails(railway);
	}
	
	@GetMapping("{id}")
	public Railway getID(@PathVariable Long id)
	{
		return railwayServices.getById(id);
	}
	
	@GetMapping
	public List<RailwayDTO> getDetails()
	{
		return railwayServices.getDetails();
	}
	
}
