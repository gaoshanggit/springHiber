package com.gs.app.hiber.api.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2017/8/2.22:54..
 */
@Table(name="t_user")
@Entity
public class User implements Serializable {


    private String userId;

    private String userName;

    private String password;

    private String lastIp;

    private String credits;

    private Date lastVisit;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = true, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Column(name = "user_name", nullable = false, length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "last_ip", nullable = false, length = 30)
    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Column(name = "credits", nullable = false, length = 32)
    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    @Column(name = "last_visit", nullable = false, length = 30)
    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }
}
