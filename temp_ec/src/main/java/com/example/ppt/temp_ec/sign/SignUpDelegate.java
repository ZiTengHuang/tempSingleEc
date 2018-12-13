package com.example.ppt.temp_ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.net.RestClient;
import com.example.ppt.temp_coer.net.api.Constants;
import com.example.ppt.temp_coer.net.callback.IError;
import com.example.ppt.temp_coer.net.callback.ISuccess;
import com.example.ppt.temp_ec.R;
import com.example.ppt.temp_ec.R2;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;


public class SignUpDelegate extends MikeDalegate {
    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText editSignUpName;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText editSignUpEmail;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText editSignUpPhone;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText editSignUpPassword;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText editSignUpRePassword;
    @BindView(R2.id.btn_sign_up)
    AppCompatButton btnSignUp;
    @BindView(R2.id.text_sign_in)
    AppCompatTextView textSignIn;
    private ISignListener mISignListener = null;


    private boolean checkFrom() {
        final String name = editSignUpName.getText().toString().trim();
        final String email = editSignUpEmail.getText().toString().trim();
        final String phone = editSignUpPhone.getText().toString().trim();
        final String passwrod = editSignUpPassword.getText().toString().trim();
        final String rePasswrod = editSignUpRePassword.getText().toString().trim();
        boolean isPass = true;
        if (name.isEmpty()) {
            editSignUpName.setError("请输入姓名");
            isPass = false;
        } else {
            editSignUpName.setError(null);
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editSignUpEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            editSignUpEmail.setError(null);
        }
        if (phone.isEmpty() || phone.length() != 11) {
            editSignUpPhone.setError("手机号码错误");
            isPass = false;
        } else {
            editSignUpPhone.setError(null);
        }
        if (passwrod.isEmpty() || passwrod.length() < 6) {
            editSignUpPassword.setError("填6位数以上密码");
            isPass = false;
        } else {
            editSignUpPassword.setError(null);
        }
        if (rePasswrod.isEmpty() || rePasswrod.length() < 6 || !rePasswrod.equals(passwrod)) {
            editSignUpRePassword.setError("密码验证错误");
            isPass = false;
        } else {
            editSignUpRePassword.setError(null);
        }
        return isPass;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @OnClick(R2.id.text_sign_in)
    public void onClickSignIn() {
        Toast.makeText(getContext(), "你妹", Toast.LENGTH_LONG).show();
        start(new SignInDelegate(), SINGLETASK);
    }

    @OnClick(R2.id.btn_sign_up)
    public void onClickSignUp() {
        RestClient.builder()
                .url(Constants.LOGIN)
                .params("username", "13049337194")
                .params("userpass", "198541")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Logger.i(response);
                        SignHandler.onSignUp(response,mISignListener);
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(String msg, int code) {

                    }
                })
                .builder()
                .post();
    }
}
