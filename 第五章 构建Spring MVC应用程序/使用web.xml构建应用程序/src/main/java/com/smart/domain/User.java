package com.smart.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class User implements Serializable {

    private Long userId;
    private String userName;
    private Long credits;
    private String password;
    private Timestamp lastVisit;
    private String lastIp;

    public User(){

    }

    public User(Long userId, String userName, Long credits, String password, Timestamp lastVisit, String lastIp) {
        this.userId = userId;
        this.userName = userName;
        this.credits = credits;
        this.password = password;
        this.lastVisit = lastVisit;
        this.lastIp = lastIp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Timestamp lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(credits, user.credits) &&
                Objects.equals(password, user.password) &&
                Objects.equals(lastVisit, user.lastVisit) &&
                Objects.equals(lastIp, user.lastIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, credits, password, lastVisit, lastIp);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", credits=" + credits +
                ", password='" + password + '\'' +
                ", lastVisit=" + lastVisit +
                ", lastIp='" + lastIp + '\'' +
                '}';
    }
}
