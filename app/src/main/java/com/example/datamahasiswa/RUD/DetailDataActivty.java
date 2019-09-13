package com.example.datamahasiswa.RUD;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.datamahasiswa.R;
import com.example.datamahasiswa.db.MahasiswaBean;

public class DetailDataActivty extends AppCompatActivity {

    EditText nomorInput;
    EditText namaInput;
    EditText tglLahirInput;
    EditText jenkelInput;
    EditText alamatInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_data_layout);

        nomorInput = findViewById(R.id.eNo);
        namaInput = findViewById(R.id.eNama);
        tglLahirInput = findViewById(R.id.eTglLahir);
        jenkelInput = findViewById(R.id.eJenkel);
        alamatInput = findViewById(R.id.eAlamat);

        MahasiswaBean bean = getIntent().getParcelableExtra("mahasiswa");

        nomorInput.setText(bean.getIdMahasiswa()+"");
        namaInput.setText(bean.getNama());
        tglLahirInput.setText(bean.getTglLahir());
        jenkelInput.setText(bean.getJenKel());
        alamatInput.setText(bean.getAlamat());
    }
}
