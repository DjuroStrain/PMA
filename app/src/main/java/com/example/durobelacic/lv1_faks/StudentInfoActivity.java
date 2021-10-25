package com.example.durobelacic.lv1_faks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentInfoActivity extends AppCompatActivity {
    private EditText oInputKolegij;
    private Button oBtnUpisi;
    private String sImePrezime;
    private String sKolegij;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        oInputKolegij = (EditText) findViewById(R.id.editTextKolegij);

        final Bundle oBundle = getIntent().getExtras();
        sImePrezime = oBundle.getString("imePrezime");

        oBtnUpisi = (Button) findViewById(R.id.btnUpisi);
        oBtnUpisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sKolegij = oInputKolegij.getText().toString();
                Intent oSummaryActivity = new Intent(getApplicationContext(), SummaryActivity.class);
                oSummaryActivity.putExtra("imePrezime", sImePrezime);
                oSummaryActivity.putExtra("kolegij", sKolegij);
                startActivity(oSummaryActivity);
            }
        });
    }
}