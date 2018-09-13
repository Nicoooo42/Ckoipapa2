package com.ckoipapa.com.ckoipapa.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class AppRole {
	@Id  @GeneratedValue	
	private Long id;
	private String roleName;
	
	
	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AppRole(String roleName) {
		super();
		this.roleName = roleName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	
}

