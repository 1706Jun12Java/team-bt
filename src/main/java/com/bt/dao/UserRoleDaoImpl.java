package com.bt.dao;

import com.bt.domain.UserRole;
import com.bt.util.HibernateUtil;
import org.hibernate.Session;

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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void persistUserRole(UserRole u) {
        // TODO Auto-generated method stub

    }

    @Override
    public UserRole updateUserRole(UserRole u, String newName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserRole mergeUserRole(UserRole u, String newName) {
        // TODO Auto-generated method stub
        return null;
    }

}
