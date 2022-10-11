/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.porfolio.PRM.Security.Controller;

import com.porfolio.PRM.Security.Dto.JwtDto;
import com.porfolio.PRM.Security.Dto.LoginUsuario;
import com.porfolio.PRM.Security.Dto.NuevoUsuario;
import com.porfolio.PRM.Security.Entity.ERol;
import com.porfolio.PRM.Security.Entity.ESecurityUser;
import com.porfolio.PRM.Security.Enums.RolNombre;
import com.porfolio.PRM.Security.Service.SRol;
import com.porfolio.PRM.Security.Service.SSecurityUser;
import com.porfolio.PRM.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired AuthenticationManager authenticationManager;
    @Autowired SSecurityUser sSecurityUser;
    @Autowired SRol sRol;
    @Autowired JwtProvider jwtProvider;
    
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        if(sSecurityUser.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Este nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
         
        if(sSecurityUser.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Este email de usuario ya existe"), HttpStatus.BAD_REQUEST);
        
        ESecurityUser eSecurityUser = new ESecurityUser(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<ERol> roles = new HashSet<>();
        roles.add(sRol.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(sRol.getByRolNombre(RolNombre.ROLE_USER).get());
        eSecurityUser.setRoles(roles);
        sSecurityUser.save(eSecurityUser);
        
        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
        
    }
    
    @PostMapping("/loggin")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);    

    } 
}
