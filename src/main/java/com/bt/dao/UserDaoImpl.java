package com.bt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	 * com.bt.domain.User) 
	 * This function save or updates the user
	 * if it happens return true
	 * if it fails return false
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
	 * This function merges the user
	 * if it happens return true
	 * if it fails return false
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
	
	@SuppressWarnings("unchecked")
	@Override
    public User login(String username, String password){
		Session s = hs.getSession();
		Query q = s.getNamedQuery("findUser");
		q.setString("username", username);
		q.setString("password", password);
		List<User> users=q.list();
		if(users.size()>0){
			return users.get(0);
		}
		else{
			return null;
		}
    }

}
