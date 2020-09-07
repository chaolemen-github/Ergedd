package com.chaolemen.ergedd.look.adapter;

//import android.app.FragmentManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class TabVPAdapter extends FragmentStatePagerAdapter {
   private  ArrayList<Fragment> fragments;
   private  ArrayList<String> titles;

    public TabVPAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

 /*   public TabVPAdapter(FragmentManager fm) {
        super(fm);
    }*/



    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
