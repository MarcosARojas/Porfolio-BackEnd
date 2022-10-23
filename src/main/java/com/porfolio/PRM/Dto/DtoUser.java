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
public class DtoUser {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String email;
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String urlPerfil;
    
    private String urlBanner;
    
    private String uLinkedin;
    
    private String uInstagram;
    
    private String uFacebook;
    
    private String uGitHub;

    public DtoUser() {
    }

    public DtoUser(String nombre, String apellido, String email, String titulo, String descripcion, String urlPerfil, String urlBanner, String uLinkedin, String uInstagram, String uFacebook, String uGitHub) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlPerfil = urlPerfil;
        this.urlBanner = urlBanner;
        this.uLinkedin = uLinkedin;
        this.uInstagram = uInstagram;
        this.uFacebook = uFacebook;
        this.uGitHub = uGitHub;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlPerfil() {
        return urlPerfil;
    }

    public void setUrlPerfil(String urlPerfil) {
        this.urlPerfil = urlPerfil;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public String getuLinkedin() {
        return uLinkedin;
    }

    public void setuLinkedin(String uLinkedin) {
        this.uLinkedin = uLinkedin;
    }

    public String getuInstagram() {
        return uInstagram;
    }

    public void setuInstagram(String uInstagram) {
        this.uInstagram = uInstagram;
    }

    public String getuFacebook() {
        return uFacebook;
    }

    public void setuFacebook(String uFacebook) {
        this.uFacebook = uFacebook;
    }

    public String getuGitHub() {
        return uGitHub;
    }

    public void setuGitHub(String uGitHub) {
        this.uGitHub = uGitHub;
    }
    
    
    
}
