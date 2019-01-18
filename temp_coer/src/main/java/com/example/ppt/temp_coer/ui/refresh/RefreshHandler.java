package com.example.ppt.temp_coer.ui.refresh;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.ppt.temp_coer.app.Mike;
import com.example.ppt.temp_coer.ui.recycler.DataConverter;
import com.example.ppt.temp_coer.ui.recycler.MultipRecyclerAdapter;

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {


    private SwipeRefreshLayout REFRESH_LAYOUT;
    private final PagingBean BEAN;
    private final RecyclerView RECYCLERVIEW;
    private MultipRecyclerAdapter mAdapter = null;
    private final DataConverter CONVERTER;

    public RefreshHandler(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, DataConverter converter, PagingBean bean) {
        this.REFRESH_LAYOUT = swipeRefreshLayout;
        this.RECYCLERVIEW = recyclerView;
        this.CONVERTER = converter;
        this.BEAN = bean;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    public static RefreshHandler create(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, DataConverter converter) {
        return new RefreshHandler(swipeRefreshLayout, recyclerView, converter, new PagingBean());
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

    String response = "{\n" +
            "  \"code\": 0,\n" +
            "  \"message\": \"OK\",\n" +
            "  \"total\": 100,\n" +
            "  \"page_size\": 6,\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"goodsId\": 0,\n" +
            "      \"spanSize\": 4,\n" +
            "      \"banners\": [\n" +
            "        \"https://i8.mifile.cn/v1/a1/251f0880-423e-fa2d-3c18-1d3ec23f9912.webp\",\n" +
            "        \"https://i8.mifile.cn/v1/a1/49dfd019-9504-abb5-34bb-26f425b67e45.webp\",\n" +
            "        \"https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/b9540da01aef9a00a5c640b1c98b955a.jpg\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 1,\n" +
            "      \"text\": \"明星单品\",\n" +
            "      \"imageUrl\": \"https://i8.mifile.cn/v1/a1/1d338200-1be1-f868-9695-9d5ae0d6c2c6.webp\",\n" +
            "      \"spanSize\": 4\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 2,\n" +
            "      \"text\": \"小米5c  64GB 移动版\",\n" +
            "      \"imageUrl\": \"https://i8.mifile.cn/v1/a1/04629084-7810-d1fb-6f4a-a0c52433ca29.webp?width=360&height=360\",\n" +
            "      \"spanSize\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 3,\n" +
            "      \"text\": \"米家智能摄像机\",\n" +
            "      \"imageUrl\": \"https://i8.mifile.cn/v1/a1/375bd3a4-aab9-f77b-f6a1-5dbf01087495.webp?width=360&height=360\",\n" +
            "      \"spanSize\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 4,\n" +
            "      \"imageUrl\": \"https://i8.mifile.cn/v1/a1/656a5863-6af1-6302-4e36-a33bd49e45cb.webp?width=360&height=360\",\n" +
            "      \"spanSize\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 5,\n" +
            "      \"imageUrl\": \"https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/cbcdb6c054d45c1afc955c87329e96f1.jpg?width=360&height=360\",\n" +
            "      \"spanSize\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 6,\n" +
            "      \"imageUrl\": \"https://i8.mifile.cn/v1/a1/f093e0a8-e3d8-4fc8-deb7-af25ea3d8663.webp?width=360&height=360\",\n" +
            "      \"spanSize\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 7,\n" +
            "      \"imageUrl\": \"https://i8.mifile.cn/v1/a1/b6c55f3b-d4ac-b2be-8d7c-3c818a79030a.webp?width=360&height=360\",\n" +
            "      \"spanSize\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 5,\n" +
            "      \"text\": \"智能生活，从这里开始\",\n" +
            "      \"spanSize\": 4\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 5,\n" +
            "      \"text\": \"测试描述5\",\n" +
            "      \"imageUrl\": \"https://i8.mifile.cn/v1/a1/6cc739d8-ae51-779a-3707-2f1d20a558bf.webp?width=720&heihgt=440\",\n" +
            "      \"spanSize\": 4\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 6,\n" +
            "      \"text\": \"测试描述6\",\n" +
            "      \"imageUrl\": \"http://imgsrc.baidu.com/baike/pic/item/0b55b319ebc4b745a58395aecffc1e178a821576.jpg\",\n" +
            "      \"spanSize\": 4\n" +
            "    },\n" +
            "    {\n" +
            "      \"goodsId\": 5,\n" +
            "      \"text\": \"我又是野广告\",\n" +
            "      \"spanSize\": 4\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public void firstPage(String url) {

        final JSONObject jsonObject = JSON.parseObject(response);
        BEAN.setTotal(jsonObject.getInteger("total"))
                .setPageSize(jsonObject.getInteger("page_size"));
        mAdapter = MultipRecyclerAdapter.create(CONVERTER.setJsonData(response));
        mAdapter.setOnLoadMoreListener(RefreshHandler.this, RECYCLERVIEW);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        RECYCLERVIEW.setAdapter(mAdapter);
        BEAN.addIndex();
     }

    @Override
    public void onRefresh() {
        refresh();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
