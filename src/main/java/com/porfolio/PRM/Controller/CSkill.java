package com.porfolio.PRM.Controller;

import com.porfolio.PRM.Dto.DtoSkill;
import com.porfolio.PRM.Entity.ESkill;
import com.porfolio.PRM.Entity.EUser;
import com.porfolio.PRM.Security.Controller.Mensaje;
import com.porfolio.PRM.Service.SSkill;
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
@RequestMapping("skill/")
@CrossOrigin(origins = "https://myprojasmarcos.web.app/")
public class CSkill {
    @Autowired SSkill sSkill;
    
    @GetMapping("lista")
    public ResponseEntity<List<ESkill>>list(){
        List<ESkill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("details/{id}")
    public ResponseEntity<ESkill> getById(@PathVariable("id") int id){
        if(!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        } else {
        ESkill eSkill = sSkill.getOne(id).get();
        return new ResponseEntity(eSkill, HttpStatus.OK);
        }
    }
    
    
    @PostMapping("crear")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoSkill){
        if (StringUtils.isBlank(dtoSkill.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sSkill.existsByNombre(dtoSkill.getNombre())){
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        ESkill eSkill = new ESkill(
                                                    dtoSkill.getNombre(),
                                                    dtoSkill.getPorcentaje()
                                                    );
        sSkill.save(eSkill);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoSkill){
        //Validamos si existe el ID
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        //Compara nombre de experiencias
        if(sSkill.existsByNombre(dtoSkill.getNombre()) && sSkill.getByNombre(dtoSkill.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if(StringUtils.isBlank(dtoSkill.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        ESkill eSkill = sSkill.getOne(id).get();
        eSkill.setNombre(dtoSkill.getNombre());
        eSkill.setPorcentaje((dtoSkill.getPorcentaje()));
        
        sSkill.save(eSkill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
             
    }
    
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el ID
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        } else {
        sSkill.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
        }
    }
    
   
}