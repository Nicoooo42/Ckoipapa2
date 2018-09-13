package com.ckoipapa.com.ckoipapa.service;

import com.ckoipapa.com.ckoipapa.entities.AppRole;
import com.ckoipapa.com.ckoipapa.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUse(String username, String roleName);
	public AppUser findUserByUsername(String username);
}
