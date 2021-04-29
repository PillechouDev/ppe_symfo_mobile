package com.example.ppenahim3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView loginButton;
    private static EditText user, pass;
    private static  AccesDistant accesDistant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.loginButton = (TextView) findViewById(R.id.loginButton);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connexion();
            }
        });

    }
    private void connexion(){

        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT password from user WHERE username = '"+user.getText().toString()+"'";

            final ResultSet rs = st.executeQuery(SQL);
            rs.next();

            if(rs.getString(1).equals(pass.getText().toString())){
                NextActivity();
            }


        }catch (Exception e){

        }
        /*

        accesDistant = new AccesDistant();
        List laListe = new ArrayList();
        laListe.add(user);
        */

    }


    private void NextActivity(){
        Intent otherActivity = new Intent(getApplicationContext(), Homepage.class);
        startActivity(otherActivity);
        finish();
    }
}