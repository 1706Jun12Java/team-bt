package com.bt.controllers;

import com.bt.domain.User;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public User loginUser(@RequestBody String user){
        Gson gson = new Gson();

        User userInfo = gson.fromJson(user, User.class);

        System.out.println(userInfo.toString());
        logger.info(userInfo.toString());

        userInfo.setPassword(null);

        return userInfo;
    }

}