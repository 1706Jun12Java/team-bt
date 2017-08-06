package com.bt.domain;

import java.io.Serializable;

public class ImageBuffer implements Serializable {

    private static final long serialVersionUID = 5234812754702650921L;

    private int id;
    private String caption;
    private String image;
    private int poster;

    public ImageBuffer(ImagePosted ip){
        this.id=ip.getId();
        this.caption=ip.getCaption();
        this.image=ip.getImage();
        this.poster=ip.getPoster().getId();
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

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
