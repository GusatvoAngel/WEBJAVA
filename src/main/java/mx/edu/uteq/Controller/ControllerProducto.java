/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author usuario
 */
@Controller
public class ControllerProducto {

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
        return "/admin/agregarProducto";
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
}
