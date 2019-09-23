/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DtoUsuario;
import com.mycompany.interfaces.IUsuarioFacade;
import com.mycompany.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tatiana Almansa
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements IUsuarioFacade {

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    /**
     * 
     * @param username
     * @param password
     * @return 
     * metodo para seleccionar los datos que estan en la base de datos para luego validarlos con los datos ingrsados
     */
    @Override
    public DtoUsuario login(String username, String password) {
        
        DtoUsuario usuario = null;
        Usuario u = null;
        
        try {
            Query validar = em.createQuery("FROM Usuario u WHERE u.userName = ?1 and u.password = ?2");
            validar.setParameter(1, username);
            validar.setParameter(2, password);
            List<Usuario> lista = validar.getResultList();
            if(!lista.isEmpty()){
                u = lista.get(0);
                usuario = new DtoUsuario(u.getUserName(), u.getPassword(), u.getRol());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return usuario;

    }

}
