/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IVentasDao;
import mx.edu.uteq.models.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author usuario
 */
@Service
public class VentasServiceImp implements IVentasService{

    @Autowired
    private IVentasDao ventasdao;

    @Override
    @Transactional(readOnly = true)
    public List<Ventas> listarVentas() {
        return ventasdao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Ventas ventas) {
         ventasdao.save(ventas);
    }

    @Override
    @Transactional
    public void eliminar(Ventas ventas) {
        ventasdao.delete(ventas);
    }

    @Override
    @Transactional(readOnly = true)
    public Ventas encontrarVentas(Ventas ventas) {
        return ventasdao.findById(ventas.getId_vta()).orElse(null);
    }
    
    
}
