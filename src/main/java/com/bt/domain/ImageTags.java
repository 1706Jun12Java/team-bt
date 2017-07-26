package com.bt.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="BT_IMG_TAGS")
public class ImageTags  implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6368665660937470701L;

    @EmbeddedId
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="TAG_ID", foreignKey = @ForeignKey(name = "FK_TAG"))
    private Tags tag;

    @EmbeddedId
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IMAGE_ID", foreignKey = @ForeignKey(name = "FK_IMG"))
    private ImagePosted post;

    public ImageTags() {
        // TODO Auto-generated constructor stub
    }

    public Tags getTag() {
        return tag;
    }

    public void setTag(Tags tag) {
        this.tag = tag;
    }

    public ImagePosted getPost() {
        return post;
    }

    public void setPost(ImagePosted post) {
        this.post = post;
    }

    public ImageTags(Tags tag, ImagePosted post) {
        super();
        this.tag = tag;
        this.post = post;
    }

    @Override
    public String toString() {
        return "ImageTags [tag=" + tag + ", post=" + post + "]";
    }


}
