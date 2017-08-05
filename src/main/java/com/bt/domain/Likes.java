package com.bt.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="BT_LIKES")
public class Likes implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3511070288475924970L;

    @EmbeddedId
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="USER_ID", foreignKey = @ForeignKey(name = "FK_LIKED_BY"))
    private User likedBy;

    @EmbeddedId
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IMAGE_ID", foreignKey = @ForeignKey(name = "FK_IMG_LIKED"))
    private ImagePosted post;


    @Override
    public String toString() {
        return "Likes [likedBy=" + likedBy + ", post=" + post + "]";
    }


    public Likes(User likedBy, ImagePosted post) {
        super();
        this.likedBy = likedBy;
        this.post = post;
    }


    public User getPoster() {
        return likedBy;
    }


    public void setPoster(User likedBy) {
        this.likedBy = likedBy;
    }

    public ImagePosted getPost() {
        return post;
    }


    public void setPost(ImagePosted post) {
        this.post = post;
    }


    public Likes() {
        // TODO Auto-generated constructor stub
    }

}
