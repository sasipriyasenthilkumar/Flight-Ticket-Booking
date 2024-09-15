package com.skcet.flightbooking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skcet.flightbooking.entity.PassengerEntity;

import jakarta.transaction.Transactional;

public interface  PassengerRepository extends JpaRepository<PassengerEntity,Integer>{
	 @Modifying
	    @Transactional
	    @Query(value="update passenger_entity set passenegr_mail=?1 where passenger_id=?2",nativeQuery = true)
	    public int updateinfo(String newmail,int oldid);

			@Query(value = "select * from passenger_entity where id=:s or name=:ns",nativeQuery = true)
			public List<PassengerEntity> getinfo(@Param("s") int id,@Param("ns") String name);
			@Modifying
			@Transactional
			@Query(value ="delete from passenger_entity where id=:s",nativeQuery = true)
			public int deleteinfo(@Param("s") int id);
			@Modifying
			@Transactional
			@Query(value="update passenger_entity set name=?1 where emailid=?2",nativeQuery = true)
			public int updateinfo(String newname,String oldid);
			@Query(value = "select * from passenger_entity where emailid=:ns",nativeQuery = true)
			public List<PassengerEntity> getinfobyemails(@Param("ns") String emailid);
}