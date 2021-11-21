package com.example.durobelacic.lv1_faks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public  class RecyclerViewInfo extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int STUDENT = 1;
    private int HEADER = 2;
    private List<Object> objectList;

    public RecyclerViewInfo(List<Object> objectList){
        this.objectList = objectList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == STUDENT)
        {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.student_view_holder, parent, false);
            return new studentViewHolder(view);
        }
        else
        {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.header_view_holder, parent, false);
            return new headerViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == STUDENT)
        {
            studentViewHolder student = (studentViewHolder) holder;
            Student studentData = (Student) objectList.get(position);

            String ime = studentData.getsIme();
            String prezime = studentData.getsPrezime();
            String predmet = studentData.getsPredmet();

            student.ime.setText(ime+" "+prezime);
            student.predmet.setText(predmet);
        }
        else
        {
            headerViewHolder header = (headerViewHolder) holder;
            String hedaerText = objectList.get(position).toString();
            header.naslov.setText(hedaerText);
        }
    }



    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(objectList.get(position) instanceof Student){
            return STUDENT;
        }
        else
        {
            return HEADER;
        }

    }

    private class studentViewHolder extends RecyclerView.ViewHolder {

        private TextView ime;
        private TextView predmet;

        public studentViewHolder(@NonNull View itemView) {
            super(itemView);
            ime = itemView.findViewById(R.id.viewIme);
            predmet = itemView.findViewById(R.id.viewPredmet);
        }
    }
    private class headerViewHolder extends RecyclerView.ViewHolder {

        private TextView naslov;

        public headerViewHolder(@NonNull View itemView) {
            super(itemView);
            naslov = itemView.findViewById(R.id.tvTitle);
        }
    }



}