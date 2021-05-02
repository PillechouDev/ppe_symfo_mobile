package com.example.ppenahim3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;

public class Historique extends AppCompatActivity {

    private TextView bottomCard;
    private TextView topCard;
    private LinearLayout mainLayout;
    private TextView exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historique);
        this.mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        this.exit = (TextView) findViewById(R.id.exit);


        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT * from injection";

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
                top.setText("Prénom et nom du patient : "+rs.getString(2)+" "+rs.getString(3));
                top.setLayoutParams(paramTop);
                mainLayout.addView(top);

                bottom.setGravity(Gravity.CENTER);
                bottom.setBackgroundResource(R.color.colorSecondary);
                paramBottom.setMargins(62,0,62,0);
                bottom.setPadding(0,14,0,14);
                bottom.setHeight(100);
                bottom.setTextColor(Color.WHITE);
                bottom.setTextSize(20);
                if (rs.getString(5).equals("1")){
                    bottom.setText("Vaccin : Pfizer"+" "+"Date d'injection: "+rs.getString(4));
                }
                if (rs.getString(5).equals("2")){
                    bottom.setText("Vaccin : Astra Zeneca"+" "+"Date d'injection: "+rs.getString(4));
                }
                if (rs.getString(5).equals("3")){
                    bottom.setText("Vaccin : Astra Zeneca"+" "+"Date d'injection: "+rs.getString(4));
                }
                if (rs.getString(5).equals("4")){
                    bottom.setText("Vaccin : Moderna"+" "+"Date d'injection: "+rs.getString(4));
                }

                bottom.setLayoutParams(paramBottom);
                mainLayout.addView(bottom);
            }


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