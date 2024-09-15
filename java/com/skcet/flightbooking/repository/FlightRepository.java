package com.skcet.flightbooking.repository;


import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;

import com.skcet.flightbooking.entity.FlightEntity;
//import com.skcet.flightbooking.entity.PassengerEntity;

import jakarta.transaction.Transactional;


public interface FlightRepository extends JpaRepository<FlightEntity,Long>{
   
	      //JPQL
	
	    @Query("select f from FlightEntity f")
	   public List<FlightEntity> getAllFlightsUsingJPQL();
	    @Query(value = "select * from flight_entity where boarding=:s and destination=:ns",nativeQuery = true)
		public List<FlightEntity> getbusinfo(@Param("s") String id,@Param("ns") String flightName);
	    
	    @Modifying
	    @Transactional
	    @Query(value="update flight_entity set class_type=?1 where flight_Id=?2",nativeQuery = true)
	    public int updateinfo(String newtype,int oldid);
	    

}

