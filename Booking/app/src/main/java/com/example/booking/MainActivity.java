package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
     public void hacerTransaccion(Fragment frag){
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,frag).addToBackStack(null).commit();
    }

}