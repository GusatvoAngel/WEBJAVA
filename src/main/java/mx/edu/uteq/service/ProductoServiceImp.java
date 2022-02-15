/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IProductoDao;
import mx.edu.uteq.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author usuario
 */
@Service
public class ProductoServiceImp implements IProductoService{

    @Autowired
    private IProductoDao productodao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProducto() {
        return productodao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Producto producto) {
         productodao.save(producto);
    }

    @Override
    @Transactional
    public void eliminar(Producto producto) {
        productodao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto encontrarProducto(Producto producto) {
        return productodao.findById(producto.getIdProd()).orElse(null);
    }
    
}
