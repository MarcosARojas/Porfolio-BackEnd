/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.PRM.Service;


import com.porfolio.PRM.Entity.EUser;
import com.porfolio.PRM.Interface.IUser;
import com.porfolio.PRM.Repository.RUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Analogia a IPersonaService
 */
@Service
public class SUser implements IUser{
    
    @Autowired RUser rUser;
    
    @Override
    public List<EUser> getUser() {
      List<EUser> eUser = rUser.findAll();
      return eUser;
    }

    @Override
    public void saveUser(EUser eUser) {
        rUser.save(eUser);
    }

    @Override
    public void deleteUser(Long id) {
        rUser.deleteById(id);
    }

    @Override
    public EUser findUser(Long id) {
        EUser eUser = rUser.findById(id).orElse(null);
        return eUser;
    }
    
}
