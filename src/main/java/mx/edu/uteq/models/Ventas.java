/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author usuario
 */
@Data
@Entity
@Table(name = "venta")
public class Ventas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id_vta;
    
    @Column(name = "fecha_hr")
    @Temporal(TemporalType.TIMESTAMP)
   
    private Date fecha_hr;
    
    @PrePersist
    @PreUpdate
    public void prePersist() {
        fecha_hr = new Date();
    }
    @NotNull
    @Min(value = 0, message = "El precio mínimo es 0")
    public float total_pagado;

    //Es foranea investegir como se relaciona
    @ManyToOne(optional=false)
    @JoinColumn(name="id_usu")
    @NotNull
    public Usuario id_usu;
}
