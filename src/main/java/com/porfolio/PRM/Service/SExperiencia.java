/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.PRM.Service;


import com.porfolio.PRM.Entity.EExperiencia;
import com.porfolio.PRM.Repository.RExperiencia;
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
public class SExperiencia {
        @Autowired RExperiencia rExperiencia;
        
        public List<EExperiencia> list(){
            return rExperiencia.findAll();
        }
        
        public Optional<EExperiencia> getOne(int id){
            return rExperiencia.findById(id);
        } 
        
        public Optional<EExperiencia> getByPuesto(String puesto){
            return rExperiencia.findByPuesto(puesto);
        }
        
        public void save(EExperiencia eExperiencia){
            rExperiencia.save(eExperiencia);
        }
        
        public void delete(int id){
            rExperiencia.deleteById(id);
        }
        
        public boolean existById(int id){
            return rExperiencia.existsById(id);
        }
        
        public boolean existsByPuesto(String puesto){
            return rExperiencia.existsByPuesto(puesto);
        }
        
        
}










/*------------------------------------------------------------------------------
@Getter @Setter
@Service
public class SExperiencia implements IExperiencia{
    
    @Autowired RExperiencia rExperiencia;
    
    @Override
    public List<EExperiencia> getExperiencia() {
      List<EExperiencia> eExperiencia = rExperiencia.findAll();
      return eExperiencia;
    }

    @Override
    public void saveExperiencia(EExperiencia eExperiencia) {
        rExperiencia.save(eExperiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
        rExperiencia.deleteById(id);
    }

    @Override
    public EExperiencia findExperiencia(Long id) {
        EExperiencia eExperiencia = rExperiencia.findById(id).orElse(null);
        return eExperiencia;
    }*/