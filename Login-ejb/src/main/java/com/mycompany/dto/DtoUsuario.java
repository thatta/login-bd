/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

/**
 *@author Tatiana Almansa
 */
public class DtoUsuario {
   /**
    * Variables de la clase persona
    */ 
    private String userName;
    private String password;
    private String rol;
    /**
     * Constructor de la clase que recibe los siguientes parametros
     * @param userName
     * @param password
     * @param rol 
     */
    public DtoUsuario(String userName, String password, String rol) {
        this.userName = userName;
        this.password = password;
        this.rol = rol;
    }
    /**
     * Constructor vacio
     */
    public DtoUsuario() {
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
    /**
     * metodo get que obtiene el nombre de usuario
     * @return 
     */
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
}
