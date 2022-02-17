/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.models.Usuario;

/**
 *
 * @author usuario
 */
public interface IUsuarioService {
    public List<Usuario> listarUsuario(); 
    public void guardar(Usuario usuario); 
    public void eliminar(Usuario usuario); 
    public Usuario encontrarUsuario(Usuario usuario);
}
