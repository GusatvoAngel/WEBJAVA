/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.Controller;

import java.util.List;
import javax.validation.Valid;
import mx.edu.uteq.models.Usuario;
import mx.edu.uteq.models.Ventas;
import mx.edu.uteq.service.IVentasService;
import mx.edu.uteq.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author usuario
 */
@Controller
public class ControllerVentas {

    @RequestMapping("ventas/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "index";
    }
    @Autowired
    private IVentasService ventasService;

    @Autowired
    private IUsuarioService iUsuarioService;

    @GetMapping("admin/ventas/")
    public String listaVentas(Model model) {
        List<Ventas> ventas = ventasService.listarVentas();
        model.addAttribute("ventas", ventas);
        return "admin/ventas";
    }

    @GetMapping("admin/agregarVentas/")
    public String agregarVentasPage(Ventas ventas, Model model) {
        List<Usuario> usuarios = iUsuarioService.listarUsuario();
        model.addAttribute("usuarios2", usuarios);
        return "/admin/agregarVentas";
    }

    @PostMapping("admin/agregarVentas/")
    public String agregarVentas(@Valid Ventas ventas, Errors error, Model model) {
        if (error.hasErrors()) {
            List<Usuario> usuarios = iUsuarioService.listarUsuario();
            model.addAttribute("usuarios2", usuarios);
            return "admin/agregarVentas";
        }
        ventasService.guardar(ventas);
        return "redirect:/admin/ventas/";
    }

    @GetMapping("/admin/editarVentas/{id_vta}")
    public String editarVentas(Ventas ventas, Model model) {
        ventas = ventasService.encontrarVentas(ventas);
        model.addAttribute("ventas", ventas);
        List<Usuario> usuarios = iUsuarioService.listarUsuario();
        model.addAttribute("usuario", usuarios);
        return "admin/modificarVentas";
    }

    @GetMapping("admin/borrar/{idVentas}")
    public String borrarVentas(Ventas ventas) {
        ventasService.eliminar(ventas);
        return "admin/table-datatable";
    }
}
