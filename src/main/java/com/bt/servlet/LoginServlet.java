package com.bt.servlet;

import java.applet.Applet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bt.dao.UserRoleDao;
import com.bt.dao.UserRoleDaoImpl;
import com.bt.domain.User;
import com.bt.domain.UserRole;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1081953284788755461L;
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		/*
		try {
			resp.sendRedirect("index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		PrintWriter pw = resp.getWriter();
//		//HttpSession session = req.getSession();
//		resp.setContentType("text/html");
//		UserRoleDao urDao = new UserRoleDaoImpl();
//		for(UserRole ur: urDao.getUserRoles()){
//			pw.println(ur.toString());
//		}
//		Map<String, String> env = System.getenv();
//        for (String envName : env.keySet()) {
//        	pw.println(envName + ": " + env.get(envName));
//        }
//        
//        Properties p = System.getProperties();
//        Enumeration keys = p.keys();
//        while (keys.hasMoreElements()) {
//            String key = (String)keys.nextElement();
//            String value = (String)p.get(key);
//            pw.println(key + ": " + value);
//        }
		pw.println(System.getProperty("dbUrl"));
		pw.println(System.getenv("dbUrl"));
		
		pw.println(System.getProperty("sudoku"));
		pw.println(System.getProperty("sudoku1"));

		ClassLoader classLoader = null;
		InputStream input = null;
		try {

			classLoader = Thread.currentThread().getContextClassLoader();
			input = classLoader.getResourceAsStream("env.properties");
			Properties prop = new Properties();
			prop.load(input);

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			pw.println(prop.getProperty("dbUrl"));
			pw.println(prop.getProperty("dbUsername"));
			pw.println(prop.getProperty("dbPassword"));

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
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("bye");
	}

}
