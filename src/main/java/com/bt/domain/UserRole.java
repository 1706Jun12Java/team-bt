package com.bt.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="BT_USER_ROLE")
public class UserRole implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8994793897344799532L;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urSeq")
    @SequenceGenerator(allocationSize = 1, name = "urSeq", sequenceName = "BT_UR_SEQ")
    @Column(name="UR_ID")
    private int id;


    @Column(name = "USER_ROLE")
    protected String userRole;
    public UserRole() {
        // TODO Auto-generated constructor stub
    }
    public UserRole(String userRole) {
        super();
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserRole [id=" + id + ", userRole=" + userRole + "]";
    }

    @OneToMany(mappedBy="role",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<User> members;
    public List<User> getUsersOfThisType() {
        return members;
    }
}
