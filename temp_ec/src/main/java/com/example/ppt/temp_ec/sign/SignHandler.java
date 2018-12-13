package com.example.ppt.temp_ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.ppt.temp_coer.app.AccountManager;
import com.example.ppt.temp_coer.utils.toast.ToastCreator;
import com.example.ppt.temp_ec.database.DataBaseManager;
import com.example.ppt.temp_ec.database.UserProfile;

public class SignHandler {

    public static void onSignIn(String user, ISignListener iSignListener) {
        final JSONObject userJson = JSON.parseObject(user);
        final JSONObject data = userJson.getJSONObject("data");
        final String token = userJson.getString("token");
        final Long userId = data.getLong("user_id");
        final String userName = data.getString("user_name");
        final UserProfile profile = new UserProfile(userId, userName, token);
        DataBaseManager.getInstance().getDao().getKey(profile);
        //设置数据已经保存好，并且成功储存
        AccountManager.setSignStater(true);
        iSignListener.onSignInSuccess();
    }


    public static void onSignUp(String user, ISignListener iSignListener) {
        final JSONObject userJson = JSON.parseObject(user);
        final JSONObject data = userJson.getJSONObject("data");
        final String token = userJson.getString("token");
        final Long userId = data.getLong("user_id");
        final String userName = data.getString("user_name");
        final UserProfile profile = new UserProfile(userId, userName, token);
        DataBaseManager.getInstance().getDao().getKey(profile);

        //设置数据已经保存好，并且成功储存
        AccountManager.setSignStater(true);
        iSignListener.onSignUpSuccess();
    }
}
