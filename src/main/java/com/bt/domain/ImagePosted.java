package com.bt.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
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

    @Column(name="IMAGE")
    private Blob image;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="POSTED_BY", foreignKey = @ForeignKey(name = "FK_POSTED_BY"))
    private User poster;


    public ImagePosted() {
        // TODO Auto-generated constructor stub
    }


    public ImagePosted(String caption, Blob image, User poster) {
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


    public Blob getImage() {
        return image;
    }


    public void setImage(Blob image) {
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

    @OneToMany(mappedBy="post",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Likes> members;
    public List<Likes> getPostLikes() {
        return members;
    }

    @OneToMany(mappedBy="post",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<ImageTags> tags;
    public List<ImageTags> getTags() {
        return tags;
    }
}
