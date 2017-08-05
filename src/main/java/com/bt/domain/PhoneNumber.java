package com.bt.domain;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({ @NamedQuery(name = "findPh", query = "from PhoneNumber where phoneNumber = :phoneNumber") })
@Entity
@Table(name="BT_PHONE_NUMBER")
public class PhoneNumber implements Serializable {

    private static final long serialVersionUID = 1651979149362413867L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phSeq")
    @SequenceGenerator(allocationSize = 1, name = "phSeq", sequenceName = "BT_PH_SEQ")
    @Column(name = "PH_ID")
    private int id;

    @Column(name="PHONE_NUMBER", unique=true)
    private String phoneNumber;

    @OneToOne(fetch=FetchType.LAZY)
    private User user;


    public PhoneNumber(String phoneNumber, User user) {
        this.phoneNumber = phoneNumber;
        this.user = user;
    }
    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public PhoneNumber() {
        super();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}