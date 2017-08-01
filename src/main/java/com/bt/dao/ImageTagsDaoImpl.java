package com.bt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bt.domain.ImageTags;
import com.bt.util.HibernateUtil;

@Component(value = "imageTagsDao")
public class ImageTagsDaoImpl implements ImageTagsDao {
	@Autowired
	HibernateUtil hs;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ImageTags> getImageTags() {
		List<ImageTags> imageTags = new ArrayList<ImageTags>();
		Session s = hs.getSession();
		imageTags = s.createQuery("from ImageTags").list();
		s.close();
		return imageTags;
	}

	@Override
	public ImageTags getImageTagsById(int id) {
		Session session = null;
		ImageTags u = null;
		try {
			session = hs.getSession();
			u = (ImageTags) session.get(ImageTags.class, id);
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
	public int saveImageTags(ImageTags u) {
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(u);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void persistImageTags(ImageTags u) {
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(u);
		tx.commit();
		s.close();

	}

	@Override
	public boolean updateImageTags(ImageTags u) {
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
	public ImageTags mergeImageTags(ImageTags u) {
		ImageTags mergedImageTags = null;
		Session s = hs.getSession();
		Transaction tx = s.beginTransaction();
		mergedImageTags = (ImageTags) s.merge(u);
		tx.commit();
		s.close();
		return mergedImageTags;
	}

}
