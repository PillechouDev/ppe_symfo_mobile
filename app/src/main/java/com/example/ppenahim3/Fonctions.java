package com.example.ppenahim3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Fonctions {
    /*
    public static String url = "jdbc:mysql://pillechou.ddns.net:3306/phpmyadmin/ppesyfmfo_mobile";
    public static String user = "romainroot";
    public static String pass = "qAMBkzeXJcaZLRNJ";*/
    public static String url = "jdbc:mysql://pillechou.ddns.net:3306/ppe-symfo?autoReconnect=true&useSSL=false";
    public static String user = "romainroot";
    public static String pass = "qAMBkzeXJcaZLRNJ";

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
