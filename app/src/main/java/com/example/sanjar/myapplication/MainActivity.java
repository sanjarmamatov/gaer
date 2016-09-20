package com.example.sanjar.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.backendless.Backendless;

public class MainActivity extends AppCompatActivity {

    Button btnLogIn;
    Button btnReg;


    public final static String BACKENDLESS_APP_ID = "EED3E8D6-3EAA-CB04-FF06-1465C9B41E00";
    public final static String BACKENDLESS_SECRET_KEY = "C2AD8690-17EB-38E2-FFEC-DA1120288000";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent3 = getIntent();





        String appVersion = "v1";
        Backendless.initApp(this, BACKENDLESS_APP_ID, BACKENDLESS_SECRET_KEY, appVersion);



        btnLogIn = (Button)findViewById(R.id.login);
        btnReg = (Button)findViewById(R.id.signup);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });


        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Login.class);
                startActivity(intent2);
            }
        });

    }
}

