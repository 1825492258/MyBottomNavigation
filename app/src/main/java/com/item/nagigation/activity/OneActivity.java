package com.item.nagigation.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnticipateInterpolator;

import com.item.nagigation.R;
import com.item.nagigation.frament.OneFragment;
import com.item.nagigation.frament.ThreeFragment;
import com.item.nagigation.frament.TwoFragment;
import com.item.nagigation.helper.DensityUtils;
import com.item.nagigation.helper.NavHelper;
import com.item.nagigation.helper.ToolBarHelp;

import java.util.Objects;

public class OneActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavHelper.OnTabChangedListener<Integer> {

    private BottomNavigationView mNavigation;
    private NavHelper<Integer> mNavHelper;
    private ToolBarHelp mBarHelp;

    private FloatingActionButton mAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        mNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        mAction = (FloatingActionButton)findViewById(R.id.btn_action);
        // 初始化底部辅助工具类
        mNavHelper = new NavHelper<>(this, R.id.lay_container,
                getSupportFragmentManager(), this);
        mNavHelper.add(R.id.action_home, new NavHelper.Tab<Integer>(OneFragment.class, R.string.title_home))
                .add(R.id.action_group,new NavHelper.Tab<Integer>(TwoFragment.class,R.string.title_group))
                .add(R.id.action_contact,new NavHelper.Tab<Integer>(ThreeFragment.class,R.string.title_contact));
        mNavigation.setOnNavigationItemSelectedListener(this);

        // 从底部导航栏中接管我们的Menu，然后进行手动的触发第一次点击
        Menu menu = mNavigation.getMenu();
        menu.performIdentifierAction(R.id.action_home, 0);

        // 对ToolBar的添加
        mBarHelp = new ToolBarHelp(this);
        mBarHelp.setTitle("标题");
        mBarHelp.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d("jiejie", "item" + item.getTitle().toString().toUpperCase());
        return mNavHelper.performClickMenu(item.getItemId());
    }

    /**
     * NavHelper 处理后回调的方法
     * @param newTab 新的Tab
     * @param oldTab 旧的Tab
     */
    @Override
    public void onTabChanged(NavHelper.Tab<Integer> newTab, NavHelper.Tab<Integer> oldTab) {

        float transY = 0;
        float rotation = 0;
        if(newTab.extra.equals(R.string.title_home)){
            transY = DensityUtils.dp2px(76);
        }else {
            if(newTab.extra.equals(R.string.title_group)){
                mAction.setImageResource(R.drawable.ic_group);
                rotation = - 360;
            }else {
                mAction.setImageResource(R.drawable.ic_contact);
                rotation = 360;
            }
        }
        // 开始动画
        // 旋转,Y轴位移
        mAction.animate()
                .rotation(rotation)
                .translationY(transY)
                .setInterpolator(new AnticipateInterpolator(1))
                .setDuration(480)
                .start();
    }
}
