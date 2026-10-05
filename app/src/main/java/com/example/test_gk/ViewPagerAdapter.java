package com.example.test_gk;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return ItemFragment.newInstance(ItemFragment.LAYOUT_GRID);
            case 2:
                return ItemFragment.newInstance(ItemFragment.LAYOUT_STAGGERED);
            case 0:
            default:
                return ItemFragment.newInstance(ItemFragment.LAYOUT_LINEAR);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}