package com.example.durobelacic.lv1_faks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentInfoActivity extends AppCompatActivity {
    private EditText oEditTextImeProf;
    private EditText oEditTextAkadGod;
    private EditText oEditTextBrojPred;
    private EditText oEditTextBrojLV;
    private EditText oEditTextPredmet;
    private Button oBtnDalje;
    private String sIme;
    private String sPrezime;
    private String sDatum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        final Bundle oBundle = getIntent().getExtras();
        sIme = oBundle.getString("ime");
        sPrezime = oBundle.getString("prezime");
        sDatum = oBundle.getString("datum");

        oEditTextImeProf = (EditText) findViewById(R.id.editTextImeProf);
        oEditTextAkadGod = (EditText) findViewById(R.id.editTextAkadGod);
        oEditTextBrojPred = (EditText) findViewById(R.id.editTextPred);
        oEditTextBrojLV = (EditText) findViewById(R.id.editTextLv);
        oEditTextPredmet = (EditText) findViewById(R.id.editTextPredmet);


        oBtnDalje = (Button) findViewById(R.id.btnDalje);
        oBtnDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oSummaryActivty = new Intent(getApplicationContext(), SummaryActivity.class);
                oSummaryActivty.putExtra("ime", sIme);
                oSummaryActivty.putExtra("prezime", sPrezime);
                oSummaryActivty.putExtra("datum", sDatum);
                oSummaryActivty.putExtra("imeProf", oEditTextImeProf.getText().toString());
                oSummaryActivty.putExtra("akadGod", oEditTextAkadGod.getText().toString());
                oSummaryActivty.putExtra("brojPred", oEditTextBrojPred.getText().toString());
                oSummaryActivty.putExtra("brojLv", oEditTextBrojLV.getText().toString());
                oSummaryActivty.putExtra("predmet", oEditTextPredmet.getText().toString());
                startActivity(oSummaryActivty);
            }
        });
    }
}