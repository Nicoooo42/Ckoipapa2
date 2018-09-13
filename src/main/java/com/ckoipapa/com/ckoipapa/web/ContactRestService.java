package com.ckoipapa.com.ckoipapa.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ckoipapa.com.ckoipapa.dao.ContactRepository;
import com.ckoipapa.com.ckoipapa.entities.Contact;

@RestController
public class ContactRestService {
	@Autowired
	private ContactRepository contactRepository;
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
	@RequestMapping(value="/contact/{id}", method=RequestMethod.GET)
	public Optional<Contact> getContact(@PathVariable Long id){
		return contactRepository.findById(id);
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact c){
		return contactRepository.save(c);
	}
	
	@RequestMapping(value="/contact/{id}", method=RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable Long id){
		contactRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/contact/{id}", method=RequestMethod.PUT)
	public Contact updateContact(@PathVariable Long id, @RequestBody Contact c){
		c.setId(id);
		return contactRepository.save(c);
	}
	

	@RequestMapping(value="/cherchercontact", method=RequestMethod.GET)
	public Page<Contact> chercherContact(
			@RequestParam(name="mc", defaultValue="") String mc, 
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return contactRepository.chercher(mc, new PageRequest(page, size));
	}
	
}
