/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.AccountDAO;
import java.sql.SQLException;
import java.util.List;
import database.UserDAO;

/**
 *
 * @author pato
 */
public class User {
    private int userID;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String gender;
    private String email;
    private String city;
    private String country;
    private String repassw;
    //private List<Account> userAccounts;
    
    //Método constructor. Para registrar nuevo usuario

    public User (int userID, String username, String password, String name, String lastName, String gender, String email, String city, String country) {

        this.userID = userID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.city = city;
        this.country = country;
        
//        AccountDAO accounts = new AccountDAO();
//        try {
//            this.userAccounts = accounts.getAccounts(1,10);
//        } catch (SQLException err) {
//           
//        }
    }    
    
    //Para actualizar un usuario
    public User (int userID, String password, String email, String city, String country, String repassw) {
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.city = city;
        this.country = country;
        this.repassw = repassw;
    }    
    
    //Sobrecarga método constructor con otra alternativa para crear usuario. Lo uso para validar si las credenciales están correctas
    
    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

//    public User (String username, String password, String name, String lastName, String gender, String email, String city, String country) {
//
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.lastName = lastName;
//        this.gender = gender;
//        this.email = email;
//        this.city = city;
//        this.country = country;   
//    }
        
    // Getters & Setters

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", name=" + name + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", city=" + city + ", country=" + country + '}';
    }




}
