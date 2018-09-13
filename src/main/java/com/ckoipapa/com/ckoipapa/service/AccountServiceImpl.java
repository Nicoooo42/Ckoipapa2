package com.ckoipapa.com.ckoipapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ckoipapa.com.ckoipapa.dao.RoleRepository;
import com.ckoipapa.com.ckoipapa.dao.UserRepository;
import com.ckoipapa.com.ckoipapa.entities.AppRole;
import com.ckoipapa.com.ckoipapa.entities.AppUser;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public AppUser saveUser(AppUser user) {
		String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUse(String username, String roleName) {
		AppRole role= roleRepository.findByRoleName(roleName);
		AppUser user= userRepository.findByUsername(username);
		user.getRole().add(role);
	}

	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
		
	}

}
