package com.example.recyclerview;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SiswaAdapter adapter;
    List<Siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        load();
    }

    public void load(){
        recyclerView = findViewById(R.id.rSiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiData() {
        siswaList = new ArrayList<Siswa>();
        siswaList.add(new Siswa("Joni", "Sidoarjo"));
        siswaList.add(new Siswa("Roni", "Sidoarjo"));
        siswaList.add(new Siswa("Budi", "Sidoarjo"));
        siswaList.add(new Siswa("Soni", "Sidoarjo"));
        siswaList.add(new Siswa("Doni", "Sidoarjo"));
        siswaList.add(new Siswa("Tonu", "Sidoarjo"));
        siswaList.add(new Siswa("Dodi", "Sidoarjo"));
        siswaList.add(new Siswa("Fali", "Sidoarjo"));
        siswaList.add(new Siswa("Gali", "Sidoarjo"));
        siswaList.add(new Siswa("Hadi", "Sidoarjo"));
        siswaList.add(new Siswa("Rafi", "Sidoarjo"));
        siswaList.add(new Siswa("Ardi", "Sidoarjo"));
        siswaList.add(new Siswa("Zaki", "Sidoarjo"));

        adapter = new SiswaAdapter(this,siswaList);
        recyclerView.setAdapter(adapter);
    }

    public void btnTambah(View view) {
        siswaList.add(new Siswa("Zaki", "Sidoarjo"));
        adapter.notifyDataSetChanged();
    }
}