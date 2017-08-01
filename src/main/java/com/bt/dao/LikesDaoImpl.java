package com.bt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bt.domain.Likes;
import com.bt.util.HibernateUtil;

@Component(value = "likesDaoImpl")
public class LikesDaoImpl implements LikesDao {
	@Autowired
	HibernateUtil hs;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Likes> getLikes() {
		List<Likes> likes = new ArrayList<Likes>();
		Session s = hs.getSession();
		likes = s.createQuery("from Likes").list();
		s.close();
		return likes;
	}

	@Override
	public Likes getLikesById(int id) {
		Session session = null;
		Likes u = null;
		try {
			session = hs.getSession();
			u = (Likes) session.get(Likes.class, id);
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
	public int saveLikes(Likes u) {
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(u);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void persistLikes(Likes u) {
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(u);
		tx.commit();
		s.close();

	}

	@Override
	public boolean updateLikes(Likes u) {
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

	@Override
	public Likes mergeLikes(Likes u) {
		Likes mergedLikes = null;
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		mergedLikes = (Likes) s.merge(u);
		tx.commit();
		s.close();
		return mergedLikes;
	}

}
