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
    private TextView stockAstra;
    private TextView stockModerna;
    private TextView exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock);
        this.stockPfizer = (TextView) findViewById(R.id.stockPfizer);
        this.stockAstra = (TextView) findViewById(R.id.stockAstra);
        this.stockModerna = (TextView) findViewById(R.id.stockModerna);
        this.exit = (TextView) findViewById(R.id.exit);

        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT dose from vaccin WHERE nom = 'Pfizer'";

            final ResultSet rs = st.executeQuery(SQL);
            rs.next();
            stockPfizer.setText(rs.getString(1));


        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT dose from vaccin WHERE nom = 'Astra Zeneca'";

            final ResultSet rs = st.executeQuery(SQL);
            rs.next();
            stockAstra.setText(rs.getString(1));


        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT dose from vaccin WHERE nom = 'Moderna'";

            final ResultSet rs = st.executeQuery(SQL);
            rs.next();
            stockModerna.setText(rs.getString(1));


        }catch (Exception e){
            e.printStackTrace();
        }

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