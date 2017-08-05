package com.bt.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.bt.dao.*;
import com.bt.domain.*;

@Controller
public class IndexController {
    @RequestMapping(value="*", method= RequestMethod.GET)
    public String test(){
        return "static/index.html";
    }
}
