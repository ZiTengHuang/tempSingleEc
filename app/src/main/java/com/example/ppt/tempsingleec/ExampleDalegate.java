package com.example.ppt.tempsingleec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ppt.temp_coer.dalegates.TempDalegate;

public class ExampleDalegate extends TempDalegate {


    @Override
    public Object setLayout() {
        return R.layout.temp_daltegate;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View view) {

    }
}
