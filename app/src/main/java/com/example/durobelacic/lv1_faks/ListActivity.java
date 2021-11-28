package com.example.durobelacic.lv1_faks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private Button btnNovi;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mRecyclerView = findViewById(R.id.myRecyclerView);

        DataHolder dataHolder = DataHolder.getInstance();
        List<Object> dataList = dataHolder.getData();

        if(dataList.size() == 0)
        {
            dataList.add("Studenti");
        }

        setAdapter(dataList);

        btnNovi = findViewById(R.id.btnNovi);
        btnNovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CreateNewRecordActivity = new Intent(getApplicationContext(), com.example.durobelacic.lv1_faks.CreateNewRecordActivity.class);
                startActivity(CreateNewRecordActivity);
            }
        });
    }

    private void setAdapter(List<Object> list){
        RecyclerViewInfo myAdapter = new RecyclerViewInfo(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.clearAnimation();
        mRecyclerView.setAdapter(myAdapter);
    }

}