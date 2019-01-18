package com.example.ppt.temp_coer.ui.recycler;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.ppt.temp_coer.R;

import java.util.ArrayList;
import java.util.List;

public class MultipRecyclerAdapter extends BaseMultiItemQuickAdapter<MultipleItemEntity, MultipViewHolder> implements BaseQuickAdapter.SpanSizeLookup {


    protected MultipRecyclerAdapter(List<MultipleItemEntity> data) {
        super(data);
        init();
    }

    public static MultipRecyclerAdapter create(List<MultipleItemEntity> data) {
        return new MultipRecyclerAdapter(data);
    }

    public static MultipRecyclerAdapter create(DataConverter converter) {
        return new MultipRecyclerAdapter(converter.convert());
    }

    //设置图片加载策略

    private static final RequestOptions REQUEST_OPTIONS = new RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)  //全部缓存包括剪切后裁剪后的
            .dontAnimate();  //不需要图片加载动画

    private boolean mInInitBanner = false;

    private void init() {
        //设置不同的item布局
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        addItemType(ItemType.IMAGE, R.layout.item_multiple_imager);
        addItemType(ItemType.IMAGE_TEXT, R.layout.item_multiple_image_text);
        addItemType(ItemType.BANNER, R.layout.item_multiple_imager_haha);

        //设置宽度监听
        setSpanSizeLookup(this);
        openLoadAnimation();

        //是否多次进行动画
        isFirstOnly(false);
    }

    @Override
    protected MultipViewHolder createBaseViewHolder(View view) {
        return MultipViewHolder.create(view);
    }

    @Override
    protected void convert(MultipViewHolder holder, MultipleItemEntity entity) {
        final String text;
        final String imgUrl;
        final ArrayList<String> bannerImages;
        switch (holder.getItemViewType()) {
            case ItemType.TEXT:
                text = entity.getField(MultipleFields.TEXT);
                holder.setText(R.id.text_single, text);
                break;
            case ItemType.IMAGE:
                imgUrl = entity.getField(MultipleFields.IMAGE_URL);
                Glide.with(mContext).load(imgUrl).apply(REQUEST_OPTIONS).into((ImageView) holder.getView(R.id.image_single));
                break;
            case ItemType.IMAGE_TEXT:
                text = entity.getField(MultipleFields.TEXT);
                imgUrl = entity.getField(MultipleFields.IMAGE_URL);
                Glide.with(mContext).load(imgUrl).apply(REQUEST_OPTIONS).into((ImageView) holder.getView(R.id.img_multip));
                holder.setText(R.id.tx_multip, text);
                break;
            case ItemType.BANNER:
                if (!mInInitBanner) {
                    bannerImages = entity.getField(MultipleFields.BANNERS);
                    Glide.with(mContext).load(bannerImages.get(0)).apply(REQUEST_OPTIONS).into((ImageView) holder.getView(R.id.image_single_haha));
                }
                break;
            default:
                break;
        }
    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return getData().get(position).getField(MultipleFields.SPAN_SIZE);
    }
}
