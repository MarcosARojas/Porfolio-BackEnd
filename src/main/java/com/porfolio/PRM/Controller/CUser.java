package com.porfolio.PRM.Controller;

import com.porfolio.PRM.Dto.DtoUser;
import com.porfolio.PRM.Entity.EUser;
import com.porfolio.PRM.Security.Controller.Mensaje;
import com.porfolio.PRM.Service.SUser;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
@CrossOrigin(origins = "https://myprojasmarcos.web.app/")
public class CUser {
    @Autowired SUser sUser;
    
    @GetMapping("traer")
    public EUser findPersona(){
        return sUser.findUser((long)1);
    }
    
    
    @GetMapping("details/{id}")
    public ResponseEntity<EUser> getById(@PathVariable("id") int id){
        if(!sUser.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        } else {
        EUser eUser = sUser.getOne(id).get();
        return new ResponseEntity(eUser, HttpStatus.OK);
        }
    }
    
    
    @PostMapping("crear")
    public ResponseEntity<?> create(@RequestBody DtoUser dtoUser){
        if (StringUtils.isBlank(dtoUser.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sUser.existsByNombre(dtoUser.getNombre())){
            return new ResponseEntity(new Mensaje("El Usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        EUser eUser = new EUser(
                                dtoUser.getNombre(),
                                dtoUser.getApellido(),
                                dtoUser.getEmail(),
                                dtoUser.getTitulo(),
                                dtoUser.getDescripcion(),
                                dtoUser.getUrlPerfil(),
                                dtoUser.getUrlBanner(),
                                dtoUser.getuLinkedin(),
                                dtoUser.getuFacebook(),
                                dtoUser.getuInstagram(),
                                dtoUser.getuGitHub()
                                );
        sUser.save(eUser);
        
        return new ResponseEntity(new Mensaje("Usuario agregado"), HttpStatus.OK);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody DtoUser dtoUser){
        //Validamos si existe el ID
        if(!sUser.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        //Compara nombre de experiencias
        if(sUser.existsByNombre(dtoUser.getNombre()) && sUser.getByNombre(dtoUser.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        EUser eUser = sUser.getOne(id).get();
        eUser.setNombre(dtoUser.getNombre());
        eUser.setApellido(dtoUser.getApellido());
        eUser.setEmail(dtoUser.getEmail());
        eUser.setTitulo(dtoUser.getTitulo());
        eUser.setDescripcion(dtoUser.getDescripcion());
        eUser.setUrlPerfil(dtoUser.getUrlPerfil());
        eUser.setUrlBanner(dtoUser.getUrlBanner());
        eUser.setuLinkedin(dtoUser.getuLinkedin());
        eUser.setuFacebook(dtoUser.getuFacebook());
        eUser.setuInstagram(dtoUser.getuInstagram());
        eUser.setuGitHub((dtoUser.getuGitHub()));
        
        sUser.save(eUser);
        return new ResponseEntity(new Mensaje("Usuario actualizado"), HttpStatus.OK);
             
    }
    
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el ID
        if(!sUser.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        } else {
        sUser.delete(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
        }
    }
    
   
}