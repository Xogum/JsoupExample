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

import com.sergiodlz.jsoupexample.Entities.Categoria;
import com.sergiodlz.jsoupexample.Entities.Pregrado;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button btnProfessors;
    ListView lvProfessors;
    final String URL_PROFESSORS = "http://www.uninorte.edu.co/web/ingenieria-de-sistemas-y-computacion/nuestros-docentes";
    final String URL_CARRERAS = "http://www.uninorte.edu.co/carreras";
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
                Document document = Jsoup.connect(URL_PROFESSORS).get();
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

    private class GetCarreras extends AsyncTask<Void, Void, Void> {
        ArrayList<Pregrado> Pregrados = new ArrayList<>();
        ArrayList<Categoria> Categorias = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("Opteniendo Pregrados");
            mProgressDialog.setMessage("Espere...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect(URL_CARRERAS).get();
                Elements categorias = document.select("div.panel-heading");
                int cont = 1;
                for (Element categoria : categorias) {
                    Categoria cPregrados = new Categoria();
                    cPregrados.Id = cont;
                    cPregrados.Nombre = categoria.text();
                    Set<String> clases = categoria.classNames();
                    Object[] cs = clases.toArray();
                    cPregrados.Color = cs.toString();
                    Categorias.add(cPregrados);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            mProgressDialog.dismiss();
        }
    }
    
}
