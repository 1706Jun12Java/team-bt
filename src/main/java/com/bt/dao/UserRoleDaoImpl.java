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

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRole> getUserRoles() {
        List<UserRole> userRoles = new ArrayList<UserRole>();
        Session s = HibernateUtil.getSession();
        userRoles = s.createQuery("from UserRole").list();
        return userRoles;
    }

    @Override
    public UserRole getUserRoleById(int id) {
        // TODO Auto-generated method stub
        return null;
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
