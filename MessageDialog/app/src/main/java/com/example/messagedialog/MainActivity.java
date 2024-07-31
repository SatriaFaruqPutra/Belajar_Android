package com.example.messagedialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

    }

    public void showToast (String pesan) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    public void showAlert (String pesan) {
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("PERHATIAN");
        buatAlert.setMessage(pesan);

        buatAlert.show();
    }

    public void showDialog(String pesan) {
        AlertDialog.Builder showDialog = new AlertDialog.Builder(this);
        showDialog.setTitle("PEMBERITAHUAN");
        showDialog.setMessage(pesan);

        showDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("Data Sudah Masuk");
            }
        });
        showDialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("Data Tidak Masuk");
            }
        });
        showDialog.show();
    }

    public void btnToast (View view) {
        showToast("Belajar Membuat Pesan");
    }
    
    public void btnAlert (View view) {
        showAlert("Silahkan Dicoba");
    }

    public void btnDialog (View view) {
        showDialog("Apakah Sudah Masuk?");
    }
}