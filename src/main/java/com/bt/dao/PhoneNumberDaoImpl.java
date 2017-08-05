package com.bt.dao;

import com.bt.domain.PhoneNumber;
import com.bt.util.HibernateUtil;
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
}
