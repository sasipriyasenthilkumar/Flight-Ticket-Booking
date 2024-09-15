package com.skcet.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.skcet.flightbooking.entity.LoginEntity;



public interface LoginRepository extends JpaRepository<LoginEntity, Integer>{
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM LoginEntity c WHERE c.emailid = :email and c.password=:pass")
    boolean existsByName(@Param("email") String email,@Param("pass") String pass);
	@Modifying
	@Transactional
	@Query(value ="delete from Login_details where emailid=:s",nativeQuery = true)
	public int deletelogin(@Param("s") String emailid);

}