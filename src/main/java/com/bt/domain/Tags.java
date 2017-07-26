package com.bt.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="BT_TAGS")
public class Tags implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3802184057982526144L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tagSeq")
    @SequenceGenerator(allocationSize = 1, name = "tagSeq", sequenceName = "BT_TAG_SEQ")
    @Column(name = "TAG_ID")
    private int id;

    @Column(name = "TAG")
    private String tag;


    @Override
    public String toString() {
        return "Tags [id=" + id + ", tag=" + tag + "]";
    }


    public Tags(String tag) {
        super();
        this.tag = tag;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTag() {
        return tag;
    }


    public void setTag(String tag) {
        this.tag = tag;
    }


    public Tags() {
        // TODO Auto-generated constructor stub
    }

    @OneToMany(mappedBy="tag",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<ImageTags> members;
    public List<ImageTags> getPostsByThisTag() {
        return members;
    }
}
