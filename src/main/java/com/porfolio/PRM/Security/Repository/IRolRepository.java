/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.PRM.Security.Repository;

import com.porfolio.PRM.Security.Entity.ERol;
import com.porfolio.PRM.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcos
 */
@Repository
public interface IRolRepository extends JpaRepository<ERol, Integer>{
    Optional<ERol> findByRolNombre(RolNombre rolNombre);
    
}
