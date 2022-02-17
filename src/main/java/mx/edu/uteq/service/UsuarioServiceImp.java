/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IUsuarioDao;
import mx.edu.uteq.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author usuario
 */
@Service
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuariodao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuario() {
        return usuariodao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuariodao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        usuariodao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuariodao.findById(usuario.getId_usu()).orElse(null);

    }

}
