package com.mx.BookSystem.bean;

public class User {

    private String userId;
    private String password;
    private String identity;
    private int bookNum;

    public User() {
    }

    public User(String userId, String password, String identity, int bookNum) {
        this.userId = userId;
        this.password = password;
        this.identity = identity;
        this.bookNum = bookNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                ", bookNum=" + bookNum +
                '}';
    }
}
