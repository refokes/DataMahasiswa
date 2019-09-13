package com.example.datamahasiswa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.datamahasiswa.RUD.DetailDataActivty;
import com.example.datamahasiswa.RUD.UpdateDataActivty;
import com.example.datamahasiswa.adapter.Adapter;
import com.example.datamahasiswa.db.DatabaseHelper;
import com.example.datamahasiswa.db.MahasiswaBean;

import java.util.List;

public class ListDataActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CharSequence[] dialogItems = {"Lihat Data","Update Data", "Delete Data"};
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_data_layout);
        recyclerView = findViewById(R.id.recycler_list_data);

        final DatabaseHelper db = new DatabaseHelper(this);
        List<MahasiswaBean> beanList = db.selectUserData();
        final Adapter adapter = new Adapter(beanList);

        adapter.setListener(new Adapter.Listener() {
            @Override
            public void onClick(int position) {
                gotoDetailActivity(recyclerView, position);
            }
        });
        adapter.setLongClickListener(new Adapter.Listener() {
            @Override
            public void onClick(final int position) {
                new AlertDialog.Builder(context)
                        .setTitle("Pilihan")
                        .setItems(dialogItems, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch(i) {
                                    case 0:
                                        gotoDetailActivity(recyclerView, position);
                                        break;
                                    case 1:
                                        gotoUpdateActivity(recyclerView, position);
                                        break;
                                    case 2:
                                        Adapter.ViewHolder v = (Adapter.ViewHolder) recyclerView.findViewHolderForLayoutPosition(position);
                                        db.delete(Integer.valueOf(v.bean.getIdMahasiswa()));
                                        Toast.makeText(ListDataActivity.this , "Data Berhasil Delete Silahkan Refresh" , Toast.LENGTH_SHORT).show();

                                        break;

                                }
                            }
                        })
                        .show();
            }
        });

        final LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private void gotoDetailActivity(RecyclerView recyclerView, int position) {
        Adapter.ViewHolder v = (Adapter.ViewHolder) recyclerView.findViewHolderForLayoutPosition(position);
        Intent intent = new Intent(ListDataActivity.this, DetailDataActivty.class);
        intent.putExtra("mahasiswa", v.bean);
        startActivity(intent);
    }
    private void gotoUpdateActivity(RecyclerView recyclerView, int position) {
        Adapter.ViewHolder v = (Adapter.ViewHolder) recyclerView.findViewHolderForLayoutPosition(position);
        Intent intent = new Intent(ListDataActivity.this, UpdateDataActivty.class);
        intent.putExtra("mahasiswa", v.bean);
        startActivity(intent);
    }
}
