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
    public String agregarUsuarios(@Valid UsuarioRegistroDTO registroDTO, Errors error,Model model) {
        if (error.hasErrors()) {
            return "admin/agregarUsuario";
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

    @GetMapping("/admin/editarUsuario/{id_usu}")
    public String editarUsuarios(Usuario usuario, Model model) {
        usuario = usuarioService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "admin/modificarUsuario";
    }

//    @GetMapping("/admin/recuperarContrasena/{correo}/{nom_usu}")
//    public String recuperarContrasena(@RequestParam Map<String, String> requestParams, Model model) {
//        String correo = requestParams.get("correo");
//        String nom_usu = requestParams.get("nom_usu");
//        usuario = usuarioService.recuperarPass(correo,nom_usu);
//        model.addAttribute("usuario", usuario);
//        return "admin/modificarUsuario";
//    }
    @GetMapping("admin/borrar/{idUsuario}")
    public String borrarUsuarios(Usuario usuario) {
        usuarioService.eliminar(usuario);
        return "admin/table-datatable";
    }

    @GetMapping("usuario/about.html")
    public String about(Model model) {
        return "cliente/about";
    }

    @GetMapping("usuario/service.html")
    public String service(Model model) {
        return "cliente/service";
    }

    @GetMapping("usuario/busqueda.html")
    public String menu(Model model) {
        return "cliente/busqueda";
    }

    @GetMapping("usuario/booking.html")
    public String booking(Model model) {
        return "cliente/booking.html";
    }

    @GetMapping("usuario/team.html")
    public String team(Model model) {
        return "cliente/team";
    }

    @GetMapping("usuario/testimonial.html")
    public String testimonial(Model model) {
        return "cliente/testimonial";
    }

    @GetMapping("usuario/contact.html")
    public String contact(Model model) {
        return "cliente/contact";
    }

    @GetMapping("usuario/index.html")
    public String index(Model model) {
        return "cliente/index";
    }

    @GetMapping("usuario/login.html")
    public String login(Model model) {
        return "redirect:/login";
    }
    
    @GetMapping("usuario/registro.html")
    public String registro(Model model) {
        return "redirect:/registro";
    }
    
    @GetMapping("admin/")
    public String pageAdmin(Model model) {
        return "redirect:/admin/producto/";
    }

    @GetMapping("usuario/")
    public String pageUsuario(Model model) {
        return "cliente/index";
    }
     @GetMapping("/recuperar")
    public String pageRecuUsuario(Model model) {
        return "auth-forgot-password";
    }
}
