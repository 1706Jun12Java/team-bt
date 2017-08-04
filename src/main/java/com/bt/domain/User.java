package com.bt.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@NamedQueries({ @NamedQuery(name = "findUser", query = "from User where username = :username and password= :password") })

@Entity
@Table(name="BT_USER")
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3187453597160217592L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @SequenceGenerator(allocationSize = 1, name = "userSeq", sequenceName = "BT_USER_SEQ")
    @Column(name = "USER_ID")
    private int id;

    @Column(name="USERNAME", unique = true)
    private String username;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="FNAME")
    private String fName;

    @Column(name="LNAME")
    private String lName;

    @Column(name="EMAIL", unique = true)
    private String email;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="USER_ROLE", foreignKey = @ForeignKey(name = "FK_BT_USER_ROLES"))
    private UserRole role;





    public User() {
        // TODO Auto-generated constructor stub
    }
    public User(String username, String password, String fName, String lName, String email) {
        super();
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    public User(String username, String password, String fName, String lName, String email, UserRole userRole) {
        super();
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.role = userRole;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public UserRole getUserRole() {
        return role;
    }


    public void setUserRole(UserRole userRole) {
        this.role = userRole;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", fName=" + fName + ", lName="
                + lName + ", email=" + email + ", userRole=" + role + "]";
    }

    @OneToMany(mappedBy="poster",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<ImagePosted> images;
    public List<ImagePosted> getMyImages() {
        return images;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    List<ImagePosted> likes;

    public List<ImagePosted> getLikedImages() {
        return likes;
    }

    public void setLikedImages(List<ImagePosted> likes) {
        this.likes = likes;
    }

    public void likeImage(ImagePosted b) {
        likes.add(b);
    }

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="PH_ID")
    private PhoneNumber phoneNumber;

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

