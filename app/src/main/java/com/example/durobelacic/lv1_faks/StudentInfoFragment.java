package com.example.durobelacic.lv1_faks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class StudentInfoFragment extends Fragment implements Callback<ApiResponse>, AdapterView.OnItemSelectedListener{

    ArrayList<String> courses = new ArrayList<>();
    ArrayList<ArrayList<Instructors>> courses2 = new ArrayList<ArrayList<Instructors>>();


    PageViewModel pageViewModel;
    EditText txtDatum;
    Button btnDalje;

    Spinner spinnerPredmet, spinnerProf;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ApiManager.getInstance().service().getCourses().enqueue(this);

        return inflater.inflate(R.layout.fragment_student_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnDalje = view.findViewById(R.id.btnDalje);
        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);

        EditText editAkadGod = view.findViewById(R.id.editTextAkadGod);
        editAkadGod.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pageViewModel.setAkadGod(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        EditText editBrojPred = view.findViewById(R.id.editTextPred);
        editBrojPred.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pageViewModel.setBrojPred(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        EditText editBrojLv = view.findViewById(R.id.editTextLv);
        editBrojLv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pageViewModel.setBrojLv(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        spinnerPredmet = view.findViewById(R.id.editTextPredmet);
        spinnerProf = view.findViewById(R.id.editTextImeProf);
    }

    @Override
    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
        if (response.isSuccessful() && response.body() != null) {

            ApiResponse apiResponse = (ApiResponse) response.body();
            for (Course course : apiResponse.courses) {
                courses.add(course.getTitle());
            }
            courses.add(0, "Odaberite predmet");
            ArrayAdapter<String> predmetAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, courses);
            predmetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerPredmet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    pageViewModel.setPredmet(parent.getItemAtPosition(position).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            spinnerPredmet.setAdapter(predmetAdapter);

            for (Course course : apiResponse.courses) {
                if(course.getInstructors() != null)
                courses2.add(course.getInstructors());
            }

            ArrayList<String> instructors = new ArrayList<>();
            for (int i = 0; i < courses2.size(); i++){

                for(int j = 0; j < courses2.get(i).size(); j++)
                {
                    instructors.add(courses2.get(i).get(j).toString());
                }
            }
            Set<String> setIns = new HashSet<>(instructors);

            ArrayList<String> instructors2 = new ArrayList<>(setIns);
            instructors2.add(0, "Odaberite profesora");
            System.out.println("List with duplicates: "+instructors2.size());
            System.out.println(instructors2);


            ArrayAdapter<String> profAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, instructors2);
            profAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerProf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    pageViewModel.setImeProf(parent.getItemAtPosition(position).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            spinnerProf.setAdapter(profAdapter);
        }
    }

    @Override
    public void onFailure (Call < ApiResponse > call, Throwable t){

        t.printStackTrace();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}