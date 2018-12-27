package com.example.ppt.temp_coer.ui.recycler;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

public class MultipViewHolder extends BaseViewHolder {
    public MultipViewHolder(View view) {
        super(view);
    }

    public static MultipViewHolder create(View view) {
        return new MultipViewHolder(view);
    }
}
