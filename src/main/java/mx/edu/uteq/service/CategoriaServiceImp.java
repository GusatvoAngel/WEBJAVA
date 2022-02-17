/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.ICategoriaDao;
import mx.edu.uteq.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author usuario
 */
@Service
public class CategoriaServiceImp implements ICategoriaService{

    @Autowired
    private ICategoriaDao categoriadao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listarCategoria() {
        return categoriadao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Categoria categoria) {
          categoriadao.save(categoria);
    }

    @Override
    public void eliminar(Categoria categoria) {
         categoriadao.delete(categoria);
    }

    @Override
    public Categoria encontrarCategoria(Categoria categoria) {
      return categoriadao.findById(categoria.getId_cat()).orElse(null);
    }

    
}
