package com.example.alex.ovenui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //main activity contol buttons
        final Button door = (Button) findViewById(R.id.doorId);
        final Button stngs = (Button) findViewById(R.id.manualId);
        final Button auto = (Button) findViewById(R.id.autoId);
        final Button alert = (Button) findViewById(R.id.alertId);

        //listeners who control the button actions of the main actovity

        stngs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SettingsActivity.class));
            }
        });

        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AutoActivity.class));
            }
        });
        /*
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EmergencyActivity.class));
            }
        });*/
    }
}
