package com.example.shipra.flash_light_app;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.hardware.Camera camera=null;

    Switch sw;
    boolean isflashon = false;







    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sw = (Switch) findViewById(R.id.swith_for_flash);


        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isflashon == false) {
                    on();
                } else {
                    off();
                }

            }

        });
    }

    public void on() {
        if (isflashon == true) {
            Toast.makeText(getApplicationContext(), "Flash lifht is already On", Toast.LENGTH_SHORT).show();
        } else {

            android.hardware.Camera cam = camera.open();
            // Camera cam = camera.sh
            android.hardware.Camera.Parameters p = cam.getParameters();


            // p = Camera.cam.getParameters();
            p.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
            cam.setParameters(p);
            // cam.setParameter(p);
            isflashon = true;


        }
    }

    public void off() {

        if (isflashon == false) {
            Toast.makeText(getApplicationContext(), "Flash lifht is already OFF", Toast.LENGTH_SHORT).show();
        } else {

            android.hardware.Camera cam = camera.open();
            // Camera cam = camera.sh
            android.hardware.Camera.Parameters p = cam.getParameters();


            // p = Camera.cam.getParameters();
            p.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_OFF);
            cam.setParameters(p);
            // cam.setParameter(p);
            isflashon = true;


        }


    }
}
