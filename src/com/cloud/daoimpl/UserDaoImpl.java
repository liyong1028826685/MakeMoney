package com.cloud.daoimpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cloud.bean.User;
import com.cloud.dao.UserDao;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void delete(User user) throws Exception {
		getSession().delete(user);
	}

	public User getUser(User user) throws Exception {
		return (User)getSession().get(User.class, user.getId());
	}

	public void save(User user) throws Exception {
		getSession().save(user);
	}

	public void update(User user) throws Exception {
		getSession().update(user);
	}

	public User getUserByPasswordName(String passowrd, String username)
			throws Exception {
		User user=null;
		String sql="from User u where u.user_name=? and u.user_pass=? ";
		Query query= getSession().createQuery(sql);
		query.setParameter(0, username);
		query.setParameter(1, passowrd);
		List<User> list=query.list();
		if(list.size()>0){
			user=list.get(0);
		}
		return user;
	}

	public User getUserByName(String username) throws Exception {
		String sql="from User u where u.user_name=? ";
		Query query= getSession().createQuery(sql);
		query.setParameter(0, username);
		
		return (User)query.uniqueResult();
	}
	
}
