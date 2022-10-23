package com.porfolio.PRM.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table (name ="usuario")
public class EUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
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
    
    @Size(max=500, message="El link es muy largo.")
    private String urlPerfil;
    
    @Size(max=500, message="El link es muy largo.")
    private String urlBanner;
    
    @Size(max=500, message="El link es muy largo.")
    private String uLinkedin;
    
    @Size(max=500, message="El link es muy largo.")
    private String uInstagram;
    
    @Size(max=500, message="El link es muy largo.")
    private String uFacebook;
    
    @Size(max=500, message="El link es muy largo.")
    private String uGitHub;
    
    //constructor

    public EUser() {
    }

    public EUser(String nombre, String apellido, String email, String titulo, String descripcion, String urlPerfil, String urlBanner, String uLinkedin, String uInstagram, String uFacebook, String uGitHub) {
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

    
    //Getter and setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

