package com.example.a365mc_inno1.facecheckgame.model;

/**
 * Created by 365mc_inno1 on 2018-03-28.
 */

public class User {

    String nickname;
    String point;
    String time;

    public User(String nickname, String point, String time) {
        this.nickname = nickname;
        this.point = point;
        this.time = time;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
