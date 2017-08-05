package com.bt.controllers;

import com.bt.domain.User;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public User loginUser(HttpServletRequest req, HttpServletResponse res, @RequestBody String user){
        Gson gson = new Gson();

        User userInfo = gson.fromJson(user, User.class);

        System.out.println(userInfo.toString());
        logger.info(userInfo.toString());

        userInfo.setPassword(null);
        HttpSession session = req.getSession();

        session.setAttribute("user", userInfo);

        return userInfo;
    }

}
