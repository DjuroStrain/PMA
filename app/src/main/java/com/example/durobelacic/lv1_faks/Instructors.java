package com.example.durobelacic.lv1_faks;

import androidx.annotation.NonNull;

public class Instructors {

    public String name;

    public String getName(){
        return name;
    }

    @NonNull
    @Override
    public String toString(){
        return name;
    }
}
