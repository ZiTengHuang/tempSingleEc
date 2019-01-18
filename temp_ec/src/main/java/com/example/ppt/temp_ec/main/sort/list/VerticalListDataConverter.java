package com.example.ppt.temp_ec.main.sort.list;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ppt.temp_coer.ui.recycler.DataConverter;
import com.example.ppt.temp_coer.ui.recycler.ItemType;
import com.example.ppt.temp_coer.ui.recycler.MultipleFields;
import com.example.ppt.temp_coer.ui.recycler.MultipleItemEntity;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

public final class VerticalListDataConverter extends DataConverter {
    @Override
    public ArrayList<MultipleItemEntity> convert() {
        final ArrayList<MultipleItemEntity> dataList = new ArrayList<>();
        final JSONArray jsonArray = JSON.parseObject(getJsonData()).getJSONObject("data").getJSONArray("list");
        Logger.i(jsonArray.getString(0));
        final int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = jsonArray.getJSONObject(i);
            final int id = data.getInteger("id");
            final String name = data.getString("name");
            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, ItemType.VERTICA_MENU_LIST)
                    .setField(MultipleFields.ID, id)
                    .setField(MultipleFields.NAME, name)
                    .setField(MultipleFields.TAG, false)
                    .build();
            dataList.add(entity);
            dataList.get(0).setField(MultipleFields.TAG, true);
        }
        return dataList;
    }
}
