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
//        init();
//        testURDao();
    	
    	System.out.println("Test");

    	String db = System.getenv("$(env.DB_URL)");
    	
    	System.out.println(db);
    	String db2 = System.getProperty("${env.DB_URL}");
    	
    	System.out.println(db2);
    	
//    	String testing1 = System.getenv("$(env.DATABASE)");
//    	
//    	System.out.println(testing1);
//    	
//    	String testing2 = System.getenv("$(env.testdatabase)");
//    	
//    	System.out.println(testing1);
    	
    }
    static void init() {

        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();

		/* create transient objects */
        UserRole ur1 = new UserRole("Admin");
        UserRole ur2 = new UserRole("User");

        User u1 = new User("Admin","password","John","Doe","Admin@Somewhere.com",ur1);
        User u2 = new User("User","password","Mary","Sue","User@Somewhere.com",ur2);


        s.persist(ur1);
        s.persist(ur2);
        s.persist(u1);
        s.persist(u2);

        tx.commit();
        s.close();

    }
    static void testURDao(){
        UserRoleDao urDao = new UserRoleDaoImpl();
        for(UserRole ur: urDao.getUserRoles()){
            System.out.println("hello");
            for(User x : ur.getMembers()){
                System.out.println(x.toString());
            }
        }
    }

}
