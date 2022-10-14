package com.porfolio.PRM.Controller;

import com.porfolio.PRM.Dto.DtoExperiencia;
import com.porfolio.PRM.Entity.EExperiencia;
import com.porfolio.PRM.Security.Controller.Mensaje;
import com.porfolio.PRM.Service.SExperiencia;
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
@RequestMapping("experiencia/")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired SExperiencia sExperiencia;
    
    @GetMapping("lista")
    public ResponseEntity<List<EExperiencia>>list(){
        List<EExperiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     @GetMapping("details/{id}")
    public ResponseEntity<EExperiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        EExperiencia eExperiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(eExperiencia, HttpStatus.OK);
    }
    
    
    @PostMapping("crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExperiencia){
        if (StringUtils.isBlank(dtoExperiencia.getPuesto()))
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        if (sExperiencia.existsByPuesto(dtoExperiencia.getPuesto()))
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        EExperiencia eExperiencia = new EExperiencia(
                                                    dtoExperiencia.getPuesto(),
                                                    dtoExperiencia.getEmpresa(),
                                                    dtoExperiencia.getPeriodo(),
                                                    dtoExperiencia.getDescripcion()
                                                    );
        sExperiencia.save(eExperiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia){
        //Validamos si existe el ID
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sExperiencia.existsByPuesto(dtoExperiencia.getPuesto()) && sExperiencia.getByPuesto(dtoExperiencia.getPuesto()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoExperiencia.getPuesto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        EExperiencia eExperiencia = sExperiencia.getOne(id).get();
        eExperiencia.setPuesto(dtoExperiencia.getPuesto());
        eExperiencia.setDescripcion((dtoExperiencia.getDescripcion()));
        
        sExperiencia.save(eExperiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
    
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el ID
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
   
}