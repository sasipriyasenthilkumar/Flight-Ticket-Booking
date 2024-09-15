package com.skcet.flightbooking.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.skcet.flightbooking.entity.FlightEntity;
import com.skcet.flightbooking.repository.FlightRepository;



@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public FlightEntity saveFlights(FlightEntity f) {
		return flightRepository.save(f);
	}
	
	//Pagination and Sorting
	
	public Page<FlightEntity> getFlightsByField(String field,int pageNo,int pageSize){
		Sort sort=Sort.by(field);
		Pageable pageable=PageRequest.of(pageNo, pageSize, sort);
		return flightRepository.findAll(pageable);
	}
	
	
	
	//CRUD operation
	public FlightEntity getFlight(Long flightId) {
		Optional<FlightEntity> optional=flightRepository.findById(flightId);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

//	public Long addFlight(FlightEntity f){
//		FlightEntity save=flightRepository.save(f);
//		return save.getFlightId();
//		}
	
	public List<FlightEntity> getAllFlights(){
		return flightRepository.findAll();
	}
	
	public void updateFlight(FlightEntity f) {
		flightRepository.save(f);
		
	}
	
	public void deleteFlight(Long flightId) {
		Optional<FlightEntity> optional = flightRepository.findById(flightId);
		if(optional.isPresent()) {
		  flightRepository.delete(optional.get());
		}
	}
	public void deleteinfo(Long flightId) {
		Optional<FlightEntity> optional = flightRepository.findById(flightId);
		if(optional.isPresent()) {
		  flightRepository.delete(optional.get());
		}
	}
	//JPQL
	
	public List<FlightEntity> getAllFlightsUsingJPQL(){
		return flightRepository.getAllFlightsUsingJPQL();
	}
    public String upadteinfo(String type,int id1) {
    	flightRepository.updateinfo(type,id1);
    	return "updated";
    }
    public List<FlightEntity> getbusinfo(String id,String flightName){
		return flightRepository.getbusinfo(id, flightName);
	}
	
}