package com.bt.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class HibernateUtil {

    private static SessionFactory sessionFactory = setSessionFactory();
    private static Session session;

    public Session getSession() {
        session = sessionFactory.openSession();
        return session;
    }
    public void closeSession(){
        if(session.isOpen())
            session.close();
    }
    private static SessionFactory sessionFactory(String filename) {

        Configuration c = new Configuration();

        ClassLoader classLoader = null;
        InputStream input = null;
        try {

            classLoader = Thread.currentThread().getContextClassLoader();
            input = classLoader.getResourceAsStream("env.properties");
            Properties prop = new Properties();
            prop.load(input);

            // load a properties file
            prop.load(input);
            c.setProperty("hibernate.connection.url", prop.getProperty("dbUrl"))
                    .setProperty("hibernate.connection.username", prop.getProperty("dbUsername"))
                    .setProperty("hibernate.connection.password", prop.getProperty("dbPassword"))
                    .configure(filename);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
        return c.buildSessionFactory(sr);
    }

    public static SessionFactory setSessionFactory() {
        return sessionFactory("hibernate.cfg.xml");
    }
}
