package com.example.pandadesktop4.TiffinManagement.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.pandadesktop4.TiffinManagement.R;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();

    }

    private void bindViews() {
        loginButton = (Button) findViewById(R.id.login_button);
        usernameText = (EditText) findViewById(R.id.user_name_editText);
        passwordText = (EditText) findViewById(R.id.password_editText);
    }
}


