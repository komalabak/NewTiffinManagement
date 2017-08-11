package com.example.pandadesktop4.TiffinManagement.TiffinPreferences;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by pandadesktop4 on 27/7/17.
 */

public interface PreferenceAPI {

    @GET("/preferences")
    public void getAllPreferences(@Query("month") Integer month, @Query("year") Integer year, Callback<PreferenceListResponse> response);


    @POST("/preference")
    public void saveTiffinPreference(@Body PreferenceRequest preferenceRequest, Callback<Response> response);

}
