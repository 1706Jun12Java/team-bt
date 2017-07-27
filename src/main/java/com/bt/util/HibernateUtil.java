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
		Configuration c = new Configuration();

		
    	if (System.getenv("DB_URL") != null){
            		c.setProperty("hibernate.connection.url", System.getenv("DB_URL"))
            		 .setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"))
            		 .setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));           
    	}
    	
		c.configure(filename);
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
        return c.buildSessionFactory(sr);
    }

    public static Session getSession() {
        return sessionFactory("hibernate.cfg.xml").openSession();
    }
}
