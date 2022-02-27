package com.example.buttommenubar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

    private RadioGroup rg_tab_bar;
    private RadioButton rb_main;
    private RadioButton rb_query;
    private RadioButton rb_predict;
    private RadioButton rb_user;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;

    //代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        initViews();
        rb_main.setChecked(true);
    }

    private void initViews() {
        rg_tab_bar =  findViewById(R.id.rg_tab_bar);
        rb_main =  findViewById(R.id.rb_main);
        rb_query =  findViewById(R.id.rb_query);
        rb_predict =  findViewById(R.id.rb_predict);
        rb_user =  findViewById(R.id.rb_user);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_main:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_query:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_predict:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_user:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_main.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_query.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_predict.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_user.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

