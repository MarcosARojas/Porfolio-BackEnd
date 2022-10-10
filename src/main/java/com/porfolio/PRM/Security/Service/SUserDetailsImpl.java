/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.PRM.Security.Service;

import com.porfolio.PRM.Security.Entity.EUser;
import com.porfolio.PRM.Security.Entity.EUserRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos
 */
@Service
public class SUserDetailsImpl implements UserDetailsService{
    @Autowired SUser sUser;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        EUser eUser = sUser.getByNombreUsuario(nombreUsuario).get();
        return EUserRoot.build(eUser); 
    }
    
    
}
