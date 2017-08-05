package com.bt.controllers;

import com.bt.dao.UserDao;
import com.bt.dao.UserDaoImpl;
import com.bt.domain.User;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public User loginUser(@RequestBody String user, HttpSession session){
        Gson gson = new Gson();

        User userInfo = gson.fromJson(user, User.class);

        System.out.println(userInfo.toString());
        logger.info(userInfo.toString());


        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = (UserDaoImpl) ac.getBean("userDaoImpl");

        User loggedInUser = userDao.login(userInfo.getEmail(), userInfo.getPassword());
        session.setAttribute("id",loggedInUser.getId());

        //System.out.println("TEST123432453254354354");
        System.out.println(loggedInUser);

        userInfo.setPassword(null);

        return userInfo;
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