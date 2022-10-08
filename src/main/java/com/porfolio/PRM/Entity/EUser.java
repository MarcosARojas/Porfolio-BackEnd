package com.porfolio.PRM.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table (name ="usuario")
public class EUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size (min = 1, max = 50, message="El nombre no cumple con la longitud.")
    private String nombre;
    
    @NotNull
    @Size(min=1,max=50, message="El nombre no cumple con la longitud.")
    private String apellido;
    
    @NotNull
    @Size(min=1,max=100, message="El nombre no cumple con la longitud.")
    private String email;
    
    @NotNull
    @Size(min=1,max=50, message="El nombre no cumple con la longitud.")
    private String titulo;
    
    @NotNull
    @Size(min=1,max=250, message="La descripcion no cumple con la longitud.")
    private String descripcion;
    
    @Size(max=250, message="El link es muy largo.")
    private String urlPerfil;
    
    @Size(max=250, message="El link es muy largo.")
    private String urlBanner;
    
    @Size(max=250, message="El link es muy largo.")
    private String uLinkedin;
    
    @Size(max=250, message="El link es muy largo.")
    private String uInstagram;
    
    @Size(max=250, message="El link es muy largo.")
    private String uFacebook;
    
    @Size(max=250, message="El link es muy largo.")
    private String uGitHub;
}

