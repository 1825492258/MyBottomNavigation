package com.item.nagigation.activity;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.item.nagigation.R;
import com.item.nagigation.view.BottomFragment;

/**
 * BottomSheet
 * app:behavior_hideable="true" // 表示BottomSheet 完全隐藏，默认为false
 * app:behavior_peekHeight="50dp" // 当为STATE_COLLAPSED（折叠）状态的时候bottom sheet残留的高度，默认为0
 * app:layout_behavior="@string/bottom_sheet_behavior"
 *
 * BottomSheet 有以下5种状态
 * STATE_COLLAPSED:磨人的折叠状态 显示高度可以通过app:behavior_peekHeight 设置
 * STATE_DRAGGING:过渡状态，此时用户正在向上或者向下拖动bottom sheet
 * STATE_SETTLING:视图从脱离手指自由滑动到最终停下的这一小段时间
 * STATE_EXPANDED:  bottom sheet 处于完全展开的状态：当bottom sheet的高度低于CoordinatorLayout容器时，整个bottom sheet都可见；或者CoordinatorLayout容器已经被bottom sheet填满
 * STATE_HIDDEN :完全隐藏BottomSheet
 */
public class TwoActivity extends AppCompatActivity implements View.OnClickListener {
    private BottomSheetBehavior behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        // 获取到BottomSheet 对象
        View bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                break;
            case R.id.button1:
                BottomSheetDialog mDialog = new BottomSheetDialog(this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_sheet,null);
                mDialog.setContentView(view1);
                mDialog.show();
                break;
            case R.id.button2:
                BottomFragment.getInstance().show(getSupportFragmentManager(),"Dialog");
                break;
        }
    }
}
