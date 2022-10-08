/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.PRM.Interface;

import com.porfolio.PRM.Entity.EUser;
import java.util.List;

/**
 *
 * @author Marcos
 */
public interface IUser {
    //Traer una lista de personas
    public List<EUser> getUser();
    
    //Guardar un objeto de tipo Persona
    public void saveUser(EUser eUser);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deleteUser(Long id);
    
    //Buscar una persona por ID
    public EUser findUser(Long id);
    
}
