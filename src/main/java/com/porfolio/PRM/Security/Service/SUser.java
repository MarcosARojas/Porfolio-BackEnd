/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.PRM.Security.Service;

import com.porfolio.PRM.Security.Entity.EUser;
import com.porfolio.PRM.Security.Repository.IUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Marcos
 */

@Service
@Transactional
public class SUser {
    @Autowired IUserRepository iUserRepository;
    
    public Optional<EUser> getByNombreUsuario(String nombreUsuario){
        return iUserRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iUserRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iUserRepository.existsByEmail(email);
    }
    
    public void save(EUser eUser){
        iUserRepository.save(eUser);
    }
    
}
