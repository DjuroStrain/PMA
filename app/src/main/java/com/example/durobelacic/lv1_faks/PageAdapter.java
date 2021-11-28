package com.example.durobelacic.lv1_faks;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageAdapter extends FragmentStateAdapter {

    private static final int NUM_PAGES = 3;

    public PageAdapter(CreateNewRecordActivity createNewRecordActivity) {
        super(createNewRecordActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new PersonalInfoFragment();
            case 1:
                return  new StudentInfoFragment();
            case 2:
                return new SummaryFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
