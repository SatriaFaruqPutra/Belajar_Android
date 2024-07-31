package com.example.suhu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText Nilai;
    TextView Hasil;
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
        //isiSpinner();
    }
    public void load(){
        spinner = findViewById(R.id.spinner);
        Nilai = findViewById(R.id.Nilai);
        Hasil = findViewById(R.id.Hasil);
    }
    /*
    public void isiSpinner(){
        String[] isi = {"Celcius TO Reamur", "Celcius To Fahrenheit", "Celcius To Celvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,android.R.layout.simple_spinner_item,isi);
        spinner.setAdapter(adapter);
    }
    */

    public void Konversi(View view){
        String  pilihan = spinner.getSelectedItem().toString();

        if (Nilai.getText().toString().equals("")) {
            Toast.makeText(this, "Nilai Kosong", Toast.LENGTH_SHORT).show();
        } else {
            if (pilihan.equals("Celcius To Reamur")){
                cToR();
            }if (pilihan.equals("Celcius To Fahrenheit")){
                cToF();
            }if (pilihan.equals("Celcius To Kelvin")){
                cToK();
            }
        }

    }

    public void cToR () {
        double suhu = Double.parseDouble(Nilai.getText().toString());
        double hasil = (4.0/5.0) * suhu;

        Hasil.setText(hasil+"");

    }public void cToF () {
        Toast.makeText(this, "Belum Dibuat", Toast.LENGTH_SHORT).show();
    }

    public void cToK () {
        Toast.makeText(this, "Belum Dibuat", Toast.LENGTH_SHORT).show();
    }


}