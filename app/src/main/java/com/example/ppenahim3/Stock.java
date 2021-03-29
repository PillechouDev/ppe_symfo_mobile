package com.example.ppenahim3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;

public class Stock extends AppCompatActivity {
    private TextView stockPfizer;
    private TextView namePfizer;
    private TextView nameModerna;
    private TextView nameAstra8;
    private TextView nameAstra10;
    private TextView stockAstra8;
    private TextView stockAstra10;
    private TextView stockModerna;
    private TextView exit;
    private TextView modStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock);
        this.stockPfizer = (TextView) findViewById(R.id.stockPfizer);
        this.namePfizer = (TextView) findViewById(R.id.namePfizer);
        this.nameModerna = (TextView) findViewById(R.id.nameModerna);
        this.nameAstra8 = (TextView) findViewById(R.id.nameAstra8);
        this.nameAstra10 = (TextView) findViewById(R.id.nameAstra10);
        this.stockAstra8 = (TextView) findViewById(R.id.stockAstra8);
        this.stockAstra10 = (TextView) findViewById(R.id.stockAstra10);
        this.stockModerna = (TextView) findViewById(R.id.stockModerna);
        this.exit = (TextView) findViewById(R.id.exit);
        this.modStock = (TextView) findViewById(R.id.ajouter);

        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();


            String SQL2 = "SELECT doses from flacon_details WHERE id = 3";
            ResultSet rs2= st.executeQuery(SQL2);
            rs2.next();
            String result = "Astra Zeneca - "+rs2.getString(1)+" doses";
            nameAstra8.setText(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();


            String SQL2 = "SELECT doses from flacon_details WHERE id = 4";
             ResultSet rs2= st.executeQuery(SQL2);
            rs2.next();
            String result ="Moderna - "+rs2.getString(1)+" doses";
            nameModerna.setText(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL2 = "SELECT doses from flacon_details WHERE id = 1";
             ResultSet rs2= st.executeQuery(SQL2);
            rs2.next();
            String result = "Pfizer - "+rs2.getString(1)+" doses";
            namePfizer.setText(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();


            String SQL2 = "SELECT doses from flacon_details WHERE id = 2";
             ResultSet rs2= st.executeQuery(SQL2);
            rs2.next();
            String result = "Astra Zeneca - "+rs2.getString(1)+" doses";
            nameAstra10.setText(result);

        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT flacon from vaccin WHERE id = 1";
            ResultSet rs = st.executeQuery(SQL);

            rs.next();
            int result = rs.getInt(1);
            stockPfizer.setText("Flacons: "+result);


        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT flacon from vaccin WHERE id = 2";

             ResultSet rs = st.executeQuery(SQL);
            rs.next();
            stockAstra8.setText("Flacons : " + rs.getInt(1));


        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT flacon from vaccin WHERE id = 3";

             ResultSet rs = st.executeQuery(SQL);
            rs.next();
            stockAstra10.setText("Flacons : " +rs.getInt(1));


        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT flacon from vaccin WHERE id = 4";

             ResultSet rs = st.executeQuery(SQL);
            rs.next();
            stockModerna.setText("Flacons : "+rs.getInt(1));


        }catch (Exception e){
            e.printStackTrace();
        }

        modStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ModStock.class);
                startActivity(otherActivity);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Homepage.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}