package com.example.durobelacic.lv1_faks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentInfoFragment extends Fragment {

    PageViewModel pageViewModel;
    EditText txtDatum;
    Button btnDalje;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnDalje = view.findViewById(R.id.btnDalje);
        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
        EditText editImeProf = view.findViewById(R.id.editTextImeProf);
        editImeProf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pageViewModel.setImeProf(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
        EditText editPredmet = view.findViewById(R.id.editTextPredmet);
        editPredmet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pageViewModel.setPredmet(s.toString());
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
    }
}