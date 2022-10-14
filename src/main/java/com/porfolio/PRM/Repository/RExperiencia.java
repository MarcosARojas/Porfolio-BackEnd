/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.PRM.Repository;

import com.porfolio.PRM.Entity.EExperiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<EExperiencia, Integer>{
    public Optional<EExperiencia> findByPuesto(String puesto);
    public boolean existsByPuesto(String puesto);
}
