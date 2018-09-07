package com.qcj.entiry;

public class UserInfo {
    private int uid;
    private String uname;
    private String password;

    public UserInfo() {
    }

    public UserInfo(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

    public UserInfo(int uid, String uname, String password) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
