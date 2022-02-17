/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.models.Categoria;

/**
 *
 * @author usuario
 */
public interface ICategoriaService {
    public List<Categoria> listarCategoria(); 
    public void guardar(Categoria categoria); 
    public void eliminar(Categoria categoria); 
    public Categoria encontrarCategoria(Categoria categoria); 
}
