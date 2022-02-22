/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.models.Usuario;
import mx.edu.uteq.dto.UsuarioRegistroDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
/**
 *
 * @author usuario
 */
public interface IUsuarioService extends UserDetailsService{
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    public List<Usuario> listarUsuarios();
    public void eliminar(Usuario usuario); 
    public Usuario encontrarUsuario(Usuario usuario);
    public void guardarv2(Usuario usuario);
}
