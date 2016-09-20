package com.example.sanjar.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Register extends AppCompatActivity {

    EditText eTname;
    EditText eTpassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intent = getIntent();

        eTname = (EditText)findViewById(R.id.editText);
        eTpassword = (EditText)findViewById(R.id.editText2);
        btnRegister = (Button) findViewById(R.id.register);

        btnRegister.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String username = eTname.getText().toString();
                String password = eTpassword.getText().toString();

                BackendlessUser backendlessUser = new BackendlessUser();
                backendlessUser.setPassword(password);
                backendlessUser.setProperty("name", username);
                Backendless.UserService.register(backendlessUser, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {

                        Toast toast = Toast.makeText(Register.this,"Вы успешно зарегистрировались", Toast.LENGTH_SHORT);
                        toast.show();
                      // Toast.makeText(getActivity(), "You registered!", Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void handleFault(BackendlessFault fault) {
                    //  Toast.makeText(getActivity(), "User not registered!", Toast.LENGTH_SHORT).show();

                    }


                });
            }

        });



    }
}
