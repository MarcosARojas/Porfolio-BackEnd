/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.PRM.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Marcos
 */
public class DtoExperiencia {
    @NotBlank
    private String puesto;
    
    @NotBlank
    private String empresa;
    
    @NotBlank
    private String periodo;
    
    @NotBlank
    private String descripcion;
    

    public DtoExperiencia() {
    }

    public DtoExperiencia(String puesto, String empresa, String periodo, String descripcion, String urlfoto) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.periodo = periodo;
        this.descripcion = descripcion;
    }
    
    //Getter and Setter

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
}
