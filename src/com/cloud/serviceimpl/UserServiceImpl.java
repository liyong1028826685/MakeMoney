package com.cloud.serviceimpl;

import org.springframework.transaction.annotation.Transactional;

import com.cloud.bean.User;
import com.cloud.dao.UserDao;
import com.cloud.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Transactional
	public void delete(User user)throws Exception {
		
			userDao.delete(user);
	}

	public User getUser(User user) throws Exception{
		User tuser=null;
		tuser=userDao.getUser(user);
		return tuser;
	}
	@Transactional
	public void save(User user) throws Exception{
		userDao.save(user);
	}
	@Transactional
	public void update(User user)throws Exception {
		userDao.update(user);
	}
	@Transactional
	public User getUserByPasswordName(String passowrd, String username)
			throws Exception {
		
		return userDao.getUserByPasswordName(passowrd, username);
	}
	@Transactional
	public User getUserByName(String username) throws Exception {
		return userDao.getUserByName(username);
	}

}
