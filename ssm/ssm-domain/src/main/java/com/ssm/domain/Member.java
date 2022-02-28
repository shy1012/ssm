package com.ssm.domain;

import java.io.Serializable;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.domain
 * @date 2021/12/15 20:51
 */
public class Member implements Serializable {
    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
