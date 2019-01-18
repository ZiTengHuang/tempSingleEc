package com.example.ppt.temp_ec.main.sort.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_ec.R;
import com.example.ppt.temp_ec.R2;

import butterknife.BindView;

public class ContentDalegate extends MikeDalegate {
    public static final String ARG_CONTENT_ID = "CONTENT_ID";
    private int mContentId = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            mContentId = args.getInt(ARG_CONTENT_ID);
        }
    }

    public static ContentDalegate newInstence(int contentId) {
        final Bundle args = new Bundle();
        args.putInt(ARG_CONTENT_ID, contentId);
        final ContentDalegate dalegate = new ContentDalegate();
        dalegate.setArguments(args);
        return dalegate;
    }

    @BindView(R2.id.rv_content_list)
    RecyclerView mRecyclerView;

    @Override
    public Object setLayout() {
        return R.layout.dalegate_content;
    }


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
