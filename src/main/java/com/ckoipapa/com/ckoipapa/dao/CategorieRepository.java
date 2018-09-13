package com.ckoipapa.com.ckoipapa.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ckoipapa.com.ckoipapa.entities.AppRole;
import com.ckoipapa.com.ckoipapa.entities.Categorie;


public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	
	public Categorie findByNom(String Nom);
}
