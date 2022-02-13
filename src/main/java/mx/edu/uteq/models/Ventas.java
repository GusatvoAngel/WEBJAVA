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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    public Long idVta;
    
    @Column(name = "fecha_hr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultModifica;
    
    @PrePersist
    public void prePersist() {
        ultModifica = new Date();
    }
    
    public float totalPagado;
    //Es foranea investegir como se relaciona
    public Long idUsu;
}
