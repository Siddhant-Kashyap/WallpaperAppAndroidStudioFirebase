package com.developersiddhantkashyap.craftywallpaper;

import android.service.quickaccesswallet.GetWalletCardsCallback;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentManager extends FragmentPagerAdapter {

    private int tabNum;

    public FragmentManager(@NonNull androidx.fragment.app.FragmentManager fm, int behavior, int tabNum) {
        super(fm, behavior);
        this.tabNum = tabNum;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return  new NewArrivalFragment();
            case 1: return  new FeaturedFragment();
            case 2: return  new PremiumFragment();
            default: return null;

        }


    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
