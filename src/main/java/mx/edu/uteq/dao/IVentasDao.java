/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import mx.edu.uteq.models.Ventas;
/**
 *
 * @author usuario
 */
public interface IVentasDao extends JpaRepository<Ventas, Long>  {
    
}
