package com.porfolio.PRM.Controller;

import com.porfolio.PRM.Dto.DtoEducacion;
import com.porfolio.PRM.Entity.EEducacion;
import com.porfolio.PRM.Security.Controller.Mensaje;
import com.porfolio.PRM.Service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<EEducacion>>list(){
        List<EEducacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/details/{id}")
    public ResponseEntity<EEducacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        EEducacion eEducacion = sEducacion.getOne(id).get();
        return new ResponseEntity(eEducacion, HttpStatus.OK);
    }
    
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion){
        if (StringUtils.isBlank(dtoEducacion.getTitulo())){
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByTitulo(dtoEducacion.getTitulo())){
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        EEducacion eEducacion = new EEducacion(
                                                    dtoEducacion.getTitulo(),
                                                    dtoEducacion.getInstitucion(),
                                                    dtoEducacion.getPeriodo()
                                                    );
        sEducacion.save(eEducacion);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion){
        //Validamos si existe el ID
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        //Compara nombre de experiencias
        if(sEducacion.existsByTitulo(dtoEducacion.getTitulo()) && 
                sEducacion.getByTitulo(dtoEducacion.getTitulo()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if(StringUtils.isBlank(dtoEducacion.getTitulo())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        EEducacion eEducacion = sEducacion.getOne(id).get();
        eEducacion.setTitulo(dtoEducacion.getTitulo());
        eEducacion.setInstitucion((dtoEducacion.getInstitucion()));
        
        sEducacion.save(eEducacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el ID
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
}
