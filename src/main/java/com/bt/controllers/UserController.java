package com.bt.controllers;

import com.bt.dao.UserDao;
import com.bt.dao.UserDaoImpl;
import com.bt.domain.User;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ResponseEntity loginUser(HttpServletRequest req, HttpServletResponse res, @RequestBody String user){

        Gson gson = new Gson();

        User userInfo = gson.fromJson(user, User.class);

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = (UserDaoImpl) ac.getBean("userDaoImpl");

        User loggedInUser = userDao.login(userInfo.getEmail(), userInfo.getPassword());

        System.out.println(loggedInUser);

        loggedInUser.setPassword(null);

        HttpSession session = req.getSession();

        session.setAttribute("user", loggedInUser);

        return new ResponseEntity(gson.toJson(userInfo.getEmail()), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public User registerUser(@RequestBody String user){
        Gson gson = new Gson();

        User userInfo = gson.fromJson(user, User.class);

        System.out.println(userInfo.toString());
        logger.info(userInfo.toString());

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = (UserDaoImpl) ac.getBean("userDaoImpl");

        User registerUser=null;


        //userInfo.setPassword(null);

        return registerUser;
    }
}