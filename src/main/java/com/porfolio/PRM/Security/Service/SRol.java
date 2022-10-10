/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.PRM.Security.Service;

import com.porfolio.PRM.Security.Entity.ERol;
import com.porfolio.PRM.Security.Enums.RolNombre;
import com.porfolio.PRM.Security.Repository.IRolRepository;
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
public class SRol {
    @Autowired IRolRepository iRolRepository;
    
    public Optional<ERol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);  
    }
    
    public void save(ERol eRol){
        iRolRepository.save(eRol);
    }
    
}

