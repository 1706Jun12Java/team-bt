package com.bt.dao;

import java.util.ArrayList;
import java.util.List;

import com.bt.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bt.domain.ImagePosted;
import com.bt.util.HibernateUtil;
import org.springframework.stereotype.Service;

@Service
public class ImagePostedDaoImpl implements ImagePostedDao {

    @Autowired
    HibernateUtil hs;

    @SuppressWarnings("unchecked")
    @Override
    public List<ImagePosted> getImagesPosted() {
        List<ImagePosted> imagesPosted = new ArrayList<ImagePosted>();
        Session s = hs.getSession();
        imagesPosted = s.createQuery("from ImagePosted").list();
        s.close();
        return imagesPosted;
    }

    @Override
    public ImagePosted getImagePostedById(int id) {
        Session session = null;
        ImagePosted u = null;
        try {
            session = hs.getSession();
            u = (ImagePosted) session.get(ImagePosted.class, id);
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
    public int saveImagePosted(ImagePosted u) {
        Session s = hs.getSession();
        Transaction tx = s.beginTransaction();
        int result = (int) s.save(u);
        tx.commit();
        s.close();
        return result;
    }

    @Override
    public void persistImagePosted(ImagePosted u) {
        Session s = hs.getSession();
        Transaction tx = s.beginTransaction();
        s.persist(u);
        tx.commit();
        s.close();

    }

    @Override
    public boolean updateImagePosted(ImagePosted u) {
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
    public ImagePosted mergeImagePosted(ImagePosted u) {
        ImagePosted mergedImagePosted = null;
        Session s = hs.getSession();
        Transaction tx = s.beginTransaction();
        mergedImagePosted = (ImagePosted) s.merge(u);
        tx.commit();
        s.close();
        return mergedImagePosted;
    }

    public void postImage(String caption, String image, User user){
        Session session = hs.getSession();
        Transaction tx = session.beginTransaction();
        int exe=0;
        try {
            Query q = session.createSQLQuery("INSERT INTO BT_IMAGE (CAPTION,IMAGE,POSTED_BY) VALUES (?,?,?)");
            q.setString(1, caption);
            q.setString(2, image);
            q.setInteger(3, user.getId());
            exe=q.executeUpdate();
            if(exe==1){
                tx.commit();

            }else {
                tx.rollback();
            }
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }


    }
}
