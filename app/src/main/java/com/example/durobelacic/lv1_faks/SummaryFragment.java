package com.example.durobelacic.lv1_faks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicReference;

public class SummaryFragment extends Fragment {

    private PageViewModel pageViewModel;
    private TextView txtDatum;

    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        TextView datum = view.findViewById(R.id.viewDatum);
        TextView imePrez = view.findViewById(R.id.viewImePrez);
        TextView imeProf = view.findViewById(R.id.viewProf);
        TextView akadGod = view.findViewById(R.id.viewAkaGod);
        TextView predmet = view.findViewById(R.id.viewPredmet);
        TextView brojPred = view.findViewById(R.id.viewBrojPred);
        TextView brojLv = view.findViewById(R.id.viewBrojLV);

        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
        pageViewModel.getDatum().observe(getViewLifecycleOwner(), item -> {
            datum.setText(item);
        });

        pageViewModel.getIme().observe(getViewLifecycleOwner(), item -> {
            pageViewModel.getPrezime().observe(getViewLifecycleOwner(), item2 -> {
                imePrez.setText(item+" "+item2);
            });
        });

        pageViewModel.getImeProf().observe(getViewLifecycleOwner(), item -> {
            imeProf.setText(item);
        });

        pageViewModel.getAkadGod().observe(getViewLifecycleOwner(), item -> {
            akadGod.setText(item);
        });

        pageViewModel.getPredmet().observe(getViewLifecycleOwner(), item -> {
            predmet.setText(item);
        });

        pageViewModel.getBrojPred().observe(getViewLifecycleOwner(), item -> {
            brojPred.setText(item);
        });

        pageViewModel.getBrojLv().observe(getViewLifecycleOwner(), item -> {
            brojLv.setText(item);
        });

        Button btnDalje = view.findViewById(R.id.btnDalje);
        btnDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sIme;
                String sPrezime;
                String sPredmet;
                sIme = imePrez.getText().toString();
                sPrezime = imePrez.getText().toString();
                sPredmet = predmet.getText().toString();
                System.out.println(sIme+", "+sPrezime+", "+sPredmet);
                Intent oListActivity = new Intent(getActivity(), ListActivity.class);
                DataHolder dataHolder = DataHolder.getInstance();
                dataHolder.objectList.add(new Student(sIme, sPrezime, sPredmet));
                oListActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(oListActivity);
            }
        });
    }
}