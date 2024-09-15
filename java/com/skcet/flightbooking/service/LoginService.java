package com.skcet.flightbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.flightbooking.entity.LoginEntity;
import com.skcet.flightbooking.repository.LoginRepository;


@Service
public class LoginService {
	@Autowired
	LoginRepository re;
	public LoginEntity add(LoginEntity d) {
		return re.save(d);
	}
	public List<LoginEntity> showdetails(LoginEntity d){
		return re.findAll();
	}
	public boolean getsignups(String email,String pass){
		return re.existsByName(email,pass);
	}
	public int dellogin(String email) {
		return re.deletelogin(email);
	}
	}