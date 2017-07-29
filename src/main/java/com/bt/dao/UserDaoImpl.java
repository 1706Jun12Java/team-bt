package com.bt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bt.domain.User;
import com.bt.util.HibernateUtil;

@Component(value = "userDaoImpl")
public class UserDaoImpl implements UserDao {
	@Autowired
	HibernateUtil hs;

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Session s = hs.getSession();
		users = s.createQuery("from User").list();
		s.close();
		return users;
	}

	@Override
	public User getUserById(int id) {
		Session session = null;
		User u = null;
		try {
			session = hs.getSession();
			u = (User) session.get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return u;
	}

	@Override
	public int saveUser(User u) {
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(u);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void persistUser(User u) {
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(u);
		tx.commit();
		s.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bt.dao.UserDao#updateUser(com.bt.domain.User,
	 * com.bt.domain.User) This function updates User u into User uu If the ids
	 * do not match no update function will be called and false will be returned
	 * if the ids do match User u will be updated with values from User uu
	 */
	@Override
	public boolean updateUser(User u) {
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		try {
			s.saveOrUpdate(u);
			tx.commit();
			s.close();
			return true;
		} catch (Exception e) {
			tx.rollback();
			s.close();
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bt.dao.UserDao#mergeUser(com.bt.domain.User, com.bt.domain.User)
	 * This function will merge User u and User mu User u is the old values and
	 * User mu is new set of values If ids do not match null will be returned
	 * otherwise the merged User mu will be returned
	 */
	@Override
	public User mergeUser(User u) {
		User mergedUser = null;
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		mergedUser = (User) s.merge(u);
		tx.commit();
		s.close();
		return mergedUser;
	}

}
