package com.example.ppt.temp_ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ppt.temp_coer.dalegates.bottom.BottomItemDelegate;
import com.example.ppt.temp_ec.R;
import com.example.ppt.temp_ec.R2;
import com.joanzapata.iconify.widget.IconTextView;

import butterknife.BindView;

public class IndexDelegate extends BottomItemDelegate {

    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mSwipeRefreshLayout = null;
    @BindView(R2.id.icon_scan_index)
    IconTextView mIconScan = null;
    @BindView(R2.id.ed_search_view)
    AppCompatEditText mSearchView = null;
    @BindView(R2.id.icon_message_index)
    IconTextView mMessage = null;

    private void initRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.qmui_config_color_blue,
                R.color.qmui_config_color_red,
                R.color.qmui_config_color_10_pure_black
        );
        mSwipeRefreshLayout.setProgressViewOffset(true, 120, 300);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
