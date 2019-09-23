/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 *@author Tatiana Almansa
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    /**
     * mapeo a la base de datos 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column 
    private String userName;
    @Column
    private String password;
    @Column
    private String rol;
    /**
     * constructor vacio
     */
    public Usuario() {
    }
    /**
     * 
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * 
     * @param id 
     * metodo set que modifica el id de usuario
     */
    public void setId(int id) {
        this.id = id;
    }

     public String getUserName() {
        return userName;
    }
    /**
     * metodo set que modifica el nombre de usuario
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * metodo get que obtiene la contraseña del usuario
     * @return 
     */
    public String getPassword() {
        return password;
    }
    /**
     * metodo set que modifica la contraseña del usuario
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * metodo get que obtiene el rol del usuario
     * @return 
     */
    public String getRol() {
        return rol;
    }
    /**
     * Metodo set que modifica el rol del usuario
     * @param rol 
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
