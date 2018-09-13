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

import com.ckoipapa.com.ckoipapa.dao.ClientRepository;
import com.ckoipapa.com.ckoipapa.dao.ContactRepository;
import com.ckoipapa.com.ckoipapa.entities.Client;
import com.ckoipapa.com.ckoipapa.entities.Contact;

@RestController
public class ClientRestService {
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	@RequestMapping(value="/client/{id}", method=RequestMethod.GET)
	public Optional<Client> getClient(@PathVariable Long id){
		return clientRepository.findById(id);
	}
	
	@RequestMapping(value="/client", method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client c){
		return clientRepository.save(c);
	}
	
	@RequestMapping(value="/client/{id}", method=RequestMethod.DELETE)
	public boolean deleteClient(@PathVariable Long id){
		clientRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/client/{id}", method=RequestMethod.PUT)
	public Client updateClient(@PathVariable Long id, @RequestBody Client c){
		c.setId(id);
		return clientRepository.save(c);
	}
	
	
}
