/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.models.Producto;

/**
 *
 * @author usuario
 */
public interface IProductoService {
    public List<Producto> listarProducto(); 
    public void guardar(Producto producto); 
    public void eliminar(Producto producto); 
    public Producto encontrarProducto(Producto producto); 
}
