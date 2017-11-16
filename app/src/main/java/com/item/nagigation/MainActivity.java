package com.item.nagigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.item.nagigation.activity.OneActivity;
import com.item.nagigation.activity.ThreeActivity;
import com.item.nagigation.activity.TwoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one: // BottomNavigationView
                startActivity(new Intent(this, OneActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(this, TwoActivity.class));
                break;
            case R.id.btn_three:
                startActivity(new Intent(this, ThreeActivity.class));
                break;
        }
    }
}
