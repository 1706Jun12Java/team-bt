	package com.bt.util;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory(String filename) {
    	
    	
        Configuration c = new Configuration()
//        		.setProperty("hibernate.connection.username", "ear")
//        		.setProperty("hibernate.connection.password", "ear")
//        		.setProperty("hibernate.connection.url", "ear")
        		.configure(filename);
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
        return c.buildSessionFactory(sr);
    }

    public static Session getSession() {
        return sessionFactory("hibernate.cfg.xml").openSession();
    }
}
