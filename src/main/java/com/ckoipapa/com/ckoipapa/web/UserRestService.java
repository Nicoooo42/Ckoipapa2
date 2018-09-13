package com.ckoipapa.com.ckoipapa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ckoipapa.com.ckoipapa.entities.AppUser;
import com.ckoipapa.com.ckoipapa.service.AccountService;

@RestController
public class UserRestService {
	
	@Autowired
	private AccountService accoutservice;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public AppUser register(@RequestBody UserForm userForm) {
		if(!userForm.getPassword().equals(userForm.getRepassword())) {
			throw new RuntimeException("password error");
		}
		if(accoutservice.findUserByUsername(userForm.getUsername())!= null){
			throw new RuntimeException("User already exists");
		}
		AppUser user = new AppUser();
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		accoutservice.saveUser(user);
		accoutservice.addRoleToUse(userForm.getUsername(), "USER");
		return user;
	}

}
