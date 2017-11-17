package com.item.nagigation.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Property;
import android.view.View;

import com.item.nagigation.R;

public class FourActivity extends AppCompatActivity {

    private ColorDrawable mBgDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        // 拿到根布局
        View root = findViewById(R.id.activity_launch);
        // 获取颜色
        int color = getResources().getColor(R.color.test_one);
        // 创建一个Drawable
        ColorDrawable drawable = new ColorDrawable(color);
        // 设置给背景
        root.setBackground(drawable);
        mBgDrawable = drawable;

//        startAnim(0.5f, new Runnable() {
//            @Override
//            public void run() {
//                Log.d("jiejie","展示到了50");
//                startAnim(1, new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.d("jiejie","100了");
//                    }
//                });
//            }
//        });
        startAnim(1, new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(FourActivity.this,FiveActivity.class));
            }
        });
    }

    /**
     * 给背景设置一个动画
     * @param endProgress 动画的结束进度
     * @param endCallback 动画结束时触发
     */
    private void startAnim(float endProgress, final Runnable endCallback) {
        // 获取一个最终的颜色
        int finalColor = getResources().getColor(R.color.white);
        ArgbEvaluator evaluator = new ArgbEvaluator();
        int endColor = (int) evaluator.evaluate(endProgress, mBgDrawable.getColor(), finalColor);
        // 构建一个属性动画
        ValueAnimator valueAnimator = ObjectAnimator.ofObject(this, property, evaluator, endColor);
        valueAnimator.setDuration(1500);
        valueAnimator.setIntValues(mBgDrawable.getColor(), endColor); // 开始结束值
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // 结束时触发
                endCallback.run();
            }
        });
        valueAnimator.start();
    }

    private final Property<FourActivity, Object> property = new Property<FourActivity, Object>(Object.class, "color") {
        @Override
        public void set(FourActivity object, Object value) {
            object.mBgDrawable.setColor((Integer) value);
        }

        @Override
        public Object get(FourActivity object) {
            return object.mBgDrawable.getColor();
        }
    };
}
