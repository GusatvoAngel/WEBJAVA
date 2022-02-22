/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package mx.edu.uteq.Controller;

import java.util.List;
import javax.validation.Valid;
import mx.edu.uteq.models.Producto;
import mx.edu.uteq.service.IProductoService;
import mx.edu.uteq.models.Categoria;
import mx.edu.uteq.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllerDetvta {

    @RequestMapping("producto/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "index";
    }

    @Autowired
    private IProductoService iProductoService;

    @Autowired
    private ICategoriaService categoriaService;
    

    @GetMapping("admin/producto/")
    public String listaProducto(Model model) {
        List<Producto> producto = iProductoService.listarProducto();
        model.addAttribute("producto", producto);
        return "admin/producto";
    }

    @GetMapping("admin/agregarProducto/")
    public String agregarProductoPage(Producto producto, Model model) {
        List<Categoria> categoria = categoriaService.listarCategoria();
        model.addAttribute("categoria2", categoria);
        return "admin/agregarProducto";
    }

    @PostMapping("admin/agregarProducto/")
    public String agregarProducto(@Valid Producto producto, Errors error,Model model) {
        if (error.hasErrors()) {
            List<Categoria> categoria = categoriaService.listarCategoria();
            model.addAttribute("categoria2", categoria);
            return "admin/agregarProducto";
        }
        iProductoService.guardar(producto);
        return "redirect:/admin/producto/";
    }

    @GetMapping("/admin/editarProducto/{id_prod}")
    public String editarProducto(Producto producto, Model model) {
        producto = iProductoService.encontrarProducto(producto);
        model.addAttribute("producto", producto);
        
        List<Categoria> categoria = categoriaService.listarCategoria();
        model.addAttribute("categoria", categoria);
        return "admin/modificarProducto";
    }

    @GetMapping("admin/borrar/{idProducto}")
    public String borrarProducto(Producto producto) {
        iProductoService.eliminar(producto);
        return "admin/table-datatable";
    }
} */
///////////////////////////////////////////////////////////////////////////////////////////
package mx.edu.uteq.Controller;

import java.util.List;
import javax.validation.Valid;
import mx.edu.uteq.models.Detvta;
import mx.edu.uteq.service.IDetvtaService;
import mx.edu.uteq.models.Ventas;
import mx.edu.uteq.service.IVentasService;
import mx.edu.uteq.models.Producto;
import mx.edu.uteq.service.IProductoService;
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
public class ControllerDetvta {

    @RequestMapping("detvta/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "index";
    }

    @Autowired
    private IDetvtaService iDetvtaService;

    @Autowired
    private IProductoService iProductoService;

    @Autowired
    private IVentasService iVentasService;

    @GetMapping("admin/detvta/")
    public String listaDetvta(Model model) {
        List<Detvta> detvta = iDetvtaService.listarDetvta();
        model.addAttribute("detvta", detvta);
        return "admin/detvta";
    }

    @GetMapping("admin/agregarDetvta/")
    public String agregarDetvtaPage(Detvta detvta, Model model) {
        List<Producto> producto = iProductoService.listarProducto();
        model.addAttribute("producto2", producto);
        List<Ventas> ventas = iVentasService.listarVentas();
        model.addAttribute("ventas2", ventas);
        return "admin/agregarDetvta";
    }

    @PostMapping("admin/agregarDetvta/")
    public String agregarDetvta(@Valid Detvta detvta, Errors error, Model model) {
        if (error.hasErrors()) {
            List<Producto> producto = iProductoService.listarProducto();
            model.addAttribute("producto2", producto);
            List<Ventas> ventas = iVentasService.listarVentas();
            model.addAttribute("ventas2", ventas);
            return "admin/agregarDetvta";
        }
        iDetvtaService.guardar(detvta);
        return "redirect:/admin/detvta/";
    }

    @GetMapping("/admin/editarDetvta/{id_dv}")
    public String editarDetvta(Detvta detvta, Model model) {
        detvta = iDetvtaService.encontrarDetvta(detvta);
        model.addAttribute("detvta", detvta);

            List<Producto> producto = iProductoService.listarProducto();
            model.addAttribute("producto", producto);
            List<Ventas> ventas = iVentasService.listarVentas();
            model.addAttribute("ventas", ventas);
        return "admin/modificarDetvta";
    }

    @GetMapping("admin/borrar/{idDetvta}")
    public String borrarDetvta(Detvta detvta) {
        iDetvtaService.eliminar(detvta);
        return "admin/table-datatable";
    }
}
