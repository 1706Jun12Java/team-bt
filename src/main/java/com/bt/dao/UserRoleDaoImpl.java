package com.bt.dao;

import com.bt.domain.UserRole;
import com.bt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserRoleDaoImpl implements UserRoleDao {

    public UserRoleDaoImpl() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see com.bt.dao.UserRoleDao#getUserRoles()
     * this function returns all UserRole entries in the database
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<UserRole> getUserRoles() {
        List<UserRole> userRoles = new ArrayList<UserRole>();
        Session s = HibernateUtil.getSession();
        userRoles = s.createQuery("from UserRole").list();
        return userRoles;
    }

    /*
     * (non-Javadoc)
     * @see com.bt.dao.UserRoleDao#getUserRoleById(int)
     * Gets a UserRole by id
     * If that id does not exist this function returns null
     */
    @Override
    public UserRole getUserRoleById(int id) {
    	Session session = null;
        UserRole ur = null;
        try {
            session = HibernateUtil.getSession();
            ur =  (UserRole)session.get(UserRole.class,id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ur;
    }

    @Override
    public int saveUserRole(UserRole u) {
    	Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(u);
		tx.commit();
		s.close();
		return result;
    }

    @Override
    public void persistUserRole(UserRole u) {
    	Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(u);
		tx.commit();
		s.close();
    }

    @Override
    public void updateUserRole(UserRole u, String userRole) {
    	Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
			u.setUserRole(userRole);
			s.saveOrUpdate(u);
		tx.commit();
		s.close();
    }

    @Override
    public UserRole mergeUserRole(UserRole u, String userRole) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		u.setUserRole(userRole);
		UserRole u2 = (UserRole) s.merge(u);
		tx.commit();
		s.close();
		return u2;
    }

}
