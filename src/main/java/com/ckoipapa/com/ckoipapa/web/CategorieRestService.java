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

import com.ckoipapa.com.ckoipapa.dao.CategorieRepository;
import com.ckoipapa.com.ckoipapa.entities.Categorie;

@RestController
public class CategorieRestService {
	@Autowired
	private CategorieRepository categorieRepository;
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public List<Categorie> getcategories(){
		return categorieRepository.findAll();
	}
	
	@RequestMapping(value="/categorie/{id}", method=RequestMethod.GET)
	public Optional<Categorie> getcategorie(@PathVariable Long id){
		return categorieRepository.findById(id);
	}
	
	@RequestMapping(value="/categorie", method=RequestMethod.POST)
	public Categorie savecategorie(@RequestBody Categorie c){
		return categorieRepository.save(c);
	}
	
	@RequestMapping(value="/categorie/{id}", method=RequestMethod.DELETE)
	public boolean deletecategorie(@PathVariable Long id){
		categorieRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/categorie/{id}", method=RequestMethod.PUT)
	public Categorie updatecategorie(@PathVariable Long id, @RequestBody Categorie c){
		c.setId(id);
		return categorieRepository.save(c);
	}

	
}
