package com.example.pandadesktop4.TiffinManagement.Login;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;

import com.example.pandadesktop4.TiffinManagement.R;
import com.example.pandadesktop4.TiffinManagement.RestClient;

public class LoginActivity extends AppCompatActivity  {

    Button loginButton;
    EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginFragment fragment= new LoginFragment();
        initFragment(fragment);

        LoginAPI loginAPI = RestClient.getRestAdapter().create(LoginAPI.class);
        LoginModel model = new LoginModel(loginAPI);

        LoginPresenter presenter = new LoginPresenter(fragment,model);



    }



    public void initFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }



}


