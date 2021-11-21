package com.example.durobelacic.lv1_faks;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {

    public List<Object> objectList;

    private static DataHolder instance;

    private DataHolder() {
        objectList = new ArrayList<Object>();
    }

    static DataHolder getInstance() {
        if( instance == null ) {
            instance = new DataHolder();
        }
        return instance;
    }

    public List<Object> getData(){
        return objectList;
    }
}
