package com.bt.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.util.List;

@Entity
@Table(name="BT_IMAGE")
public class ImagePosted implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -2110008288500681615L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imgSeq")
    @SequenceGenerator(allocationSize = 1, name = "imgSeq", sequenceName = "BT_USER_SEQ")
    @Column(name = "IMG_ID")
    private int id;

    @Column(name="CAPTION")
    private String caption;

    @Lob
    @Column(name="IMAGE")
    private Clob image;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="POSTED_BY", foreignKey = @ForeignKey(name = "FK_POSTED_BY"))
    private User poster;


    public ImagePosted() {
        // TODO Auto-generated constructor stub
    }


    public ImagePosted(String caption, Clob image, User poster) {
        super();
        this.caption = caption;
        this.image = image;
        this.poster = poster;
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


    public Clob getImage() {
        return image;
    }


    public void setImage(Clob image) {
        this.image = image;
    }


    public User getPoster() {
        return poster;
    }


    public void setPoster(User poster) {
        this.poster = poster;
    }


    @Override
    public String toString() {
        return "ImagePosted [id=" + id + ", caption=" + caption + ", image=" + image + ", poster=" + poster + "]";
    }

    @ManyToMany(cascade=CascadeType.ALL,mappedBy="images")
    List<Tags> tags;

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public void addTag(Tags b) {
        tags.add(b);
    }

    @ManyToMany(cascade=CascadeType.ALL,mappedBy="likes")
    List<User> likedBy;

    public List<User> getUsersWhoLikedPost() {
        return likedBy;
    }

    public void setUsersWhoLikedPost(List<User> likedBy) {
        this.likedBy = likedBy;
    }

    public void addLikedByThisUser(User b) {
        likedBy.add(b);
    }

}
