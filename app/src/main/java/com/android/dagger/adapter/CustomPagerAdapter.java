package com.android.dagger.adapter;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CustomPagerAdapter extends FragmentStatePagerAdapter{

    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String> titleLists = new ArrayList<>();

    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        titleLists.add(title);
    }

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleLists.get(position);
    }

    public void clearList() {
        fragments.clear();
        titleLists.clear();
    }
}
