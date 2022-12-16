package com.zookepers.zookeepers.controller;

public class LoginForm {
    private String member_id;

    private String member_password;

    public String getMember_id() {
        return this.member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_password() {
        return this.member_password;
    }

    public void setMember_password(String member_password) {
        this.member_password = member_password;
    }
}
