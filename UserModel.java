package com.example.demo.usermodel;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userid;
    String username;
    String password;
    String fullname;

    public UserModel(int userid, String username, String password, String fullname) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public UserModel() {

    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}