package com.example.pandadesktop4.TiffinManagement.Login;

import android.util.Log;

import com.example.pandadesktop4.TiffinManagement.Events;
import com.example.pandadesktop4.TiffinManagement.Executor;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by pandadesktop4 on 10/8/17.
 */

public class LoginModel implements LoginContract.Model {


    private final LoginAPI loginAPI;
    List<Executor> onLoginButtonSuccess = new ArrayList<>();
    List<Executor> onLoginButtonFailuare = new ArrayList<>();
    private LoginResponse loginResponse;

    public LoginModel(LoginAPI loginAPI) {
        this.loginAPI = loginAPI;
    }


    @Override
    public void requestLoginToServer(LoginRequest loginRequest) {


        loginAPI.login(loginRequest, new Callback<LoginResponse>() {


            @Override
            public void success(LoginResponse serverResponse, Response response) {
                loginResponse = serverResponse;
                Events.fire(onLoginButtonSuccess);


            }

            @Override
            public void failure(RetrofitError error) {
                Events.fire(onLoginButtonFailuare);

            }
        });

        Log.i("ABC", "Calling to server");

    }

    @Override
    public LoginResponse getLoginResponse() {
        return loginResponse;
    }

    @Override
    public void whenLoginSuccess(Executor executor) {
        onLoginButtonSuccess.add(executor);
        Log.i("ABC", "Going to Next Screen");

    }

    @Override
    public void whenLoginFailure(Executor executor) {
        onLoginButtonFailuare.add(executor);
    }
}

