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
@Table (name ="experiencia")
public class EExperiencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size (min = 1, max = 75, message="El nombre no cumple con la longitud.")
    private String puesto;
    
    @NotNull
    @Size(min=1,max=50, message="El nombre no cumple con la longitud.")
    private String empresa;
    
    @NotNull
    @Size(min=1,max=50, message="El periodo no cumple con la longitud.")
    private String periodo;
    
    @NotNull
    @Size(min=1,max=50, message="El nombre no cumple con la longitud.")
    private String descripcion;
    

    public EExperiencia() {
    }

    public EExperiencia(String puesto, String empresa, String periodo, String descripcion) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.periodo = periodo;
        this.descripcion = descripcion;
    }
    
    
    
}











/*------------------------------------------------------------------------------
@Getter @Setter
@Entity
@Table (name ="experiencia")
public class EExperiencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size (min = 1, max = 75, message="El nombre no cumple con la longitud.")
    private String puesto;
    
    @NotNull
    @Size(min=1,max=50, message="El nombre no cumple con la longitud.")
    private String empresa;
    
    @NotNull
    @Size(min=1,max=50, message="El periodo no cumple con la longitud.")
    private String periodo;
    
    @NotNull
    @Size(min=1,max=50, message="El nombre no cumple con la longitud.")
    private String descripcion;
    
    @Size(min=1,max=250, message="La descripcion no cumple con la longitud.")
    private String urlfoto;
    
    /*public EExperiencia(){
        
    }
    
    public EExperiencia(String puesto, String empresa, String periodo, String descripcion, String urlfoto){
        this.puesto = puesto;
        this.empresa = empresa;
        this.periodo = periodo; 
        this.descripcion = descripcion;
        this.urlfoto= urlfoto;
    }
    
}*/