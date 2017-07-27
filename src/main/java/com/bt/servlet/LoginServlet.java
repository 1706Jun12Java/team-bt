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
		Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
        	pw.println(envName + ": " + env.get(envName));
        }
		pw.println(System.getProperty("dbUrl"));
		pw.println(System.getenv("dbUrl"));
		
		pw.println(System.getProperty("sudoku"));
		pw.println(System.getProperty("sudoku1"));

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("bye");
	}

}
