package com.bt.controllers;

import com.bt.dao.*;
import com.bt.domain.*;
import com.google.gson.Gson;
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
import java.util.ArrayList;
import java.util.List;


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

    @ResponseBody
    @RequestMapping(value="/getAllImages",method=RequestMethod.GET)
    public List<ImageBuffer> getAllImages(HttpServletRequest req, HttpServletResponse res){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        ImagePostedDao iDao = (ImagePostedDaoImpl) ac.getBean("imagePostedDaoImpl");
        List<ImagePosted> lst = iDao.getImagesPosted();
//        String json = new Gson().toJson(lst);
//        System.out.println("");
//        System.out.println(json);
//        System.out.println("");

        List<ImageBuffer> newList = new ArrayList<>();
        for(ImagePosted ip: lst){
            ImageBuffer image = new ImageBuffer(ip.getId(),ip.getCaption(), ip.getImage(), ip.getPoster().getEmail());
            System.out.println(image.toString());
            newList.add(image);
        }

        return newList;
    }

    @ResponseBody
    @RequestMapping(value="/image/{id}",method=RequestMethod.GET)
    public ImageBuffer getImage(@PathVariable int id){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        ImagePostedDao iDao = (ImagePostedDaoImpl) ac.getBean("imagePostedDaoImpl");
        ImagePosted ip = iDao.getImagePostedById(id);
        ImageBuffer image = new ImageBuffer(ip.getId(),ip.getCaption(), ip.getImage(), ip.getPoster().getEmail());
        return image;
    }

    @ResponseBody
    @RequestMapping(value="/getProfile",method=RequestMethod.GET)
    public UserBuffer getProfile(HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession();
        UserBuffer user = null;
        user = new UserBuffer((User) session.getAttribute("user"));
        System.out.println(user);
        return user;


    }

}