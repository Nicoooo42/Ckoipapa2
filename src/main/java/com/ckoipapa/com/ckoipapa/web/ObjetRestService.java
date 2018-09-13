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

import com.ckoipapa.com.ckoipapa.dao.ObjetRepository;
import com.ckoipapa.com.ckoipapa.entities.Objet;

@RestController
public class ObjetRestService {
	@Autowired
	private ObjetRepository objetRepository;
	
	@RequestMapping(value="/objets", method=RequestMethod.GET)
	public List<Objet> getobjets(){
		return objetRepository.findAll();
	}
	
	@RequestMapping(value="/objet/{id}", method=RequestMethod.GET)
	public Optional<Objet> getobjet(@PathVariable Long id){
		return objetRepository.findById(id);
	}
	
	@RequestMapping(value="/objet", method=RequestMethod.POST)
	public Objet saveobjet(@RequestBody Objet c){
		return objetRepository.save(c);
	}
	
	@RequestMapping(value="/objet/{id}", method=RequestMethod.DELETE)
	public boolean deleteobjet(@PathVariable Long id){
		objetRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/objet/{id}", method=RequestMethod.PUT)
	public Objet updateobjet(@PathVariable Long id, @RequestBody Objet c){
		c.setId(id);
		return objetRepository.save(c);
	}

	
}
