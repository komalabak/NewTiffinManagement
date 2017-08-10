package com.example.pandadesktop4.TiffinManagement.Login;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pandadesktop4.TiffinManagement.R;

/**
 * Created by pandadesktop4 on 10/8/17.
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    Button loginButton;
    EditText usernameText,passwordText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        bindViews(view);
        return view;
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
}
