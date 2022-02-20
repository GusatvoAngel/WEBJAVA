/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import mx.edu.uteq.models.Usuario;
/**
 *
 * @author usuario
 */
public interface IUsuarioDao extends JpaRepository<Usuario, Long>  {
      Optional<Usuario> findByCorreo(String correo);

}
