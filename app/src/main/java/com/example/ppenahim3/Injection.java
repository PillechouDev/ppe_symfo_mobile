package com.example.ppenahim3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.RestrictionsManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Injection extends AppCompatActivity {
    private TextView surnamePatient;
    private TextView namePatient;
    private TextView nameMedecin;
    private DatePicker date;
    private RadioGroup vaccin;
    private TextView programmInjection;
    private TimePicker heure;
    private RadioButton radioButton;
    private Spinner medecin;
    private Object AdapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.injection);

        this.surnamePatient = (TextView) findViewById(R.id.surnamePatient);
        this.namePatient = (TextView) findViewById(R.id.namePatient);
        this.nameMedecin = (TextView) findViewById(R.id.nameMedecin);
        this.date = (DatePicker) findViewById(R.id.date);
        this.vaccin = (RadioGroup) findViewById(R.id.vaccin);
        this.programmInjection = (TextView) findViewById(R.id.programmInjection);
        this.heure = (TimePicker) findViewById(R.id.heureInj);


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
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                final String surname = surnamePatient.getText().toString();
                final String name = namePatient.getText().toString();
                final String namemed = nameMedecin.getText().toString();
                int selectedId = vaccin.getCheckedRadioButtonId();
                final int year = date.getYear();
                final int month = date.getMonth();
                final int day = date.getDayOfMonth();
                final int heureInj = heure.getHour();
                final int minuteInj = heure.getMinute();
                System.out.println(heureInj);
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String radioText = radioButton.getText().toString();
                if(radioText.equals("Pfizer")){
                    Injection(year,month,day,heureInj,minuteInj,surname,name,1,namemed);
                }
                if(radioText.equals("Astra Zeneca 8 doses")){
                    Injection(year,month,day,heureInj,minuteInj,surname,name,3,namemed);
                }
                if(radioText.equals("Astra Zeneca 10 doses")){
                    Injection(year,month,day,heureInj,minuteInj,surname,name,2,namemed);
                }
                if(radioText.equals("Moderna")){
                    Injection(year,month,day,heureInj,minuteInj,surname,name,4,namemed);
                }
                else{
                    redirect();
                }
            }
        });
    }

    /*
    public void onItemSelected(ArrayAdapter<?> a/rg0, View arg1, int position, long id){
        Toast.makeText(getApplicationContext(), medecins[position], Toast.LENGTH_LONG).show();
    }

     */
    public void onNothingSelected(AdapterView<?> arg0){

    }
    private void redirect(){
        Intent otherActivity = new Intent(getApplicationContext(), Homepage.class);
        startActivity(otherActivity);
        finish();
    }

    private void Injection(int year,int month,int day,int heureInj,int minuteInj,String surname,String name,int idvaccin, String nommedecin){
        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String dateInj = year+"-0"+month+"-"+day;
            System.out.println(heureInj);
            System.out.println(minuteInj);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateStr = formatter.parse(dateInj);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
            System.out.println(dateDB);
            String SQL = "INSERT INTO `injection` (`IdInjection`, `prenomPatient`, `nomPatient`, `dateInjection`, `IdVaccin`, `NomMedecin`) VALUES (NULL, '"+surname+"', '"+name+"', '"+dateDB+" "+heureInj+":"+minuteInj+":00.0', "+idvaccin+" , "+nommedecin+")";

            st.executeUpdate(SQL);

            String Rem = "SELECT doses FROM flacon_use WHERE id = "+idvaccin+";";
            ResultSet rs = st.executeQuery(Rem);
            rs.next();
            if (rs.getInt(1)==0){
                System.out.println("dans le fi");
                String SQL2 = "UPDATE vaccin SET `flacon` = flacon -1  WHERE id =  "+idvaccin+";";
                st.executeUpdate(SQL2);
                String SQL4 = "SELECT doses FROM flacon_details WHERE id = "+idvaccin+";";
                ResultSet rs4 = st.executeQuery(SQL4);
                rs4.next();
                String SQL3 = "UPDATE `flacon_use` SET `doses` = "+rs4.getInt(1)+" WHERE `flacon_use`.`id` = "+idvaccin+";";
                st.executeUpdate(SQL3);

            }
            System.out.println(rs.getInt(1));

            String Add = "UPDATE `flacon_use` SET `doses` = doses -1 WHERE `flacon_use`.`id` = "+idvaccin+";";
            st.executeUpdate(Add);
            redirect();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}