/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.Controller;

import java.util.List;
import mx.edu.uteq.models.Usuario;
import mx.edu.uteq.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author usuario
 */
@Controller
public class ControllerInventario {
    
   @RequestMapping("inventario/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "index";
    }
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("admin/usuario/")
    public String listaUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuario();
        model.addAttribute("usuario", usuarios);
        return "admin/table-datatable";
    }

    @PostMapping("admin/agregar-usuario/")
    public String agregarUsuarios(Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/admin/usuario";
    }
    
    @GetMapping("admin/editarUsuario/{idUsuario}")
    public String editarUsuarios(Usuario usuario,Model model) {
        usuario= usuarioService.encontrarUsuario(usuario);
         model.addAttribute("usuario", usuario);
        return "admin/table-datatable";
    }
    
    @GetMapping("admin/borrar/{idUsuario}")
    public String borrarUsuarios(Usuario usuario) {
        usuarioService.eliminar(usuario);
        return "admin/table-datatable";
    }
}
