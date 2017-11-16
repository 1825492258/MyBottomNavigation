package com.item.nagigation.helper;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.item.nagigation.R;


/**
 * Created by wuzongjie on 2017/11/15.
 * ToolBar
 */

public class ToolBarHelp {

    private LinearLayout mLeftLayout; // 左侧返回
    private ImageView mLeftImage; // 左侧返回的图片资源
    private TextView mTitle; // 标题
    private LinearLayout mRightLayout; // 右侧按钮
    private TextView mRight; // 右侧的文字
    private Toolbar toolbar; // Toolbar

    public ToolBarHelp(AppCompatActivity activity) {
        toolbar = (Toolbar) activity.findViewById(R.id.bar_tool);
        mLeftLayout = (LinearLayout) activity.findViewById(R.id.bar_left_layout);
        mLeftImage = (ImageView) activity.findViewById(R.id.bar_image);
        mTitle = (TextView) activity.findViewById(R.id.bar_title);
        mRightLayout = (LinearLayout) activity.findViewById(R.id.bar_right_layout);
        mRight = (TextView) activity.findViewById(R.id.bar_right_text);
    }

    /**
     * 获取视图
     *
     * @return Toolbar
     */
    public Toolbar getToolbar() {
        return toolbar;
    }

    /**
     * 设置 标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        mTitle.setText(title);
    }

    /**
     * 设置右侧文字
     *
     * @param text 字
     */
    public void setRightText(String text) {
        mRight.setText(text);
    }

    /**
     * 设置左侧图片资源
     *
     * @param id 资源
     */
    public void setLeftImage(int id) {
        mLeftImage.setImageResource(id);
    }

    /**
     * 左侧的点击事件
     *
     * @param listener 事件
     */
    public void setLeftListener(View.OnClickListener listener) {
        if (listener != null) {
            mLeftLayout.setVisibility(View.VISIBLE);
            mLeftLayout.setOnClickListener(listener);
        }
    }

    /**
     * 右侧的点击事件
     *
     * @param listener 事件
     */
    public void setRightListener(View.OnClickListener listener) {
        if (listener != null) {
            mRightLayout.setVisibility(View.VISIBLE);
            mRightLayout.setOnClickListener(listener);
        }
    }
}
