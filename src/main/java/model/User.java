/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pato
 */
public class User {
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String gender;
    private String email;
    private String city;
    private String country;
    private String avatar;
    
    //Método constructor. Para registrar nuevo usuario
    public User (String username, String password, String name, String lastName, String gender, String email, String city, String country, String avatar) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.city = city;
        this.country = country;
        this.avatar = avatar;
    
    }
    
    //Sobrecarga método constructor con otra alternativa para crear usuario. Lo uso para validar si las credenciales están correctas
    
    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    // Getters & Setters

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
    
    
}
