package com.example.durobelacic.lv1_faks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private String sImePrezime;
    private String sKolegij;
    private TextView textViewImePrez;
    private TextView textViewKolegij;
    private Button btnPocetna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        textViewImePrez = (TextView) findViewById(R.id.textViewImePrez);
        textViewKolegij = (TextView) findViewById(R.id.editTextKolegij2);

        final Bundle oBundle = getIntent().getExtras();
        sImePrezime = oBundle.getString("imePrezime");
        textViewImePrez.setText(sImePrezime);;
        sKolegij = oBundle.getString("kolegij");
        textViewKolegij.setText(sKolegij);

        btnPocetna = (Button)findViewById(R.id.btnPocetna);
        btnPocetna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PeronalInfo = new Intent(getApplicationContext(), PersonalInfoActivity.class);
                PeronalInfo.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(PeronalInfo);
            }
        });
    }
}