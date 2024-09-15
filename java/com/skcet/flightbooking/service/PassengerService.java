package com.skcet.flightbooking.service;

import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.skcet.flightbooking.entity.PassengerEntity;
//import com.skcet.flightbooking.entity.FlightEntity;
import com.skcet.flightbooking.repository.PassengerRepository;
@Service
public class PassengerService {
@Autowired
private PassengerRepository re;

public PassengerEntity add(PassengerEntity d) {
	return re.save(d);
}
public List<PassengerEntity> showdetails(PassengerEntity d){
	return re.findAll();
}
public List<PassengerEntity> saveall(List<PassengerEntity> ss){
	   return (List<PassengerEntity>) re.saveAll(ss);
}
public Optional<PassengerEntity> showbyid(int id){
	   return re.findById(id);
}
public PassengerEntity modify(PassengerEntity d) {
	return re.saveAndFlush(d);
}
public String updateinfobyid(int id,PassengerEntity s) {
	re.saveAndFlush(s);
	if(re.existsById(id)) {
		return "Updated";
	}
	else {
		return "Enter valid id";
	}
}
public void remove(PassengerEntity d) {
	re.delete(d);
	
}
public void delid(int id) {
	re.deleteById(id);
}
public PassengerEntity addbus(PassengerEntity d) {
	return re.save(d);
}
public List<PassengerEntity> showbusdetails(PassengerEntity d){
	return re.findAll();
}
public List<PassengerEntity> sortinfo(String s){
	 return re.findAll(Sort.by(Sort.Direction.ASC, s));
}
public List<PassengerEntity> getbypage(int pagno,int pagsize){
	 Page<PassengerEntity> c=re.findAll(PageRequest.of(pagno, pagsize));
	 return c.getContent();
}
public List<PassengerEntity> getbypagesort(int pagno,int pagsize,String s){
	 Page<PassengerEntity> c=re.findAll(PageRequest.of(pagno,pagsize,Sort.by(Sort.Direction.ASC, s)));
	 return c.getContent();
}
public List<PassengerEntity> getperinfo(int id,String name){
	return re.getinfo(id, name);
}
public int delperinfo(int id) {
	   re.deleteinfo(id);
	   return id;
}
public String updateperinfo(String name,String id2) {
	   re.updateinfo(name, id2);
	   return "Updated";
}
public List<PassengerEntity> getperdetails(String email){
	return re.getinfobyemails(email);
}
}