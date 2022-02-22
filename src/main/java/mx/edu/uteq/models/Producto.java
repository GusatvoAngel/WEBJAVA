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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author usuario
 */
@Data
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id_prod;
    @NotEmpty
    @NotNull(message = "Debes especificar el nombre")
    @Size(min = 1, max = 50, message = "El nombre debe medir entre 1 y 50")
    public String nom_prod;
    @NotNull
    @Min(value = 0, message = "El precio mínimo es 0")
    public float costo_prod;
    @NotNull
    @Min(value = 0, message = "El precio mínimo es 0")
    public float precio_prod;
    @NotNull
    @Min(value = 0, message = "El precio mínimo es 0")
    public int cantidad_prod;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cat")
    @NotNull
    public Categoria id_cat;
}
