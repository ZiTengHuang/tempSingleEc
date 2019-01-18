package com.example.ppt.temp_ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.ui.recycler.MultipleItemEntity;
import com.example.ppt.temp_ec.R;
import com.example.ppt.temp_ec.R2;
import com.example.ppt.temp_ec.main.sort.SortDelegate;

import java.util.List;

import butterknife.BindView;

public class VerticalListDalegate extends MikeDalegate {
    @BindView(R2.id.rv_vertical_list)
    RecyclerView mRecyclerView;

    @Override
    public Object setLayout() {
        return R.layout.dalegate_vertical;
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(null);
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initRecyclerView();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        //懒加载  加载网络数据
        final List<MultipleItemEntity> list = new VerticalListDataConverter().setJsonData(response).convert();
        final SortDelegate sortDelegate = new SortDelegate();
        final SortRecyclerAdaper adaper = new SortRecyclerAdaper(list, sortDelegate);
        mRecyclerView.setAdapter(adaper);
    }

    private String response = "{\n" +
            "  \"code\": 0,\n" +
            "  \"message\": \"OK\",\n" +
            "  \"data\": {\n" +
            "    \"list\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"新品\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"name\": \"手机\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 3,\n" +
            "        \"name\": \"电视\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"name\": \"电脑\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"name\": \"家电\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 6,\n" +
            "        \"name\": \"路由\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 7,\n" +
            "        \"name\": \"智能\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 8,\n" +
            "        \"name\": \"电源\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 9,\n" +
            "        \"name\": \"耳机\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 10,\n" +
            "        \"name\": \"音箱\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 11,\n" +
            "        \"name\": \"礼品\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 12,\n" +
            "        \"name\": \"生活\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 13,\n" +
            "        \"name\": \"零售\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 14,\n" +
            "        \"name\": \"分类14\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 15,\n" +
            "        \"name\": \"分类15\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 16,\n" +
            "        \"name\": \"分类16\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 17,\n" +
            "        \"name\": \"分类17\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 18,\n" +
            "        \"name\": \"分类18\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 19,\n" +
            "        \"name\": \"分类19\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 20,\n" +
            "        \"name\": \"分类20\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
}
