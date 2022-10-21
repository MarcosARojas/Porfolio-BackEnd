package com.porfolio.PRM.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class EEducacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size (min = 1, max = 75, message="El nombre no cumple con la longitud.")
    private String titulo;
    
    @NotNull
    @Size (min = 1, max = 100, message="El nombre no cumple con la longitud.")
    private String institucion;
    
    @NotNull
    @Size (min = 1, max = 75, message="El periodo no cumple con la longitud.")
    private String periodo;

    public EEducacion() {
    }

    public EEducacion(String titulo, String institucion, String periodo) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    
    
}
