package com.bt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bt.domain.Tags;
import com.bt.util.HibernateUtil;

@Component(value = "tagsDaoImpl")
public class TagsDaoImpl implements TagsDao {
	@Autowired
	HibernateUtil hs;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tags> getTags() {
		List<Tags> tags = new ArrayList<Tags>();
		Session s = hs.getSession();
		tags = s.createQuery("from Tags").list();
		s.close();
		return tags;
	}

	@Override
	public Tags getTagsById(int id) {
		Session session = null;
		Tags u = null;
		try {
			session = hs.getSession();
			u = (Tags) session.get(Tags.class, id);
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
	public int saveTags(Tags u) {
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(u);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void persistTags(Tags u) {
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(u);
		tx.commit();
		s.close();

	}

	@Override
	public boolean updateTags(Tags u) {
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
	public Tags mergeTags(Tags u) {
		Tags mergedTags = null;
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		mergedTags = (Tags) s.merge(u);
		tx.commit();
		s.close();
		return mergedTags;
	}

}
