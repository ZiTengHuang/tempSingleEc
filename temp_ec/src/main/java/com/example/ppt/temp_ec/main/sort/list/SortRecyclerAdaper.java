package com.example.ppt.temp_ec.main.sort.list;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.ui.recycler.ItemType;
import com.example.ppt.temp_coer.ui.recycler.MultipRecyclerAdapter;
import com.example.ppt.temp_coer.ui.recycler.MultipViewHolder;
import com.example.ppt.temp_coer.ui.recycler.MultipleFields;
import com.example.ppt.temp_coer.ui.recycler.MultipleItemEntity;
import com.example.ppt.temp_ec.R;
import com.example.ppt.temp_ec.main.sort.SortDelegate;
import com.example.ppt.temp_ec.main.sort.content.ContentDalegate;

import java.util.List;

public class SortRecyclerAdaper extends MultipRecyclerAdapter {

    private final SortDelegate DELEGATE;
    private int mPerPostion = 0;

    protected SortRecyclerAdaper(List<MultipleItemEntity> data, SortDelegate sortDelegate) {
        super(data);
        this.DELEGATE = sortDelegate;
        addItemType(ItemType.VERTICA_MENU_LIST, R.layout.item_vertical_menu_list);
    }

    @Override
    protected void convert(final MultipViewHolder holder, final MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case ItemType.VERTICA_MENU_LIST:
                final String name = entity.getField(MultipleFields.NAME);
                final int id = entity.getField(MultipleFields.ID);
                final boolean isChecked = entity.getField(MultipleFields.TAG);
                final View line = holder.getView(R.id.view_line);
                final View itemView = holder.itemView;
                final TextView txtName = holder.getView(R.id.tv_vertical_list_name);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final int currentPostion = holder.getAdapterPosition();
                        if (mPerPostion != currentPostion) {
                            getData().get(mPerPostion).setField(MultipleFields.TAG, false);
                            notifyItemChanged(mPerPostion);
                            entity.setField(MultipleFields.TAG, true);
                            notifyItemChanged(currentPostion);
                            mPerPostion = currentPostion;
                            final int contentId = getData().get(currentPostion).getField(MultipleFields.ID);
                            showContent(contentId);
                        }
                    }
                });
                holder.setText(R.id.tv_vertical_list_name, name);
                if (!isChecked) {
                    txtName.setTextColor(ContextCompat.getColor(mContext, R.color.qmui_config_color_10_pure_black));
                    line.setVisibility(View.INVISIBLE);
                    line.setBackgroundColor(ContextCompat.getColor(mContext, R.color.qmui_config_color_white));
                    itemView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.qmui_config_color_white));
                } else {
                    line.setVisibility(View.VISIBLE);
                    txtName.setTextColor(ContextCompat.getColor(mContext, R.color.qmui_config_color_50_blue));
                    line.setBackgroundColor(ContextCompat.getColor(mContext, R.color.qmui_config_color_50_blue));
                    itemView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.btn_ghost_blue_border_disabled));
                }
                break;
            default:
                break;
        }
    }

    private void showContent(int contentId) {
        final ContentDalegate dalegate = ContentDalegate.newInstence(contentId);
        switchContent(dalegate);
    }

    private void switchContent(ContentDalegate dalegate) {
        final MikeDalegate contentDalegate = DELEGATE.findChildFragment(ContentDalegate.class);
        if (contentDalegate != null) {
            contentDalegate.replaceFragment(dalegate, false);
        }
    }
}
