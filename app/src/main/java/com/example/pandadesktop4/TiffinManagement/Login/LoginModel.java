package com.example.pandadesktop4.TiffinManagement.Login;

import android.util.Log;

/**
 * Created by pandadesktop4 on 10/8/17.
 */

public class LoginModel implements LoginContract.Model {


    @Override
    public void requestLoginToServer(LoginRequest loginRequest) {
        Log.i("ABC","Calling to server");
    }
}
