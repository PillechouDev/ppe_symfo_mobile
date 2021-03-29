package com.example.ppenahim3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;

public class ModStock extends AppCompatActivity {


    private NumberPicker numberPicker;
    private RadioGroup radioButton;
    private TextView modButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.numberPicker = (NumberPicker) findViewById(R.id.pickerNum);
        this.radioButton = (RadioGroup) findViewById(R.id.vaccinname);
        this.modButton = (TextView) findViewById(R.id.modButton);


        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioButton.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String radioText = radioButton.getText().toString();
                if(radioText.equals("Pfizer")){
                    numberPicker.setValue(getNumberofFlacon(1));
                }
                if(radioText.equals("Astra Zeneca 8 doses")){
                    numberPicker.setValue(getNumberofFlacon(3));
                }
                if(radioText.equals("Astra Zeneca 10 doses")){
                    numberPicker.setValue(getNumberofFlacon(2));
                }
                if(radioText.equals("Moderna")){
                    numberPicker.setValue(getNumberofFlacon(4));
                }
                else{
                    redirect();
                }
            }
        });
        modButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioButton.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String radioText = radioButton.getText().toString();
                int number = numberPicker.getValue();
                if(radioText.equals("Pfizer")){
                   setNumberofFlacon(1,number);
                }
                if(radioText.equals("Astra Zeneca 8 doses")){
                    setNumberofFlacon(3,number);
                }
                if(radioText.equals("Astra Zeneca 10 doses")){
                    setNumberofFlacon(2,number);
                }
                if(radioText.equals("Moderna")){
                    setNumberofFlacon(4,number);
                }
                else{
                    redirect();
                }

            }
        });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_stock);

    }
    private void setNumberofFlacon(int id,int number) {
        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL3 = "UPDATE `vaccin` SET `falcon` = "+number+" WHERE `vaccin`.`id` = "+id+";";
            st.executeUpdate(SQL3);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    private int getNumberofFlacon(int id) {
        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT flacon from vaccin WHERE id = "+id;

            ResultSet rs = st.executeQuery(SQL);
            rs.next();
            return rs.getInt(1);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;

    }
    private void redirect(){
        Intent otherActivity = new Intent(getApplicationContext(), Homepage.class);
        startActivity(otherActivity);
        finish();
    }
}