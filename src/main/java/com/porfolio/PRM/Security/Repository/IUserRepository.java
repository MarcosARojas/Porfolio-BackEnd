/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.PRM.Security.Repository;

import com.porfolio.PRM.Security.Entity.EUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcos
 */
@Repository
public interface IUserRepository extends JpaRepository<EUser, Integer>{
    Optional<EUser> findByNombreUsuario(String nombreUser);
    
    boolean existsByNombreUsuario(String nombreUser);
    boolean existsByEmail(String email);
    
}
