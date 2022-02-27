package com.example.buttommenubar;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 4;

    private HomeFragment homeFragment;
    private PredictFragment predictFragment;
    private QueryFragment queryFragment;
    private UserFragment userFragment;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        homeFragment=new HomeFragment();
        predictFragment=new PredictFragment();
        queryFragment=new QueryFragment();
        userFragment=new UserFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = homeFragment;
                break;
            case MainActivity.PAGE_TWO:
                fragment = queryFragment;
                break;
            case MainActivity.PAGE_THREE:
                fragment = predictFragment;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = userFragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
