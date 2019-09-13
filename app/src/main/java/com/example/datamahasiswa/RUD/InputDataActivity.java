package com.example.datamahasiswa.RUD;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datamahasiswa.R;
import com.example.datamahasiswa.db.DatabaseHelper;
import com.example.datamahasiswa.db.MahasiswaBean;

public class InputDataActivity extends AppCompatActivity {

    EditText nomorInput;
    EditText namaInput;
    EditText tglLahirInput;
    EditText jenkelInput;
    EditText alamatInput;
    TextView textSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_data_layout);

        nomorInput = findViewById(R.id.eNo);
        namaInput = findViewById(R.id.eNama);
        tglLahirInput = findViewById(R.id.eTglLahir);
        jenkelInput = findViewById(R.id.eJenkel);
        alamatInput = findViewById(R.id.eAlamat);
        textSave = findViewById(R.id.textSimpan);

        final DatabaseHelper db = new DatabaseHelper(this);

        textSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insert(new MahasiswaBean(
                        Integer.valueOf(nomorInput.getText().toString()),
                        namaInput.getText().toString(),
                        tglLahirInput.getText().toString(),
                        jenkelInput.getText().toString(),
                        alamatInput.getText().toString()
                ));
                Toast.makeText(InputDataActivity.this , "Data Berhasil Di Input" , Toast.LENGTH_SHORT).show();


            }
        });
    }
}
