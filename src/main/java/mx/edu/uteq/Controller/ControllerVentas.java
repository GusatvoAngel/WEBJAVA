/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.Controller;

import java.util.List;
import javax.validation.Valid;
import mx.edu.uteq.models.Ventas;
import mx.edu.uteq.service.IVentasService;
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

    @GetMapping("admin/ventas/")
    public String listaVentas(Model model) {
        List<Ventas> ventas = ventasService.listarVentas();
        model.addAttribute("ventas", ventas);
        return "admin/ventas";
    }

    @GetMapping("admin/agregarVentas/")
    public String agregarVentasPage(Ventas ventas) {
        return "admin/modificarVentas";
    }

    @PostMapping("admin/agregarVentas/")
    public String agregarVentas(@Valid Ventas ventas,Errors error) {
        if(error.hasErrors()){
            return "admin/modificarVentas";
        }
        ventasService.guardar(ventas);
        return "redirect:/admin/ventas/";
    }

    @GetMapping("admin/editarVentas/{idVentas}")
    public String editarVentas(Ventas ventas, Model model) {
        ventas = ventasService.encontrarVentas(ventas);
        model.addAttribute("usuario", ventas);
        return "admin/modificarVentas";
    }

    @GetMapping("admin/borrar/{idVentas}")
    public String borrarVentas(Ventas ventas) {
        ventasService.eliminar(ventas);
        return "admin/table-datatable";
    }
}
