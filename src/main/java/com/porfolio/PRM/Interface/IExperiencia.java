/*/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 
package com.porfolio.PRM.Interface;

import com.porfolio.PRM.Entity.EExperiencia;
import java.util.List;

/**
 *
 * @author Marcos
 
public interface IExperiencia {
    //Traer una lista de personas
    public List<EExperiencia> getExperiencia();
    
    //Guardar un objeto de tipo Persona
    public void saveExperiencia(EExperiencia eExperiencia);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deleteExperiencia(Long id);
    
    //Buscar una persona por ID
    public EExperiencia findExperiencia(Long id);
}
*/