package com.bt.dao;

import com.bt.domain.ImagePosted;
import com.bt.domain.PhoneNumber;
import com.bt.domain.User;
import com.bt.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneNumberDaoImpl implements PhoneNumberDao{
    @Autowired
    HibernateUtil hs;
    @Override
    public List<PhoneNumber> getPhoneNumbers() {
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        Session s = hs.getSession();
        phoneNumbers = s.createQuery("from PhoneNumber").list();
        s.close();
        return phoneNumbers;
    }

    @Override
    public PhoneNumber getPhoneNumberById(int id) {
        Session session = null;
        PhoneNumber u = null;
        try {
            session = hs.getSession();
            u = (PhoneNumber) session.get(PhoneNumber.class, id);
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
    public int savePhoneNumber(PhoneNumber u) {
        Session s = hs.getSession();
        Transaction tx = s.beginTransaction();
        int result = (int) s.save(u);
        tx.commit();
        s.close();
        return result;
    }

    @Override
    public void persistPhoneNumber(PhoneNumber u) {
        Session s = hs.getSession();
        Transaction tx = s.beginTransaction();
        s.persist(u);
        tx.commit();
        s.close();

    }

    @Override
    public boolean updatePhoneNumber(PhoneNumber u) {
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
    public PhoneNumber mergePhoneNumber(PhoneNumber u) {
        PhoneNumber mergedPhoneNumber = null;
        Session s = hs.getSession();
        Transaction tx = s.beginTransaction();
        mergedPhoneNumber = (PhoneNumber) s.merge(u);
        tx.commit();
        s.close();
        return mergedPhoneNumber;
    }

    @Override
    public PhoneNumber findPhoneNumberByNumber(String ph) {
        Session s = hs.getSession();
        Query q = s.getNamedQuery("findPh");
        q.setString("phoneNumber", ph);
        List<PhoneNumber> phs=q.list();
        if(phs.size()>0){
            return phs.get(0);
        }
        else{
            return null;
        }
    }

    @Override
    public void postImageFromNumber(String phoneNumber, String base64){
        Session s = hs.getSession();
        Query q = s.getNamedQuery("findPh");
        q.setString("phoneNumber", phoneNumber);
        List<PhoneNumber> phs=q.list();
        if(phs.size()>0) {
            Transaction tx = s.beginTransaction();
            PhoneNumber pn = phs.get(0);
            User user = pn.getUser();
            ImagePosted img = new ImagePosted();
            img.setCaption("Posted from Twilio");
            img.setImage(base64);
            img.setPoster(user);
            s.persist(img);
            tx.commit();
        }
        s.close();
    }
}
