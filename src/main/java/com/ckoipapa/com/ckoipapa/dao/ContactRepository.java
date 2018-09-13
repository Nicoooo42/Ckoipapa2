package com.ckoipapa.com.ckoipapa.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ckoipapa.com.ckoipapa.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	@Query(value = "SELECT * FROM Contact WHERE nom = ?1",
    countQuery = "SELECT count(*) FROM Contact WHERE nom = ?1",
    nativeQuery = true)
	public Page<Contact> chercher(String mc, Pageable pageable);

}
