package com.example.fragmenttoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private Button button1, button2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToActivity(1); // Mengirim data 1 ke activity
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToActivity(2); // Mengirim data 2 ke activity
            }
        });

        return view;
    }

    // Metode untuk mengirim data ke activity
    private void sendDataToActivity(int data) {
        // Menggunakan Intent untuk mengirim data ke activity
        Intent intent = new Intent(getActivity(), SecondActivity.class);
        intent.putExtra("key", data); // Mengirim data dengan key tertentu
        startActivity(intent);
    }

}
