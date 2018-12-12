package com.example.ppt.temp_ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.ppt.temp_ec.database.UserProfile;

public class SignHandler {

    public static void onSignUp(String user) {

        final JSONObject userJson = JSON.parseObject(user);
        final JSONObject data = userJson.getJSONObject("data");
        final String token = userJson.getString("token");
        final Long userId = data.getLong("user_id");
        final String userName = data.getString("user_name");
        final UserProfile profile = new UserProfile(userId, userName, token);
    }

}
