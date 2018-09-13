package com.ckoipapa.com.ckoipapa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ckoipapa.com.ckoipapa.dao.ContactRepository;
import com.ckoipapa.com.ckoipapa.entities.AppRole;
import com.ckoipapa.com.ckoipapa.entities.AppUser;
import com.ckoipapa.com.ckoipapa.entities.Contact;
import com.ckoipapa.com.ckoipapa.service.AccountService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean 
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		
//		accountService.saveRole(new AppRole("ADMIN"));
//		accountService.saveRole(new AppRole("USER"));
		
//		accountService.saveUser(new AppUser("admin", "1234", null));
//		accountService.saveUser(new AppUser("user", "1234", null));
		
//		accountService.addRoleToUse("admin", "ADMIN");
//		accountService.addRoleToUse("user", "USER");
		
		
//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		contactRepository.save(new Contact("Nicolas","Lamanna", df.parse("12/01/1987"), "nicolas .gomail.fr", 0560, "nicolas.jpg"));
//		contactRepository.findAll().forEach(c->{
//			System.out.println(c.getNom());
//		});
	}
}
