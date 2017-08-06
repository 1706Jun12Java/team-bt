package com.bt.domain;

import java.io.Serializable;

public class UserBuffer implements Serializable {
    private static final long serialVersionUID = 6250468474697150922L;
    private int id;
    private String email;
    private String fName;

    private String lName;

    private String phoneNumber;

    public UserBuffer(User user){
        this.id=user.getId();
        this.email=user.getEmail();
        this.fName=user.getfName();
        this.lName=user.getlName();
        if(user.getPhoneNumber()!=null){
            this.phoneNumber=user.getPhoneNumber().getPhoneNumber();

        }
        else
            this.phoneNumber="No phone number";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
