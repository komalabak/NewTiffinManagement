package com.example.pandadesktop4.TiffinManagement.Login;

import com.example.pandadesktop4.TiffinManagement.Executor;

/**
 * Created by pandadesktop4 on 10/8/17.
 */

public interface LoginContract {


    interface View
    {


        LoginRequest getLoginRequest();

        void whenLoginButtonClick(Executor executor);
    }
    interface Model
    {


        void requestLoginToServer(LoginRequest loginRequest);
    }
}
