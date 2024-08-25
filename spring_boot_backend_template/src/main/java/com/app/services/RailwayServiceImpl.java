package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.RailwayDTO;
import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.exception.InvalidCredentialException;
import com.app.repository.RailwayRepository;


@Service
@Transactional
public class RailwayServiceImpl implements RailwayServices {

	@Autowired
	private RailwayRepository railwayRepository;
	@Autowired
	private ModelMapper mapper;

	/*
	 * @Override public List<Railway> getDetails() {
	 * 
	 * return railwayRepository.findAll(); }
	 */

	@Override
	public Railway addDetails(Railway railway) {

		return railwayRepository.save(railway);
	}

	@Override
	public String deleteRailway(Long id) {
		if (railwayRepository.existsById(id)) {
			railwayRepository.deleteById(id);
			return "delete succefully";
		}
		return "invalid id";
	}

	@Override
	public List<Railway> getDetailsCategory(Category category) {
		return railwayRepository.findByCategory(category);
		 
	}

	@Override
	public Railway updateDetails(Railway railway) {
		
		return railwayRepository.save(railway);
	}

	@Override
	public Railway getById(Long id) {
		Optional<Railway> optional=railwayRepository.findById(id);
		return optional.orElseThrow(()->new InvalidCredentialException("invalid id"));
	}
	@Override
	public List<RailwayDTO> getDetails(){
		List<Railway> rail=railwayRepository.findAll();
		List<RailwayDTO> raildto=new ArrayList<>();
		for(Railway r:rail) {
			raildto.add(mapper.map(r, RailwayDTO.class));
		}
		return raildto;
	}
}
