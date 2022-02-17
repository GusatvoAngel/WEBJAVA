/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IDetvtaDao;
import mx.edu.uteq.models.Detvta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author usuario
 */
@Service
public class DetvtaServiceImp implements IDetvtaService{
     @Autowired
    private IDetvtaDao detvtadao;
     
    @Override
    @Transactional(readOnly = true)
    public List<Detvta> listarDetvta() {
         return detvtadao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Detvta detvta) {
        detvtadao.save(detvta);
    }

    @Override
    @Transactional
    public void eliminar(Detvta detvta) {
        detvtadao.delete(detvta);
    }

    @Override
    @Transactional(readOnly = true)
    public Detvta encontrarDetvta(Detvta detvta) {
        return detvtadao.findById(detvta.getId_dv()).orElse(null);
        
    }


    
}
