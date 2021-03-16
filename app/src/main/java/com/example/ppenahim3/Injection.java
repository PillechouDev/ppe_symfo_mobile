package com.example.ppenahim3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Injection extends AppCompatActivity {
    private TextView surnamePatient;
    private TextView namePatient;
    private TextView date;
    private RadioGroup vaccin;
    private TextView programmInjection;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.injection);
        this.surnamePatient = (TextView) findViewById(R.id.surnamePatient);
        this.namePatient = (TextView) findViewById(R.id.namePatient);
        this.date = (TextView) findViewById(R.id.date);
        this.vaccin = (RadioGroup) findViewById(R.id.vaccin);
        this.programmInjection = (TextView) findViewById(R.id.programmInjection);


        programmInjection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String surname = surnamePatient.getText().toString();
                final String name = namePatient.getText().toString();
                int selectedId = vaccin.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String radioText = radioButton.getText().toString();
                if(radioText.equals("Pfizer")){
                    try {
                        Fonctions fonc = new Fonctions();
                        Statement st = fonc.connexionSQLBDD();


                        String SQL = "INSERT INTO `injection` (`IdInjection`, `prenomPatient`, `nomPatient`, `dateInjection`, `IdVaccin`) VALUES (NULL, '"+surname+"', '"+name+"', '2021-03-14 14:00:00', '1')";

                        st.executeUpdate(SQL);
                        redirect();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(radioText.equals("Astra Zeneca")){
                    try {
                        Fonctions fonc = new Fonctions();
                        Statement st = fonc.connexionSQLBDD();


                        String SQL = "INSERT INTO `injection` (`IdInjection`, `prenomPatient`, `nomPatient`, `dateInjection`, `IdVaccin`) VALUES (NULL, '"+surname+"', '"+name+"','2021-03-14 14:00:00', '2')";

                        st.executeUpdate(SQL);
                        redirect();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(radioText.equals("Moderna")){
                    try {
                        Fonctions fonc = new Fonctions();
                        Statement st = fonc.connexionSQLBDD();


                        String SQL = "INSERT INTO `injection` (`IdInjection`, `prenomPatient`, `nomPatient`, `dateInjection`, `IdVaccin`) VALUES (NULL, '"+surname+"', '"+name+"', '2021-03-14 14:00:00', '3')";

                        st.executeUpdate(SQL);
                        redirect();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    redirect();
                }
            }
        });
    }
    private void redirect(){
        Intent otherActivity = new Intent(getApplicationContext(), Homepage.class);
        startActivity(otherActivity);
        finish();
    };
}