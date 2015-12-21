package com.naroran.onsport.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.naroran.onsport.fragment.MatchInfoOne;
import com.naroran.onsport.fragment.MatchInfoTwo;

public class MatchAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MatchAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MatchInfoOne tab1 = new MatchInfoOne("england");
                return tab1;
            case 1:
                tab1 = new MatchInfoOne("germany");
                return tab1;
            case 2:
                tab1 = new MatchInfoOne("spain");
                return tab1;
            case 3:
                tab1 = new MatchInfoOne("italy");
                return tab1;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}