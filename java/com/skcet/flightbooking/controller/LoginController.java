package com.skcet.flightbooking.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.flightbooking.entity.LoginEntity;
import com.skcet.flightbooking.service.LoginService;


@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	LoginService cs;
	@PostMapping("addlogin")
	public LoginEntity adddetails(@RequestBody LoginEntity d) {
		return cs.add(d);
	}
	@GetMapping("displogin")
	public List<LoginEntity> show(LoginEntity d) {
		return cs.showdetails(d);
	}
	@GetMapping("getlogin/{emailid}/{password}")
	public boolean login(@PathVariable String emailid,@PathVariable String password){
		return cs.getsignups(emailid, password);	
	}
	@DeleteMapping("dellogin/{email}")
	public int dellogin(@PathVariable String email) {
	  return cs.dellogin(email);
		//return "Deleted";
	}
	}