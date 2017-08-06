package com.bt.controllers;

import com.bt.dao.*;
import com.bt.domain.ImagePosted;
import com.bt.domain.PhoneNumber;
import com.bt.domain.User;
import com.bt.domain.UserRole;
import com.google.gson.Gson;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.StringReader;
import java.sql.Clob;


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
    public ResponseEntity registerUser(HttpServletRequest req, HttpServletResponse res, @RequestBody String user){
        Gson gson = new Gson();

        User userInfo = gson.fromJson(user, User.class);
        System.out.println(userInfo.toString());
        logger.info(userInfo.toString());

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = (UserDaoImpl) ac.getBean("userDaoImpl");
        UserRoleDao urDao = (UserRoleDaoImpl) ac.getBean("userRoleDaoImpl");

        UserRole ur = urDao.getUserRoleById(2);
        userInfo.setUserRole(ur);
        userDao.persistUser(userInfo);

        HttpSession session = req.getSession();

        session.setAttribute("user", userInfo);
        System.out.print(userInfo);

        //userInfo.setPassword(null);

        return new ResponseEntity(gson.toJson(userInfo.getEmail()), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value="/postImage",method=RequestMethod.POST)
    public ResponseEntity postImage(HttpServletRequest req, HttpServletResponse res, @RequestBody String postImage){
        Gson gson = new Gson();

//
        ImagePosted newImage = gson.fromJson(postImage, ImagePosted.class);

        System.out.println(newImage.toString());
//        ImagePosted newImage = new ImagePosted();
//        newImage.setCaption(caption);
//
        logger.info(newImage.toString());

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null) {
            newImage.setPoster(user);
            ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
            ImagePostedDao iDao = (ImagePostedDaoImpl) ac.getBean("imagePostedDaoImpl");

            iDao.persistImagePosted(newImage);
            return new ResponseEntity(gson.toJson(user.getEmail()), HttpStatus.OK);
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public void logout(HttpServletRequest req, HttpServletResponse res){

        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            Cookie UIDCookie = new Cookie("JSESSIONID", "");
            UIDCookie.setMaxAge(0);
            UIDCookie.setPath("/");
            res.addCookie(UIDCookie);
        }
    }
}