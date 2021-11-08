package com.example.durobelacic.lv1_faks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class PersonalInfoActivity extends AppCompatActivity {
    private TextInputLayout oInputIme, oInputPrezime;
    private EditText oEditTextDatum;
    private Button btnDalje;
    private String sIme, sPrezime, sDatum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oInputIme = (TextInputLayout)findViewById(R.id.inputIme);
        oInputPrezime = (TextInputLayout)findViewById(R.id.inputPrez);
        oEditTextDatum = (EditText)findViewById(R.id.editTextDatum);

        btnDalje = (Button)findViewById(R.id.btnDalje);
        btnDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sIme = oInputIme.getEditText().getText().toString();
                sPrezime = oInputPrezime.getEditText().getText().toString();
                sDatum = oEditTextDatum.getText().toString();
                Intent oStudentInfoActivity = new Intent(getApplicationContext(), StudentInfoActivity.class);
                oStudentInfoActivity.putExtra("ime", sIme);
                oStudentInfoActivity.putExtra("prezime", sPrezime);
                oStudentInfoActivity.putExtra("datum", sDatum);
                startActivity(oStudentInfoActivity);
            }
        });
    }
}