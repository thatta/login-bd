/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;


import com.mycompany.dto.DtoUsuario;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import javax.inject.Named;

/**
 * @author Tatiana Almansa
 */

@Named
@ViewScoped
public class Login implements Serializable {
    /**
     * Variables de la clase Login
     */
    private String userName;
    private String password;
    
    @EJB
    private IUsuarioFacade usuario;
    /**
     * Constructor vacio
     */
    public Login() {
    }
    /**
     * Metodo get para obtener el nombre de usuario de la interfaz
     * @return 
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Metodo get para nombre el nombre de usuario de la interfaz
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * Metodo get para obtener la contraseña de la interfaz
     * @return 
     */
    public String getPassword() {
        return password;
    }
    /**
     * Metodo set para modificar la contraseña 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Metodo que valida los datos para iniciar la sesion del usuario
     * @throws IOException 
     */
    public void validar() throws IOException {
        DtoUsuario persona = usuario.login(userName,password);
        
        if(persona != null){
            if(persona.getRol().equals("administrador")){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("admin", persona);
                FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
            }else if (persona.getRol().equals("empleado")){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empleado", persona);
                FacesContext.getCurrentInstance().getExternalContext().redirect("empleado.xhtml");
            }else if (persona.getRol().equals("cliente")){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", persona);
                FacesContext.getCurrentInstance().getExternalContext().redirect("cliente.xhtml");
      
        }
        else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN , "Datos Erroneos", "ingrese los datos correctos");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    }
}
