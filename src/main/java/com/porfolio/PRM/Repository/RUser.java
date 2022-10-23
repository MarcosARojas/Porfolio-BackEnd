/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.PRM.Repository;

import com.porfolio.PRM.Entity.EUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RUser extends JpaRepository<EUser, Long>{ 
    public Optional<EUser> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}