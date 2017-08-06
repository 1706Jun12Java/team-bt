package com.bt.controllers;

import com.bt.domain.User;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
public class TestSession {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value="/testSession")
    public void testSession(HttpSession session){
        session.setAttribute("test1","value");
    }

    @ResponseBody
    @RequestMapping(value="/testSession2")
    public void testSession2(HttpSession session){
        String val = (String) session.getAttribute("test1");
        System.out.println("SESSION VALUE HERE");
        System.out.println(val);
    }

}