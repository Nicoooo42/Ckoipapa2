package com.ckoipapa.com.ckoipapa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ckoipapa.com.ckoipapa.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long>{
	public AppRole findByRoleName(String roleName);
}
