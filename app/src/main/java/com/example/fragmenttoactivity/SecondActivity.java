package com.example.fragmenttoactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmenttoactivity.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;
    private int receivedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] activeName = null;
        int[] activeImages = null;

        String[] flowerName = {"a", "b", "c", "d", "e", "f"};
        int[] flowerImages = {R.drawable.a, R.drawable.b, R.drawable.c,
                R.drawable.d, R.drawable.e, R.drawable.f};

        String[] animalName = {"aa", "bb", "cc", "dd", "ee", "ff"};
        int[] animalImages = {R.drawable.aa, R.drawable.bb, R.drawable.cc,
                R.drawable.dd, R.drawable.ee, R.drawable.ff};

        // Menerima nilai data dari aktivitas lain
        receivedData = receiveData();

        // Menetapkan data yang sesuai berdasarkan nilai yang diterima
        if (receivedData == 2) {
            activeName = animalName;
            activeImages = animalImages;
        } else if (receivedData == 1) {
            activeName = flowerName;
            activeImages = flowerImages;
        }

        final String[] finalActiveName = activeName; // Jadikan final atau effectively final
        final int[] finalActiveImages = activeImages; // Jadikan final atau effectively final

        // Memastikan data yang diterima tidak null sebelum ditampilkan di grid
        if (finalActiveName != null && finalActiveImages != null) {
            GridAdapter gridAdapter = new GridAdapter(SecondActivity.this, finalActiveName, finalActiveImages);
            binding.gridView.setAdapter(gridAdapter);
        }

        // Menambahkan event click pada item grid
        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (finalActiveName != null) {
                    Toast.makeText(SecondActivity.this, "You Click On " + finalActiveName[position], Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Metode untuk menerima data dari aktivitas lain
    private int receiveData() {
        // Dapatkan nilai yang dikirim dari aktivitas lain, atau gantilah dengan cara yang sesuai
        int data = getIntent().getIntExtra("key", 0); // Ubah 'key' dengan key yang benar
        return data;
    }
}
