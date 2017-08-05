package com.bt.controllers;

import com.bt.domain.User;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ResponseEntity loginUser(@RequestBody String user){
        Gson gson = new Gson();

        User userInfo = gson.fromJson(user, User.class);

        System.out.println(userInfo.toString());
        logger.info(userInfo.toString());

        userInfo.setPassword(null);

        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public ResponseEntity registerUser(@RequestBody String user){
        Gson gson = new Gson();
        User userInfo = gson.fromJson(user, User.class);



        userInfo.setPassword(null);

        return new ResponseEntity(HttpStatus.OK);
    }

}
