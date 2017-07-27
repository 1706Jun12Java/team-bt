package com.bt.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

    private static SessionFactory sessionFactory(String filename) {
    	
    	
    	
		Configuration c = new Configuration().setProperty("hibernate.connection.url", System.getProperty("DB_URL"))
            		 .setProperty("hibernate.connection.username", System.getProperty("DB_USERNAME"))
            		 .setProperty("hibernate.connection.password", System.getProperty("DB_PASSWORD"))
            		 .configure(filename);  
		
   		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
        return c.buildSessionFactory(sr);
    }

    public static Session getSession() {
        return sessionFactory("hibernate.cfg.xml").openSession();
    }
}
