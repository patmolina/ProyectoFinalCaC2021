package database;

import config.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import java.util.List;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pato
 */

/* logica de acceso a los datos. Interacción entre la base de datos y la 
 * aplicación.
 */

public class UserDAO {
    
    // método main para probar métodos
//    public static void main(String[] args) {
//    
//    UserDAO user = new UserDAO();
//    try {
//    User usuario = user.getUser("PatoM");
//    System.out.print(usuario.getName() + " ");
//    System.out.print(usuario.getLastName() + " - ");
//    System.out.print(usuario.getEmail()+ " - ");
//    System.out.print(usuario.getGender()+ " - ");
//    System.out.print(usuario.getCity()+ " - ");
//    System.out.print(usuario.getCountry() + " - ");
//    System.out.print(usuario.getUsername() + " - ");
//    System.out.print(usuario.getPassword()+ " ");
//    
//    } catch (SQLException err){
//    System.out.println("err");
//    }
//    }
    
//variable para crear una instancia de base de datos
    Connection connection;
    
    //método constructor. Creo una instancia de DBCOnnection. De esta manera puedo usar el metodo en la clase DBConnection
    public UserDAO () {
        DBConnection cnx = new DBConnection();
        connection = cnx.getConnection("hbanking", "root", "Papeete#");
    }
    
        
    //método para poder traer un usuario
    /* Al crear una instancia de userDAO automaticamente guardo en connection 
    * una conexión a la base de datos. Entonces al usar el siguiente método 
    * puedo consultar la conexión automáticamente
    */     
    
    
    public User getUserByUserName(String username) throws SQLException {
        PreparedStatement ps;
        ResultSet rs; 
        User user = null; // Si el usuario no existe al hacer la consulta, devuelve null
        
            ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, username);
            rs = ps.executeQuery(); //consulta la base y asigna resultado a rs
            
            if(rs.next()) { //no hago un while xq necesito 1 solo valor
                String userName = rs.getString("username");
                String password = rs.getString("password"); 
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String avatar = rs.getString("avatar");
                
                
                user = new User(userName, password, name, lastname, gender, email, city, country, avatar); // uso el constructor que había creado en la clase User
            }
            
            return user;
           
        }
    
    public boolean login (String username, String password) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        
        ps = connection.prepareStatement("SELECT username, password FROM users WHERE username = ? AND password = ?"); //creo statement para la conexion
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.executeQuery();
        
        
        if (rs.next()){
            rs.close();
            ps.close();
            connection.close();
            return true;
        }
        rs.close();
        ps.close();
        connection.close();
        return false;
        
        
// Lo dejo comentao para recordar que no funciona!!        
//        connection.close();  
//        ps.close();
//       rs.close();
//       
//        return rs.next();
    }
    
    // método para crear un nueva nueva cuenta de usuario:
    
    public boolean createUser(String username, String password, String name, String lastname, String gender, String email, String city, String country, String repassw) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        
        if (password.equals(repassw)) {
        ps = connection.prepareStatement("INSERT INTO users (username, password, name, lastname, gender, email, city, country) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, name);
        ps.setString(4, lastname);
        ps.setString(5, gender);
        ps.setString(6, email);
        ps.setString(7, city);
        ps.setString(8, country);
        ps.executeUpdate();
        
        ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
        ps.setString(1, username);
        rs = ps.executeQuery();
           if (rs.next()) {
               return true;
           } 
        return false;   
        } 
      return false;
    }
   
    public List<User> getUsers(int limit) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        List<User> usersDB = new ArrayList<>();
        
        ps = connection.prepareStatement("SELECT * FROM users LIMIT ?");
            ps.setInt(1, limit);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                usersDB.add(new User(rs.getString("username"), rs.getString("password")));
            }
           
            rs.close();
            ps.close();
            connection.close();
    
            return usersDB;
    }
    
}
    
      
   
