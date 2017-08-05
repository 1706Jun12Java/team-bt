package com.bt.controllers;

import com.bt.util.TwilioUtil;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@RestController
public class TwilioController {

    @Autowired
    TwilioUtil twilioUtil;

    @RequestMapping(value="/twilio/message",method= RequestMethod.POST)
    public void getSMS(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Twilio.init(twilioUtil.getAccountSid(),twilioUtil.getAuthToken());

        String fromNumber = req.getParameter("From");

        System.out.println(req.getParameter("MediaUrl0"));

        System.out.println(fromNumber);

    }

}
