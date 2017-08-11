package com.example.pandadesktop4.TiffinManagement.Login;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pandadesktop4.TiffinManagement.Events;
import com.example.pandadesktop4.TiffinManagement.Executor;
import com.example.pandadesktop4.TiffinManagement.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pandadesktop4 on 10/8/17.
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    Button loginButton;
    EditText usernameText,passwordText;
    List<Executor> onLoginButtonClicked = new ArrayList<>();
    private Context applicationContext;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        bindViews(view);
        initializeViews();
        return view;
    }

    private void initializeViews() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Events.fire(onLoginButtonClicked);

            }
        });
    }

    private void bindViews(View contentView) {
        loginButton = (Button)    contentView.findViewById(R.id.login_button);
        usernameText = (EditText) contentView.findViewById(R.id.user_name_editText);
        passwordText = (EditText) contentView.findViewById(R.id.password_editText);
    }

    @Override
    public LoginRequest getLoginRequest() {
        return null;
    }

    @Override
    public void whenLoginButtonClick(Executor executor) {

        onLoginButtonClicked.add(executor);
    }

    @Override
    public void saveAndLaunchHomeScreen(LoginResponse loginResponse) {
        Log.i("ABC", "Going to Next Screen");

//        Intent i = new Intent(getActivity(), MakeEntry.class);
//        startActivity(i);
    }

    @Override
    public void showLoginFailure() {
        Toast.makeText(getActivity(), "Username or password incorrect.", Toast.LENGTH_SHORT).show();

    }

}
