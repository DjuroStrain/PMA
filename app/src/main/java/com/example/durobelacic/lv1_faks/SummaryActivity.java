package com.example.durobelacic.lv1_faks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
    private TextView viewImePrezime, viewDatum, viewImeProf, viewAkadGod, viewBrojPred, viewBrojLV;
    private String sIme, sPrezime, sDatum, sImeProf, sAkadGod, sBrojPred, sBrojLV;
    private  Button oBtnPocetna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oBundle = getIntent().getExtras();
        sIme = oBundle.getString("ime");
        sPrezime = oBundle.getString("prezime");
        sDatum = oBundle.getString("datum");
        sImeProf = oBundle.getString("imeProf");
        sAkadGod = oBundle.getString("akadGod");
        sBrojPred = oBundle.getString("brojPred");
        sBrojLV = oBundle.getString("brojLv");

        viewImePrezime = (TextView) findViewById(R.id.viewImePrez);
        viewDatum = (TextView) findViewById(R.id.viewDatum);
        viewImeProf = (TextView) findViewById(R.id.viewProf);
        viewAkadGod = (TextView) findViewById(R.id.viewAkaGod);
        viewBrojPred = (TextView) findViewById(R.id.viewBrojPred);
        viewBrojLV = (TextView) findViewById(R.id.viewBrojLV);

        viewImePrezime.setText(sIme+" "+sPrezime);
        viewDatum.setText(sDatum);
        viewImeProf.setText(sImeProf);
        viewAkadGod.setText(sAkadGod);
        viewBrojPred.setText(sBrojPred);
        viewBrojLV.setText(sBrojLV);

        oBtnPocetna = (Button) findViewById(R.id.btnDalje);
        oBtnPocetna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oPersonalInfoActivity = new Intent(SummaryActivity.this, PersonalInfoActivity.class);
                oPersonalInfoActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(oPersonalInfoActivity);
            }
        });
    }
}