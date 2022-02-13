/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author usuario
 */
@Data
@Entity
@Table(name = "det_vta")
public class Detvta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idDv;
    public Long idVta;
    public Long idProd;
    public int cant;
}
