package com.youtube.jwt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.RoleDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Role;
import com.youtube.jwt.entity.User;

@Service
public class UserService {
    
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	 public User registerNewUser(User user) {
		return userDao.save(user);
		 
	 }
	 public void initRolesAndUser() {
		 Role adminRole = new Role();
		 adminRole.setRoleName("Admin");
		 adminRole.setRoleDescription("Admin role");
		 roleDao.save(adminRole);
		 
		 Role userRole = new Role();
		 userRole.setRoleName("User");
		 userRole.setRoleDescription("Default role for newly created record");
		 roleDao.save(userRole);
		 
		 User adminUser= new User();
		 adminUser.setUserFirstName("admin");
		 adminUser.setUserLastName("admin");
		 adminUser.setUserName("admin@123");
		 adminUser.setUserpassword(getEncodedPassword("admin@pass"));
		 Set<Role> adminroles = new HashSet<>();
		 adminroles.add(adminRole);
		 
		 adminUser.setRole(adminroles);
		 userDao.save(adminUser);
		 
		 User user= new User();
		 user.setUserFirstName("raj");
		 user.setUserLastName("sharma");
		 user.setUserName("raj123");
		 user.setUserpassword(getEncodedPassword("raj@pass"));
		 Set<Role> userRoles = new HashSet<>();
		 user.setRole(userRoles);
		 userRoles.add(userRole);
		 
		 userDao.save(user);
		 
		 
	 }
	 public String getEncodedPassword(String password) {
		 return passwordEncoder.encode(password);
	 }
	
}
