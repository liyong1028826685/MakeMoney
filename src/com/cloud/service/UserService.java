package com.cloud.service;

import com.cloud.bean.User;

public interface UserService {
	public void save(User user)throws Exception;
	public void delete(User user)throws Exception;
	public void update(User user)throws Exception;
	public User getUser(User user)throws Exception;
	public User getUserByPasswordName(String passowrd,String username)throws Exception;
	public User getUserByName(String username) throws Exception ;
}
