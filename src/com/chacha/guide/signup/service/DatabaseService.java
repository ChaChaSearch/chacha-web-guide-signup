package com.chacha.guide.signup.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.guide.signup.beans.OldWorldUser;
import com.chacha.guide.signup.dao.UserDAO;
import com.chacha.guide.signup.dao.VendorDAO;

@Service
public class DatabaseService {
	
	private final UserDAO userDao;
	private final VendorDAO vendorDao;
	
	@Autowired
	public DatabaseService(UserDAO userDao, VendorDAO vendorDao) {
		super();
		this.userDao = userDao;
		this.vendorDao = vendorDao;
	}
	
	public void saveUser(OldWorldUser user) {
		Long id = userDao.createUser(user);
		LoggerFactory.getLogger(DatabaseService.class).debug("User id: {}", id);
		user.setUserId(id);
		vendorDao.createVendorRecord(user);
	}
	
	public boolean isUniqueEmail(String email) {
		return !userDao.doesEmailExist(email);
	}
	
	public boolean isUniqueHandle(String handle) {
		return !userDao.doesHandleExist(handle);
	}
	
	public boolean isUniqueSSN(String ssn) {
		return !vendorDao.doesSSNExist(ssn);
	}
	
	public boolean isUniqueEIN(String ein) {
		return !vendorDao.doesEINExist(ein);
	}
	
}
