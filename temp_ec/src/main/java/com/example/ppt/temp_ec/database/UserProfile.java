package com.example.ppt.temp_ec.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity(nameInDb = "user_profile")
public class UserProfile {
//    这里弄个主键必须是long类型
    @Id
    private long userId = 0;
    private String user_name= null;
    private String token= null;
    @Generated(hash = 460423283)
    public UserProfile(long userId, String user_name, String token) {
        this.userId = userId;
        this.user_name = user_name;
        this.token = token;
    }
    @Generated(hash = 968487393)
    public UserProfile() {
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getUser_name() {
        return this.user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }

}
