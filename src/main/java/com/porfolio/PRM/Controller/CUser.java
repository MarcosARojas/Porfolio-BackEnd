package com.porfolio.PRM.Controller;

import com.porfolio.PRM.Entity.EUser;
import com.porfolio.PRM.Service.SUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CUser {
    @Autowired SUser sUser;
    
    @GetMapping()
    public List<EUser> getUser(@PathVariable Long id){
        return sUser.getUser();
    }
    
    @PreAuthorize("hasRole('admin')")
    @PostMapping("user/crear")
    public String createEUser(@RequestBody EUser eUser){
        sUser.saveUser(eUser);
        return "La persona fue creada con exito";
    }
    
    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("user/borrar/{id}")
    public String deleteEUser(@PathVariable Long id){
        sUser.deleteUser(id);
        return "Fue borrado con exito";
    }
    
    @PreAuthorize("hasRole('admin')")
    @PutMapping("user/editar/{id}")
    public EUser editEUser(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("email") String nuevoEmail,
                               @RequestParam("titulo") String nuevoTitulo,
                               @RequestParam("descripcion") String nuevoDescripcion,
                               @RequestParam("urlPerfil") String nuevoUrlPerfil,
                               @RequestParam("urlBanner") String nuevoUrlBanner,
                               @RequestParam("uLinkedin") String nuevoULinkedin,
                               @RequestParam("uFacebook") String nuevoUFacebook,
                               @RequestParam("uGithub") String nuevoUGithub,
                               @RequestParam("uInstagram") String nuevoUInstagram){
        
        EUser eUser = sUser.findUser(id);
        
        eUser.setNombre(nuevoNombre);
        eUser.setApellido(nuevoApellido);
        eUser.setEmail(nuevoEmail);
        eUser.setTitulo(nuevoTitulo);
        eUser.setDescripcion(nuevoDescripcion);
        eUser.setUrlPerfil(nuevoUrlPerfil);
        eUser.setUrlBanner(nuevoUrlBanner);
        eUser.setULinkedin(nuevoULinkedin);
        eUser.setUInstagram(nuevoUInstagram);
        eUser.setUFacebook(nuevoUFacebook);
        eUser.setUGitHub(nuevoUGithub);
        
        sUser.saveUser(eUser);
        
        return eUser;
    }
    
    @GetMapping("user/traer/")
    public EUser findPersona(){
        return sUser.findUser((long)1);
    }
}
