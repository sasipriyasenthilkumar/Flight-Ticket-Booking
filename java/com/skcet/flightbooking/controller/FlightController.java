package com.skcet.flightbooking.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.flightbooking.entity.FlightEntity;
import com.skcet.flightbooking.service.FlightService;


@RestController
@CrossOrigin
public class FlightController {
	Logger logger = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	private FlightService flightService;
	

	@PostMapping(path="/saveflight")
	public FlightEntity saveFlights(@RequestBody FlightEntity f) {
		return flightService.saveFlights(f);
	}
	
	//Pagination and Sorting
	
	@GetMapping(path="/page")
	public ResponseEntity<Page<FlightEntity>> getFlightsByField(@RequestParam String field,@RequestParam int pageNo,@RequestParam int pageSize){
		Page<FlightEntity> flights=flightService.getFlightsByField(field, pageNo, pageSize);
		return ResponseEntity.ok(flights);
	}
	
	
	
	//CRUD operation
	
	@GetMapping("/{flightId}")
	public ResponseEntity<FlightEntity> getFlight(@PathVariable Long flightId) {
		FlightEntity flight = flightService.getFlight(flightId);
		if (flight == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(flight);
	}
	
	
//	@PostMapping(path="/post")
//	public ResponseEntity<Long> addFlight(@RequestBody FlightEntity f) {
//		Long flightId = flightService.addFlight(f);
//		return ResponseEntity.status(HttpStatus.CREATED).body(flightId);
//	}
	
	
	@GetMapping(path="/get")
	public ResponseEntity<List<FlightEntity>> getAllFlights(){
		List<FlightEntity> flight = flightService.getAllFlights();
		return ResponseEntity.status(HttpStatus.OK).body(flight);
	}
	
	
	@PutMapping(path="/put")
	public ResponseEntity<String> updateBook(@RequestBody FlightEntity f) {
		flightService.updateFlight(f);
		return ResponseEntity.ok("Updated");
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteFlight(@RequestBody FlightEntity f) {
		flightService.deleteFlight(f.getFlightId());
		return ResponseEntity.ok("Deleted");
	}
	
	@DeleteMapping("deletebyid/{id}")
	public ResponseEntity <String> deleteinfo(@PathVariable long id) {
		flightService.deleteinfo(id);
		return ResponseEntity.ok("deleted");
	}
	//JPQL
	
	@GetMapping("/getFlightsUsingJPQL")
	public List<FlightEntity> getAllFlightsUsingJPQL(){
		return flightService.getAllFlightsUsingJPQL();
	}
    @PutMapping("update/{newtype}/{old}")
    public String updateinfo(@PathVariable String newtype,@PathVariable int old) {
    	flightService.upadteinfo(newtype , old);
    	return "updated";
    	
    }
    @GetMapping("showquerybusname/{id}/{name}")
	public List<FlightEntity> getbusinfo(@PathVariable String id,@PathVariable String name){
		return flightService.getbusinfo(id, name);
	}
//    @DeleteMapping("delete/{id}")
//    public String deleteinfo(@PathVariable String )
	@GetMapping(path="/loggerdemo")
	public String loggerDemo() {
		logger.info("Logger info");
		logger.warn("Logger warn");
		logger.error("logger error");
		return "Hello from logger demo";
	}
}