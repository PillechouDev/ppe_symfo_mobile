package com.example.ppenahim3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;

public class ModStock extends AppCompatActivity {


    private EditText numberPicker;
    private RadioGroup radioButton;
    private TextView modButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_stock);

        this.numberPicker = (EditText) findViewById(R.id.pickerNum);
        this.radioButton = (RadioGroup) findViewById(R.id.vaccinname);
        this.modButton = (TextView) findViewById(R.id.modButton);
        radioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                System.out.println("frfireief");
                int selectedId = radioButton.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String radioText = radioButton.getText().toString();
                if (radioText.equals("Pfizer")) {

                    numberPicker.setText(getNumberofFlacon(1));
                }
                if (radioText.equals("Astra Zeneca 8 doses")) {
                    numberPicker.setText(getNumberofFlacon(3));
                }
                if (radioText.equals("Astra Zeneca 10 doses")) {
                    numberPicker.setText(getNumberofFlacon(2));
                }
                if (radioText.equals("Moderna")) {
                    numberPicker.setText(getNumberofFlacon(4));
                }
            }
        });

        modButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioButton.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String radioText = radioButton.getText().toString();
                String number = numberPicker.getText().toString();
                int num = Integer.parseInt(number);
                if(radioText.equals("Pfizer")){
                    setNumberofFlacon(1,num);
                }
                if(radioText.equals("Astra Zeneca 8 doses")){
                    setNumberofFlacon(3,num);
                }
                if(radioText.equals("Astra Zeneca 10 doses")){
                    setNumberofFlacon(2,num);
                }
                if(radioText.equals("Moderna")){
                    setNumberofFlacon(4,num);
                }
                else{
                    redirect();
                }

            }
        });


    }
    private void setNumberofFlacon(int id,int number) {
        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL3 = "UPDATE `vaccin` SET `flacon` = "+number+" WHERE `vaccin`.`id` = "+id+";";
            st.executeUpdate(SQL3);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    private String getNumberofFlacon(int id) {
        try {
            Fonctions fonc = new Fonctions();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT flacon from vaccin WHERE id = "+id;

            ResultSet rs = st.executeQuery(SQL);
            rs.next();
            return rs.getString(1);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    private void redirect(){
        Intent otherActivity = new Intent(getApplicationContext(), Homepage.class);
        startActivity(otherActivity);
        finish();
    }
}

