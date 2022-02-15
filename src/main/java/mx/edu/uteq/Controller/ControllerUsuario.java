/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.Controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author usuario
 */
@Controller
public class ControllerUsuario {

    @RequestMapping("usuario/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "cliente/index";
    }

    @GetMapping("usuario/about.html")
    public String about(Model model) {
        return "cliente/about";
    }
 @GetMapping("usuario/service.html")
    public String service(Model model) {
        return "cliente/service";
    }
    @GetMapping("usuario/menu.html")
    public String menu(Model model) {
        return "cliente/menu";
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
     @GetMapping("admin/")
    public String pageAdmin(Model model) {
        return "auth-register";
    }
}
