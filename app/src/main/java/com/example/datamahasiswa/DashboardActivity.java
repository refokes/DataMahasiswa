package com.example.datamahasiswa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.datamahasiswa.RUD.InputDataActivity;

public class DashboardActivity extends AppCompatActivity {
    Button btnLihatData,btnInputData,btnInformasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        btnLihatData = (Button)findViewById(R.id.btnLihatData);
        btnLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this,ListDataActivity.class));
            }
        });
        btnInputData=(Button)findViewById(R.id.btnInputData);
        btnInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, InputDataActivity.class));
            }
        });
        Button btnInformasi = (Button)findViewById(R.id.btnInformasi);
        btnInformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View v = inflater.inflate(R.layout.informasi_layout, null);
                builder.setView(v);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });


    }
}
