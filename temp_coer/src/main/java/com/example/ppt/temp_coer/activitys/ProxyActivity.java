package com.example.ppt.temp_coer.activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.example.ppt.temp_coer.R;
import com.example.ppt.temp_coer.dalegates.TempDalegate;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity {

    public abstract TempDalegate setRootDalegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        @SuppressLint("RestrictedApi") final ContentFrameLayout contentFrameLayout = new ContentFrameLayout(this);
        contentFrameLayout.setId(R.id.dalegate_conteinar);
        setContentView(contentFrameLayout);
        if (savedInstanceState == null){
             loadRootFragment(R.id.dalegate_conteinar,setRootDalegate());
        }
    }
    
}
