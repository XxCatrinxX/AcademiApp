package com.example.academiapp;


import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    String ip ="192.168.1.93";
    //String url = "jdbc:mysql://localhost:3306/myDatabaseName";
    String db = "academiapp";
    String usuariodb ="remoto";
    String password ="123456";
    String url ="jdbc:mysql://"+ip+"/"+db;

    @SuppressLint("NewApi")

    public Connection conectar () {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, usuariodb, password);
        } catch (ClassNotFoundException ex) {
            Log.e("Error 1", ex.getMessage());
        } catch (SQLException ex) {
            Log.e("Error 2", ex.getMessage());
        } catch (Exception ex) {
            Log.e("Error 3", ex.getMessage());
        }
        return conn;
    }
}
