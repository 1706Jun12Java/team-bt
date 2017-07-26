package com.bt.main;

import com.bt.dao.UserRoleDao;
import com.bt.dao.UserRoleDaoImpl;
import com.bt.domain.User;
import com.bt.domain.UserRole;
import com.bt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Driver {

	public static void main(String[] args){
		System.out.println("begining of test");
		//init();
		testURDao();
		System.out.println("end of test");
		
	}
	static void init() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
        try {
			UserRole ur1 = new UserRole("Admin");
			UserRole ur2 = new UserRole("User");
			
			User u1 = new User("Admin","password","John","Doe","Admin@Somewhere.com",ur1);
			User u2 = new User("User","password","Mary","Sue","User@Somewhere.com",ur2);
			
			s.persist(ur1);
			s.persist(ur2);
			s.persist(u1);
			s.persist(u2);
			/*
			System.out.println(s.save(ur1));
			System.out.println(s.save(ur2));
			System.out.println(s.save(u1));
			System.out.println(s.save(u2));
			*/
			tx.commit();
			s.close();
		} 
        catch (Exception e) {
        	tx.rollback();
            s.close();
        }

	}
	static void testURDao(){
		UserRoleDao urDao = new UserRoleDaoImpl();
		for(UserRole ur: urDao.getUserRoles()){
			System.out.println("USERROLE");
			System.out.println(ur.toString());
			for(User x : ur.getUsersOfThisType()){
				System.out.println("USER");
				System.out.println(x.toString());
			}
		}
	}

}
