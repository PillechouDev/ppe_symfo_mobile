package com.example.ppenahim3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Fonctions {

    public static String url = "jdbc:mysql://10.0.2.2:3308/ppe-nahim";
    public static String user = "root";
    public static String pass = "";

    public static Statement connexionSQLBDD() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement st = conn.createStatement();
            return st;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
