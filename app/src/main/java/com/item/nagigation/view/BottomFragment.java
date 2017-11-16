package com.item.nagigation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.item.nagigation.R;

/**
 * Created by wuzongjie on 2017/11/16.
 */

public class BottomFragment extends BottomSheetDialogFragment{
    public static BottomFragment getInstance(){
        BottomFragment fragment = new BottomFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_sheet,container,false);
        return view;
    }
}
