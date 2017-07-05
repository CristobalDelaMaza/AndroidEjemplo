package com.example.allan.estructurasdecontrol;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnControls = (Button) findViewById(R.id.btnControls);
        btnControls.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick ( View arg0){
               seleccionarPantallas(1);
           }
        });

        Button btnBars = (Button) findViewById(R.id.btnBars);
        btnBars.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick ( View arg0){
                seleccionarPantallas(3);
            }
        });
    }

    public void seleccionarPantallas(int num){
        Intent activity = null;
        switch (num){
            case 1:
                activity = new Intent(getApplicationContext(), BasicControlActivity.class);
                startActivity(activity);
                break;
            case 3:
                activity = new Intent(getApplicationContext(), ActionBarActivity.class);
                startActivity(activity);
                break;
        }
    }
}
