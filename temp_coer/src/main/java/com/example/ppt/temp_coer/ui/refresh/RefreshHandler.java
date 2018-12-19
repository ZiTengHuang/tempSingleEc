package com.example.ppt.temp_coer.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

import com.example.ppt.temp_coer.app.Mike;
import com.example.ppt.temp_coer.net.RestClient;
import com.example.ppt.temp_coer.net.callback.ISuccess;

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout swipeRefreshLayout) {
        this.REFRESH_LAYOUT = swipeRefreshLayout;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        Mike.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    public void firstPage(String url) {
        RestClient.builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                    }
                })
                .builder()
                .get();
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
