package com.example.booking;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class HacerReservaFragment extends Fragment {
    private EditText nombre;
    private EditText correo;
    private Spinner horainicial;
    private Spinner horafinal;
    private Button reservar;
    private Restaurante act;

    public void setAct(Restaurante act) {
        this.act = act;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hacer_reserva, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button volver = getView().findViewById(R.id.volver);
        volver.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });

        populateSpinnners();
        nombre = getView().findViewById(R.id.nombre);
        correo = getView().findViewById(R.id.correo);
        reservar = getView().findViewById(R.id.reservar);
        reservar.setOnClickListener(v -> {
            hacerReserva();
        });
    }

    public void populateSpinnners() {

        horainicial = getView().findViewById(R.id.horaInicial);
        horafinal = getView().findViewById(R.id.horaFinal);
        List<String> list = new ArrayList<String>();
        for (int i = 14; i < 22; i++) {
            for (int j = 0; j < 4; j++) {
                if (j != 0) {
                    list.add(i + ":" + (15 * j));
                } else {
                    list.add(i + ":00");
                }
            }
        }
        List<String> list2 = new ArrayList<String>();
        for (int i = 14; i < 22; i++) {
            for (int j = 0; j < 4; j++) {
                if (j != 0) {
                    list2.add(i + ":" + (15 * j));
                } else {
                    if(i!=14){list2.add(i + ":00");}
                }
            }
        }


        ArrayAdapter<String> adp1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);
        ArrayAdapter<String> adp2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list2);
        horainicial.setAdapter(adp1);

        horafinal.setAdapter(adp2);

    }

    public void hacerReserva() {
        String tnombre = nombre.getText().toString();
        String tcorreo = correo.getText().toString();



        if ((!tnombre.matches("")) && (!tcorreo.matches("")) && android.util.Patterns.EMAIL_ADDRESS.matcher(tcorreo).matches()) {
           createNotificationChannel();
            String contenidoReserva="Hora: "+horainicial.getSelectedItem().toString()+" - "+horafinal.getSelectedItem().toString()+"\nEn el restaurante: "+act.getNombre()+"\nPagina del restaurante: "+act.getPaginaWeb() ;


            NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "MyNotification")
                    .setSmallIcon(R.mipmap.ic_launcher_foreground)
                    .setContentTitle("Reserva realizada!")
                    .setContentText("A nombre de "+tnombre)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(contenidoReserva))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getContext());


            if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            managerCompat.notify(1, builder.build());

        }
        else{

            Toast.makeText(getActivity(), "Todos los campos son obligatorios", Toast.LENGTH_LONG).show();
        }
    }
        private void createNotificationChannel() {      //este metodo venia en la documentacion de android
            // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("MyNotification", "reserva", importance);
            channel.setDescription("reserva realizada");

            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


}