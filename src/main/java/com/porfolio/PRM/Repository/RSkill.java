/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.PRM.Repository;

import com.porfolio.PRM.Entity.ESkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkill extends JpaRepository<ESkill, Integer>{
    public Optional<ESkill> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
