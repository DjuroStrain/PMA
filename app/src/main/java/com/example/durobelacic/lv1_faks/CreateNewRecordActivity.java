package com.example.durobelacic.lv1_faks;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

public class CreateNewRecordActivity extends FragmentActivity {

    private ViewPager2 viewPager2;
    private FragmentStateAdapter pageAdapter;
    public String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);


        viewPager2 = findViewById(R.id.pager);
        pageAdapter = new PageAdapter(this);
        viewPager2.setAdapter(pageAdapter);
    }




}