package com.sergiodlz.jsoupexample;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnProfessors;
    ListView lvProfessors;
    final String URL = "http://www.uninorte.edu.co/web/ingenieria-de-sistemas-y-computacion/nuestros-docentes";
    ProgressDialog mProgressDialog;

    ArrayAdapter<String> professorsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfessors = (Button) findViewById(R.id.btnProfessors);
        btnProfessors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetProfessors().execute();
            }
        });

        lvProfessors = (ListView) findViewById(R.id.lvProfessors);

    }

    private class GetProfessors extends AsyncTask<Void, Void, Void> {
        ArrayList<String> professors = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("Getting Professors");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect(URL).get();
                Elements professorsLink = document.select("a.flink");
                for (Element professor : professorsLink) {
                    professors.add(professor.text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            professorsAdapter = new ArrayAdapter<String>(
                    getBaseContext(),
                    android.R.layout.simple_list_item_1,
                    professors);
            lvProfessors.setAdapter(professorsAdapter);
            mProgressDialog.dismiss();
        }
    }
    
}
