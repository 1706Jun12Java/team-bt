package com.bt.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ImageBuffer implements Serializable {

    private static final long serialVersionUID = 5234812754702650921L;

    private int id;
    private String caption;
    private String image;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ImageBuffer{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public ImageBuffer(int id, String caption, String image, String email) {

        this.id = id;
        this.caption = caption;
        this.image = image;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
