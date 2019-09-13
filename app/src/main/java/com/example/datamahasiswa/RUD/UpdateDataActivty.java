package com.example.datamahasiswa.RUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datamahasiswa.DashboardActivity;
import com.example.datamahasiswa.R;
import com.example.datamahasiswa.db.DatabaseHelper;
import com.example.datamahasiswa.db.MahasiswaBean;

public class UpdateDataActivty extends AppCompatActivity {

    EditText nomorInput;
    EditText namaInput;
    EditText tglLahirInput;
    EditText jenkelInput;
    EditText alamatInput;
    TextView textSave;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_data_layout);

        nomorInput = findViewById(R.id.eNo);
        namaInput = findViewById(R.id.eNama);
        tglLahirInput = findViewById(R.id.eTglLahir);
        jenkelInput = findViewById(R.id.eJenkel);
        alamatInput = findViewById(R.id.eAlamat);
        textSave = findViewById(R.id.textUpdate);
        context = this;

        MahasiswaBean bean = getIntent().getParcelableExtra("mahasiswa");
        nomorInput.setText(bean.getIdMahasiswa()+"");
        namaInput.setText(bean.getNama());
        tglLahirInput.setText(bean.getTglLahir());
        jenkelInput.setText(bean.getJenKel());
        alamatInput.setText(bean.getAlamat());

        textSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(context);
                db.update(new MahasiswaBean(
                        Integer.valueOf(nomorInput.getText().toString()),
                        namaInput.getText().toString(),
                        tglLahirInput.getText().toString(),
                        jenkelInput.getText().toString(),
                        alamatInput.getText().toString()
                ));
                Toast.makeText(UpdateDataActivty.this , "Data Berhasil Di Input" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
