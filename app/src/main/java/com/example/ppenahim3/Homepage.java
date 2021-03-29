package com.example.ppenahim3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;

public class Homepage extends AppCompatActivity {

    private TextView injectionButton;
    private TextView historiqueButton;
    private TextView stockButton;

    private LinearLayout modLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);



        this.modLayout = (LinearLayout) findViewById(R.id.modMain);


        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT nom,vaccin.flacon FROM flacon_details INNER JOIN vaccin ON flacon_details.id = vaccin.id WHERE vaccin.flacon < 50";

            final ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                LinearLayout.LayoutParams paramTop = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                TextView top = new TextView(this);

                LinearLayout.LayoutParams paramBottom = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                TextView bottom = new TextView(this);

                top.setGravity(Gravity.CENTER);
                top.setBackgroundResource(R.color.colorPrimary);
                paramTop.setMargins(62,20,62,0);
                top.setPadding(0,14,0,14);
                top.setTextColor(Color.WHITE);
                top.setTextSize(20);
                top.setText("Nom du vaccin : "+rs.getString(1));
                top.setLayoutParams(paramTop);
                modLayout.addView(top);

                bottom.setGravity(Gravity.CENTER);
                bottom.setBackgroundResource(R.color.colorSecondary);
                paramBottom.setMargins(62,0,62,0);
                bottom.setPadding(0,14,0,14);
                bottom.setHeight(100);
                bottom.setTextColor(Color.WHITE);
                bottom.setTextSize(20);

                bottom.setText("Nombre de flacon restant : " + rs.getInt(2));

                bottom.setLayoutParams(paramBottom);
                modLayout.addView(bottom);
            }


        }catch (Exception e){
            e.printStackTrace();
        }


        this.injectionButton = (TextView) findViewById(R.id.injectionButton);
        injectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Injection.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.historiqueButton = (TextView) findViewById(R.id.historiqueButton);
        historiqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Historique.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.stockButton = (TextView) findViewById(R.id.stockButton);
        stockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Stock.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}