package com.example.rashikbariya.notice;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Welcome extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        listView = (ListView) findViewById(R.id.listView);
        getJSON("https://b-rashik.000webhostapp.com/showdata.php");
    }

    private void getJSON(final String urlWebService) {
        class GetJSON extends AsyncTask<Void,Void,String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... voids) {
                return null;
            }
        }
    }


}
