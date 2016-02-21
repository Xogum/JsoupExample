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

    Button btnProfessors, btnCategorias, btnPregrados;
    ListView lvProfessors;
    final String URL_PROFESSORS = "http://www.uninorte.edu.co/web/ingenieria-de-sistemas-y-computacion/nuestros-docentes";
    final String URL_CARRERAS = "http://www.uninorte.edu.co/carreras";
    ProgressDialog mProgressDialog;

    ArrayAdapter<String> professorsAdapter;
    ArrayAdapter<Categoria> categoriasAdapter;

    ArrayList<Categoria> Categorias = new ArrayList<>();
    ArrayList<String> scategorias = new ArrayList<>();
    ArrayList<Pregrado> Pregrados = new ArrayList<>();
    ArrayList<String> spregrados = new ArrayList<>();

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

        btnCategorias = (Button) findViewById(R.id.btnCategorias);
        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetCarreras().execute();
            }
        });

        btnPregrados = (Button) findViewById(R.id.btnPregrados);
        btnPregrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professorsAdapter = new ArrayAdapter<String>(
                        getBaseContext(),
                        android.R.layout.simple_list_item_1,
                        spregrados);
                lvProfessors.setAdapter(professorsAdapter);
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

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("Obteniendo Categorias");
            mProgressDialog.setMessage("Espere...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect(URL_CARRERAS).get();
                Elements carreras = document.select("div.panel.panel-default");
                int contC = 1, contP = 1;
                for (Element c : carreras) {
                    //Obteniendo las categorias
                    Elements categorias = c.select("div.panel-heading");
                    Element categoria = categorias.first();
                    Categoria cPregrados = new Categoria();
                    cPregrados.Id = contC; contC++;
                    cPregrados.Nombre = categoria.text();
                    Set<String> clases = categoria.classNames();
                    String[] clas = clases.toArray(new String[clases.size()]);
                    cPregrados.Color = clas[1];
                    Categorias.add(cPregrados);
                    scategorias.add(cPregrados.Nombre);

                    //Obteniendo los pregrados de cada categoria
                    Elements pregrados =  c.select("p.desc");
                    for (Element p : pregrados) {
                        Pregrado pregrado = new Pregrado();
                        pregrado.Id = contP; contP++;
                        pregrado.Categoria = cPregrados;
                        pregrado.Nombre = p.text();
                        pregrado.Url = p.child(0).attr("href");
                        Pregrados.add(pregrado);
                        spregrados.add(pregrado.Nombre);
                    }
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
                    scategorias);
            lvProfessors.setAdapter(professorsAdapter);
            mProgressDialog.dismiss();
        }
    }


    
}
