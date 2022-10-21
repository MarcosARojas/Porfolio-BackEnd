/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.PRM.Service;

import com.porfolio.PRM.Entity.ESkill;
import com.porfolio.PRM.Repository.RSkill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkill {
    @Autowired RSkill rSkill;
    
    public List<ESkill> list(){
            return rSkill.findAll();
        }
        
        public Optional<ESkill> getOne(int id){
            return rSkill.findById(id);
        } 
        
        public Optional<ESkill> getByNombre(String nombre){
            return rSkill.findByNombre(nombre);
        }
        
        public void save(ESkill eSkill){
            rSkill.save(eSkill);
        }
        
        public void delete(int id){
            rSkill.deleteById(id);
        }
        
        public boolean existsById(int id){
            return rSkill.existsById(id);
        }
        
        public boolean existsByNombre(String nombre){
            return rSkill.existsByNombre(nombre);
        }
    
}
