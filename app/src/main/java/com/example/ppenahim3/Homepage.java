package com.example.ppenahim3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    private TextView injectionButton;
    private TextView historiqueButton;
    private TextView stockButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

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