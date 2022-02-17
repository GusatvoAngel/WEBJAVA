/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.models.Ventas;

/**
 *
 * @author usuario
 */
public interface IVentasService {
    public List<Ventas> listarVentas(); 
    public void guardar(Ventas ventas); 
    public void eliminar(Ventas ventas); 
    public Ventas encontrarVentas(Ventas ventas); 
}
