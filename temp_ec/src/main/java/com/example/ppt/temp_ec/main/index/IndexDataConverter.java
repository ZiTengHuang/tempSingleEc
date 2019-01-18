package com.example.ppt.temp_ec.main.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ppt.temp_coer.ui.recycler.DataConverter;
import com.example.ppt.temp_coer.ui.recycler.ItemType;
import com.example.ppt.temp_coer.ui.recycler.MultipleFields;
import com.example.ppt.temp_coer.ui.recycler.MultipleItemEntity;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

public final class IndexDataConverter extends DataConverter {
    @Override
    public ArrayList<MultipleItemEntity> convert() {
        final JSONArray dataArray = JSON.parseObject(getJsonData()).getJSONArray("data");
        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            Logger.i(dataArray.getString(i));
            final JSONObject data = dataArray.getJSONObject(i);
            final String imagUrl = data.getString("imageUrl");
            final String text = data.getString("text");
            final int spanSize = data.getInteger("spanSize");
            final int id = data.getInteger("goodsId");
            final JSONArray banners = data.getJSONArray("banners");
            final ArrayList<String> bannerImages = new ArrayList<>();
            int type = 0;
            if (imagUrl == null && text != null) {
                type = ItemType.TEXT;
            } else if (imagUrl != null && text == null) {
                type = ItemType.IMAGE;
            } else if (imagUrl != null && text != null) {
                type = ItemType.IMAGE_TEXT;
            } else if (banners != null) {
                type = ItemType.BANNER;
                //进行banner的初始化
                final int bannerSize = banners.size();
                for (int j = 0; j < bannerSize; j++) {
                    final String banner = banners.getString(i);
                    bannerImages.add(banner);
                }
            }
            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE,type)
                    .setField(MultipleFields.SPAN_SIZE,spanSize)
                    .setField(MultipleFields.ID,id)
                    .setField(MultipleFields.TEXT,text)
                    .setField(MultipleFields.IMAGE_URL,imagUrl)
                    .setField(MultipleFields.BANNERS,bannerImages)
                    .build();
            ENTITYS.add(entity);
        }
        return ENTITYS;
    }
}
