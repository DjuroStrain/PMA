package com.example.durobelacic.lv1_faks;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Course {
    private String title;
    private ArrayList<Instructors> instructors;

    public String getTitle(){
        return title;
    }

    public ArrayList<Instructors> getInstructors(){
        return instructors;
    }

    @NonNull
    @Override
    public String toString(){
        return title;
    }

}
