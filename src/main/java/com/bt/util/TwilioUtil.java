package com.bt.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class TwilioUtil {
    public static String ACCOUNT_SID;
    public static String AUTH_TOKEN;
    public static String TWILIO_NUMBER;

    TwilioUtil(){
        ClassLoader classLoader = null;
        InputStream input = null;
        try {

            classLoader = Thread.currentThread().getContextClassLoader();
            input = classLoader.getResourceAsStream("env.properties");
            Properties prop = new Properties();
            prop.load(input);

            // load a properties file
            prop.load(input);
            this.ACCOUNT_SID = prop.getProperty("ACCOUNT_SID");
            this.AUTH_TOKEN = prop.getProperty("AUTH_TOKEN");
            this.TWILIO_NUMBER = prop.getProperty("TWILIO_NUMBER");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getAccountSid() {
        return ACCOUNT_SID;
    }

    public static String getAuthToken() {
        return AUTH_TOKEN;
    }

    public static String getTwilioNumber() {
        return TWILIO_NUMBER;
    }
}
