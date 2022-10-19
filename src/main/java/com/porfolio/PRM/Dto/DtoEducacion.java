/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.PRM.Dto;

import javax.validation.constraints.NotBlank;


public class DtoEducacion {
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String institucion;
    
    @NotBlank
    private String periodo;

    public DtoEducacion() {
    }

    public DtoEducacion(String titulo, String institucion, String periodo) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.periodo = periodo;
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
