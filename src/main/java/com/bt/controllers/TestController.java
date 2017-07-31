package com.bt.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bt.dao.UserRoleDao;
import com.bt.dao.UserRoleDaoImpl;
import com.bt.domain.UserRole;

@Controller
public class TestController {
	@RequestMapping(value="*", method=RequestMethod.GET)
	public String test(){
		return "index";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void getInfo(HttpServletRequest req, HttpServletResponse resp){
		
		PrintWriter pw;
		try {
			pw = resp.getWriter();
			resp.setContentType("text/html");
			
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			UserRoleDao urDao = (UserRoleDaoImpl)context.getBean("userRoleDaoImpl");
			for(UserRole ur: urDao.getUserRoles()){
				pw.println(ur.toString());
			}
			
			pw.println("hi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//HttpSession session = req.getSession();

	}
}
