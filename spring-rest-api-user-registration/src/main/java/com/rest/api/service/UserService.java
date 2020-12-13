package com.rest.api.service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.model.UserRegistration;
import com.rest.api.model.UserRegistrationDateCount;
import com.rest.api.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
	private UserRepository userRepository;
	
	public List<UserRegistration> getAllUsers(){
		return userRepository.findAll();
	}
	
	public void setUsers(UserRegistration user) {
		userRepository.save(user);
	}
	
	public Integer getUserRegistration() {
		return userRepository.getEachdayUserRegistrationCount();
	}
	
	
	public List<UserRegistrationDateCount> getCount(){
		List<Object[]> result=userRepository.getCountTable();
		List<UserRegistrationDateCount> dateCount=new ArrayList<UserRegistrationDateCount>();
		for(Object[] a:result){
			UserRegistrationDateCount d=new UserRegistrationDateCount();
			d.setDate((Date) a[0]);
			d.setCount(new BigInteger(a[1].toString()).intValue());
			dateCount.add(d);
		}
		return dateCount;
	}
}
