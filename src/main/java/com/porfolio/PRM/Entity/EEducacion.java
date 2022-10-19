package com.porfolio.PRM.Entity;

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
@Table (name ="educacion")
public class EEducacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size (min = 1, max = 75, message="El nombre no cumple con la longitud.")
    private String titulo;
    
    @NotNull
    @Size (min = 1, max = 75, message="El nombre no cumple con la longitud.")
    private String institucion;
    
    @NotNull
    @Size (min = 1, max = 75, message="El nombre no cumple con la longitud.")
    private String periodo;

    public EEducacion() {
    }

    public EEducacion(String titulo, String institucion, String periodo) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.periodo = periodo;
    }
    
    
    
}
