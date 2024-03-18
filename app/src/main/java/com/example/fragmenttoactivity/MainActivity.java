package com.example.fragmenttoactivity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menambahkan fragment ke container
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new HomeFragment())
                .commit();
    }

    public void receiveData(int data) {
        Log.d("Received Data", String.valueOf(data));
        // Lakukan sesuatu dengan data yang diterima
        // Contoh: Tampilkan data di log
    }

}
