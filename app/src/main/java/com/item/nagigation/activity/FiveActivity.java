package com.item.nagigation.activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.item.nagigation.R;

public class FiveActivity extends AppCompatActivity {
    private ImageView img_bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        img_bg = (ImageView)findViewById(R.id.img_bg);
        Glide.with(this)
                .load(R.drawable.bg_src_tianjin)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        // 拿到Glide的Drawable
                        Drawable drawable = resource.getCurrent();
                        // 使用适配类进行包装
                        drawable = DrawableCompat.wrap(drawable);
                        // 设置着色的效果和颜色，蒙板模式
                        drawable.setColorFilter(getResources().getColor(R.color.test_two),
                                PorterDuff.Mode.SCREEN);
                        // 设置给ImageView
                        img_bg.setImageDrawable(drawable);
                    }
                });
    }
}
