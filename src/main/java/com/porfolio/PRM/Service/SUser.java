/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.PRM.Service;


import com.porfolio.PRM.Entity.EUser;
import com.porfolio.PRM.Repository.RUser;
import com.porfolio.PRM.Repository.RUser1;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Analogia a IPersonaService
 */
@Service
@Transactional
public class SUser{
    
    @Autowired
    RUser rUser;
    @Autowired
    RUser1 rUser1;

    public List<EUser> list() {
        return rUser.findAll();
    }

    public Optional<EUser> getOne(int id) {
        return rUser.findById(id);
    }

    public Optional<EUser> getByNombre(String nombre) {
        return rUser.findByNombre(nombre);
    }

    public void save(EUser eUser) {
        rUser.save(eUser);
    }

    public void delete(int id) {
        rUser.deleteById(id);
    }

    public boolean existsById(int id) {
        return rUser.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return rUser.existsByNombre(nombre);
    }
    
    public EUser findUser(Long id) {
        EUser eUser = rUser1.findById(id).orElse(null);
        return eUser;
    }
}
