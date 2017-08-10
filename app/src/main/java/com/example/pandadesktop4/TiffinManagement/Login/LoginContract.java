package com.example.pandadesktop4.TiffinManagement.Login;

/**
 * Created by pandadesktop4 on 10/8/17.
 */

public interface LoginContract {


    interface View
    {


        LoginRequest getLoginRequest();

    }
    interface Model
    {


        void requestLoginToServer(LoginRequest loginRequest);
    }
}
