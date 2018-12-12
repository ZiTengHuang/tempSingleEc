package com.example.ppt.temp_ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;


import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.net.RestClient;
import com.example.ppt.temp_coer.net.api.Constants;
import com.example.ppt.temp_coer.net.callback.IError;
import com.example.ppt.temp_coer.net.callback.IRequest;
import com.example.ppt.temp_coer.net.callback.ISuccess;
import com.example.ppt.temp_ec.R;
import com.example.ppt.temp_ec.R2;
import com.joanzapata.iconify.widget.IconTextView;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;

public class SignInDelegate extends MikeDalegate {


    @BindView(R2.id.edit_sign_in_phone)
    TextInputEditText editSignInPhone;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText editSignInPassword;
    @BindView(R2.id.btn_sign_in)
    AppCompatButton btnSignIn;
    @BindView(R2.id.text_sign_in)
    AppCompatTextView textSignIn;
    @BindView(R2.id.icon_sign_in_wechat)
    IconTextView iconSignInWechat;

    private boolean checkFrom() {
        final String phone = editSignInPhone.getText().toString().trim();
        final String passwrod = editSignInPassword.getText().toString().trim();
        boolean isPass = true;

        if (phone.isEmpty() || phone.length() != 11) {
            editSignInPhone.setError("手机号码错误");
            isPass = false;
        } else {
            editSignInPhone.setError(null);
        }
        if (passwrod.isEmpty() || passwrod.length() < 6) {
            editSignInPassword.setError("填6位数以上密码");
            isPass = false;
        } else {
            editSignInPassword.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }


    @OnClick(R2.id.btn_sign_in)
    public void onClickSignIn() {
        RestClient.builder()
                .url(Constants.LOGIN)
                .params("username", "13049337194")
                .params("userpass", "198541")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Logger.i(response);
                        SignHandler.onSignUp(response);
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(String msg, int code) {

                    }
                })

                .builder()
                .post();
        start(new SignUpDelegate(), SINGLETASK);

    }

    @OnClick(R2.id.text_sign_in)
    public void onClickSignUp() {
        RestClient.builder()
                .url(Constants.LOGIN)
                .params("username", "13049337194")
                .params("userpass", "198541")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Logger.i(response);
                     }
                })
                .error(new IError() {
                    @Override
                    public void onError(String msg, int code) {

                    }
                })

                .loader(getContext())
                .builder()
                .post();

    }

    @OnClick(R2.id.icon_sign_in_wechat)
    public void onClickWechat() {
        Toast.makeText(getContext(), "你妹", Toast.LENGTH_LONG).show();
    }
}
