package com.example.pandadesktop4.TiffinManagement.TiffinPreferences;

//import android.icu.util.Calendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pandadesktop4.TiffinManagement.CustomAdapter;
import com.example.pandadesktop4.TiffinManagement.R;
import com.example.pandadesktop4.TiffinManagement.RestClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PreferenceEntry extends AppCompatActivity {

    private Integer current_month;
    private List<Preference> currentMonthPreferences;
    private Integer current_year;
    ListView currentMonthPreferencesView;
    Button goToNextMonth, gotToPreviousMonth;
    TextView currentMonthLabel;
    private CustomAdapter adapter;


    private void initializePreferences(Integer month, Integer year) {
        this.current_month = month;
        this.current_year = year;
        this.currentMonthPreferences = new ArrayList<>();

        List<Date> dates = Util.getDatesForMonth(month, year);
        for (Date date : dates) {
            currentMonthPreferences.add(new Preference(date, false));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_entry);
        currentMonthPreferencesView = (ListView) findViewById(R.id.listView);
        goToNextMonth = (Button) findViewById(R.id.nextbutton);
        gotToPreviousMonth = (Button) findViewById(R.id.previousbutton);
        currentMonthLabel = (TextView) findViewById(R.id.monthtext);



        Date today = new Date();
        reload(today.getMonth(), today.getYear());

    }

    private void reload(Integer month, Integer year) {
        initializePreferences(month, year); // TODO get month and year from intent

        Log.i("Preferences", currentMonthPreferences.size() +"");

        currentMonthLabel.setText(new SimpleDateFormat("MMMMMMMM").format(Util.getDate(month, year)));
        PreferenceAPI api = RestClient.getAuthenticationRestAdapter().create(PreferenceAPI.class);
//        call();
        api.getAllPreferences(month + 1, year + 1900, new Callback<PreferenceListResponse>() {
            @Override
            public void success(PreferenceListResponse preferenceListResponse, Response response) {

                for (PreferenceResponse preferenceResponse : preferenceListResponse.getPreferences()) {
                   for (Preference preference : currentMonthPreferences) {
                        if (preferenceResponse.getDate().equals(new SimpleDateFormat("dd/MM/yyyy").format(preference.date))) {
                            preference.lunch = preferenceResponse.getLunch();
                       }
                    }
                }
                call();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "Error.", Toast.LENGTH_SHORT).show();
            }
        });

        goToNextMonth.setOnClickListener(view -> {
            if (current_month > 12) {
                reload(0, current_year + 1);
            } else {
                reload(current_month + 1, current_year);
            }
        });

        gotToPreviousMonth.setOnClickListener(view -> {
            if (current_month < 0) {
                reload(11, current_year - 1);
            } else {
                reload(current_month - 1, current_year);
            }
        });
    }


    public void call() {
        this.adapter = new CustomAdapter(currentMonthPreferences, getApplicationContext());
        currentMonthPreferencesView.setAdapter(adapter);
    }

}





