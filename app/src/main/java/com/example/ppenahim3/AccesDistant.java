package com.example.ppenahim3;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;

public class AccesDistant implements AsyncResponse {

    private static final String SERVERADDR = "http://pillechou.ddns.net/Connexion/serveur.php";


    public AccesDistant(){
        super();
    }
    /**
     *
     * @param output
     */
    @Override
    public void processFinish(String output){
        Log.d("serveur","*********************"+output);
        String[] message = output.split("%");
    }

    public void envoi(String operation, JSONArray lesDonneesJSON){
        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnees", lesDonneesJSON.toString());
        accesDonnees.execute(SERVERADDR);

    }


}
