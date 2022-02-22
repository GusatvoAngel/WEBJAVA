/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.edu.uteq.dto.UsuarioRegistroDTO;
import mx.edu.uteq.models.Usuario;
import mx.edu.uteq.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author usuario
 */
@Controller
@Slf4j
public class ControllerUsuario {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("admin/usuario/")
    public String listaUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "admin/usuarios";
    }

    @GetMapping("admin/agregarUsuario/")
    public String agregarUsuarioPage(Usuario usuario) {
        return "admin/agregarUsuario";
    }

    @PostMapping("admin/agregarUsuario/")
    public String agregarUsuarios(@Valid UsuarioRegistroDTO registroDTO, Errors error) {
        if (error.hasErrors()) {
            return "admin/modificarUsuario";
        }
        usuarioService.guardar(registroDTO);
        return "redirect:/admin/usuario/";
    }

    @PostMapping("admin/editarUsuario/")
    public String editarUsuarios(@Valid Usuario usuario, Errors error) {
        if (error.hasErrors()) {
            return "admin/modificarUsuario";
        }
        usuarioService.guardarv2(usuario);
        return "redirect:/admin/usuario/";
    }
//    @PostMapping("admin/agregarUsuario/")
//    public String agregarUsuarios(@Valid UsuarioRegistroDTO registroDTO, Errors error) {
//        if (error.hasErrors()) {
//            return "admin/modificarUsuario";
//        }
//        usuarioService.guardar(registroDTO);
//        return "redirect:/admin/usuario/";
//    }

    @GetMapping("/admin/editarUsuario/{id_usu}")
    public String editarUsuarios(Usuario usuario, Model model) {
        usuario = usuarioService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "admin/modificarUsuario";
    }

    @GetMapping("admin/borrar/{idUsuario}")
    public String borrarUsuarios(Usuario usuario) {
        usuarioService.eliminar(usuario);
        return "admin/table-datatable";
    }

    @RequestMapping("usuario/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "cliente/index";
    }

    @RequestMapping("/")
    public String usuario(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "redirect:/usuario/";
    }
}
