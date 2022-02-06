package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pato
 */


    //lógica para la conexión a la base de datos

public class DBConnection {
    
    private String driver = "com.mysql.jdbc.Driver"; //cargo el paquete del driver
    private String host = "jdbc:mysql://localhost:3306/";
    
    // metodo para conectar con la BD
    public Connection getConnection(String database, String userMysql, String pwdMysql) {
        Connection cnx = null;
        try {
            Class.forName(driver); //carga el driver de jdbc en tiempo de ejecución para que Tomcat (server) pueda usar la conexión a jdbc en
            cnx = DriverManager.getConnection(host + database, userMysql, pwdMysql); //usa el diver
          
        } catch (ClassNotFoundException | SQLException err) { // si en tiempo de ejecución no encuentra la clase, devuelve la excepción
            err.printStackTrace();
        }
        return cnx;
    }  
}

