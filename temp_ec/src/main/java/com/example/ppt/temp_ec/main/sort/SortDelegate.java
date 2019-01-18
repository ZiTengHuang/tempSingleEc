package com.example.ppt.temp_ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ppt.temp_coer.dalegates.bottom.BottomItemDelegate;
import com.example.ppt.temp_ec.R;
import com.example.ppt.temp_ec.main.sort.content.ContentDalegate;
import com.example.ppt.temp_ec.main.sort.list.VerticalListDalegate;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;

public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListDalegate verticalListDalegate = new VerticalListDalegate();
        loadRootFragment(R.id.fl_sort_list,verticalListDalegate);
        loadRootFragment(R.id.fl_sort_content,ContentDalegate.newInstence(1));
    }
}
