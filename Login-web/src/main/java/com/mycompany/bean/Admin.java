/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.dto.DtoUsuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Tatiana Almansa
 */

@Named
@ViewScoped
public class Admin implements Serializable{
    /**
     * Metodo para verificar y validar la sesion del rol administrador 
     */
    public void verificarSesion(){
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            DtoUsuario persona = (DtoUsuario) fc.getExternalContext().getSessionMap().get("admin");
            
            if(persona == null){
                 fc.getExternalContext().redirect("index.xhtml");
            } 
        } catch (Exception e) {
        }
    
    }
    /**
     * Metodo para cerrar la sesion del rol administrador
     */
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
