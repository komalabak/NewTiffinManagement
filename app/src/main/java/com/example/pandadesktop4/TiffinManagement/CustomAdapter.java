package com.example.pandadesktop4.TiffinManagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pandadesktop4.TiffinManagement.TiffinPreferences.Preference;
import com.example.pandadesktop4.TiffinManagement.TiffinPreferences.PreferenceAPI;
import com.example.pandadesktop4.TiffinManagement.TiffinPreferences.PreferenceRequest;

import java.text.SimpleDateFormat;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static com.example.pandadesktop4.TiffinManagement.R.id.checkBox;
import static com.example.pandadesktop4.TiffinManagement.R.id.txtname;


/**
 * Created by pandadesktop4 on 24/7/17.
 */
public class CustomAdapter extends ArrayAdapter<Preference> {


    Context context;
    private List<Preference> dataSet;
    private Preference preference;


    public CustomAdapter(List<Preference> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.context = context;
    }

    @Override

    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Preference getItem(int position) {
        this.preference=(Preference) dataSet.get(position);
        return (Preference) dataSet.get(position);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Preference item = getItem(position);

        final View result;
        if (convertView == null) {

//            Log.i("Position", position+"");
//            Log.i("Position item", item.toString());

            //Log.i(TAG, "index=");
            Log.v("Tag","HHHHHHHHHHHHH");
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
            fillRow(convertView, item);
            result = convertView;
        } else {
            result = convertView;
        }
        fillRow(convertView, item);
        return result;
    }

    private void fillRow(View convertView, Preference item) {
        final TextView textNameListView = (TextView) convertView.findViewById(txtname);
        final CheckBox checkBoxListView = (CheckBox) convertView.findViewById(checkBox);
        textNameListView.setText(new SimpleDateFormat("dd/MM/yyyy").format(item.date));
        checkBoxListView.setChecked(item.lunch);

        checkBoxListView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                PreferenceAPI preferenceAPI = RestClient.getAuthenticationRestAdapter().create(PreferenceAPI.class);

                preferenceAPI.saveTiffinPreference(new PreferenceRequest(textNameListView.getText().toString(), checkBoxListView.isChecked()), new Callback<Response>() {

                    @Override
                    public void success(Response loginResponse, Response response) {
                        Toast.makeText(getContext(), "Sending....", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.e("error", error.toString());
                        checkBoxListView.setChecked(!checkBoxListView.isChecked());
                        Toast.makeText(getContext(), "Something is wrong.", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

    private static class ViewHolder {
        TextView txtname;
        CheckBox checkBox;


    }
}
