package com.example.pandadesktop4.TiffinManagement.Login;


import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;


public interface LoginAPI {
    @POST("/login")
    public void login(@Body LoginRequest loginRequest, Callback<ServerResponse> response);
}
