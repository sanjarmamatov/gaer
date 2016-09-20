package com.example.sanjar.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Login extends AppCompatActivity {

    EditText usernamelg;
    EditText userpasswordlg;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent2 = getIntent();

        usernamelg = (EditText)findViewById(R.id.editText3);
        userpasswordlg = (EditText)findViewById(R.id.editText4);
        loginBtn = (Button)findViewById(R.id.loginbutton);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernamelg.getText().toString();
                String password = userpasswordlg.getText().toString();

                Backendless.UserService.login(username, password, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Intent intent4 = new Intent(Login.this, Main2Activity.class);
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });
            }
        });




    }


}
