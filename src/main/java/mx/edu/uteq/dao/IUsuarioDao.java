/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import mx.edu.uteq.models.Usuario;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    public Usuario findByCorreo(String correo);

}
