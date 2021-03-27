package com.example.ppenahim3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.RestrictionsManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Injection extends AppCompatActivity {
    private TextView surnamePatient;
    private TextView namePatient;
    private DatePicker date;
    private RadioGroup vaccin;
    private TextView programmInjection;
    private RadioButton radioButton;
    private Spinner medecin;
    private Object AdapterView;
    String[] medecins = {"Axel", "Romain", "Yohan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.injection);

        this.surnamePatient = (TextView) findViewById(R.id.surnamePatient);
        this.namePatient = (TextView) findViewById(R.id.namePatient);
        this.date = (DatePicker) findViewById(R.id.date);
        this.vaccin = (RadioGroup) findViewById(R.id.vaccin);
        this.programmInjection = (TextView) findViewById(R.id.programmInjection);
        this.medecin = (Spinner) findViewById(R.id.medecin);


        medecin.setOnItemSelectedListener((android.widget.AdapterView.OnItemSelectedListener) this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, medecins);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medecin.setAdapter(adapter);

        //try {
          //  Fonctions fonc = new Fonctions();
            //Statement st = fonc.connexionSQLBDD();

            //String SQL = "SELECT medecin from medecin";

            //final ResultSet rs = st.executeQuery(SQL);
            //rs.next();
            //medecins.add(rs.getString(1));


        //}catch (Exception e){
          //  e.printStackTrace();
        //}



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

                        String Rem = "SELECT dose FROM vaccin WHERE nom = 'Pfizer'";
                        ResultSet rs = st.executeQuery(Rem);
                        rs.next();
                        int quantite = rs.getInt(1)-1;
                        System.out.println(rs.getInt(1));

                        String Add = "UPDATE `vaccin` SET `dose` = "+quantite+" WHERE `vaccin`.`id` = 1;";
                        st.executeUpdate(Add);

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

                        String Rem = "SELECT `dose` FROM `vaccin` WHERE `nom` = 'Astra Zeneca'";
                        ResultSet rs = st.executeQuery(Rem);
                        rs.next();
                        int quantite = rs.getInt(1) - 1;
                        String Add = "UPDATE `vaccin` SET `dose` = "+quantite+" WHERE `vaccin`.`id` = 2;";
                        st.executeUpdate(Add);

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

                        String Rem = "SELECT `dose` FROM `vaccin` WHERE `nom` = 'Moderna'";
                        ResultSet rs = st.executeQuery(Rem);
                        rs.next();
                        int quantite = rs.getInt(1) - 1;
                        String Add = "UPDATE `vaccin` SET `dose` = "+quantite+" WHERE `vaccin`.`id` = 3;";
                        st.executeUpdate(Add);

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

    public void onItemSelected(ArrayAdapter<?> arg0, View arg1, int position, long id){
        Toast.makeText(getApplicationContext(), medecins[position], Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0){

    }
    private void redirect(){
        Intent otherActivity = new Intent(getApplicationContext(), Homepage.class);
        startActivity(otherActivity);
        finish();
    }
}