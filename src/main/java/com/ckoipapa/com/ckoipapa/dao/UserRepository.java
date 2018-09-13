package com.ckoipapa.com.ckoipapa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ckoipapa.com.ckoipapa.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long>{
	public AppUser findByUsername(String username);
}
