/*package com.porfolio.PRM.Controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
@RestController
@RequestMapping("experiencia")
@CrossOrigin(origins = "http://localhost:4200/")
public class CExperiencia {
    @Autowired SExperiencia sExperiencia;
    
    @GetMapping("/lista/")
    public ResponseEntity<List<EExperiencia>>list(){
        List<EExperiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear/experiencia/")
    public ResponseEntity<?> creat(@RequestBody DtoExperiencia dtoExperiencia){
        if (StringUtils.isBlank(dtoExperiencia.getPuesto()))
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        if (sExperiencia.existsByPuesto(dtoExperiencia.getPuesto()))
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        EExperiencia eExperiencia = new EExperiencia(dtoExperiencia.getPuesto(),
                                                    dtoExperiencia.getEmpresa(),
                                                    dtoExperiencia.getPeriodo(),
                                                    dtoExperiencia.getDescripcion()
                                                    );
        sExperiencia.save(eExperiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    /*@PutMapping("/update/{id}")
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
    
}


*/






/*------------------------------------------------------------------------------
@Autowired SExperiencia sExperiencia;
    
    @GetMapping("experiencia")
    public List<EExperiencia> getUser(@PathVariable Long id){
        return sExperiencia.getExperiencia();
    }
    
    @PostMapping("experiencia/crear")
    public String createEExperiencia(@RequestBody EExperiencia eExperiencia){
        sExperiencia.saveExperiencia(eExperiencia);
        return "La experiencia fue creada con exito";
    }
    
    @DeleteMapping("experiencia/borrar/{id}")
    public String deleteEExperiencia(@PathVariable Long id){
        sExperiencia.deleteExperiencia(id);
        return "Fue borrado con exito";
    }
    
    @PutMapping("experiencia/editar/{id}")
    public EExperiencia editEExperiencia(@PathVariable Long id,
                               @RequestParam("puesto") String nuevoPuesto,
                               @RequestParam("empresa") String nuevoEmpresa,
                               @RequestParam("periodo") String nuevoPeriodo,
                               @RequestParam("descripcion") String nuevoDescripcion,
                               @RequestParam("urlfoto") String nuevoUrlfoto){
        
        EExperiencia eExperiencia = sExperiencia.findExperiencia(id);
        
        eExperiencia.setPuesto(nuevoPuesto);
        eExperiencia.setEmpresa(nuevoEmpresa);
        eExperiencia.setPeriodo(nuevoPeriodo);
        eExperiencia.setDescripcion(nuevoDescripcion);
        eExperiencia.setUrlfoto(nuevoUrlfoto);
        
        sExperiencia.saveExperiencia(eExperiencia);
        
        return eExperiencia;
    }
    
    @GetMapping("experiencia/traer/")
    public EExperiencia findExperiencia(){
        return sExperiencia.findExperiencia((long)2);
    }
*/