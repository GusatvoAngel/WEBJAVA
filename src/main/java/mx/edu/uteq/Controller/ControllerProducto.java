/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.Controller;

import java.util.List;
import mx.edu.uteq.models.Producto;
import mx.edu.uteq.service.IProductoService;
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
public class ControllerProducto {
    
   @RequestMapping("producto/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "index";
    }
    
    @Autowired
    private IProductoService iProductoService;

    @GetMapping("admin/producto/")
    public String listaProducto(Model model) {
        List<Producto> producto = iProductoService.listarProducto();
        model.addAttribute("producto", producto);
        return "admin/table-datatable";
    }

    @PostMapping("admin/agregar-producto/")
    public String agregarProducto(Producto producto) {
        iProductoService.guardar(producto);
        return "redirect:/admin/usuario";
    }
   
    @GetMapping("admin/editarProducto/{idProducto}")
    public String editarProducto(Producto producto,Model model) {
        producto= iProductoService.encontrarProducto(producto);
         model.addAttribute("producto", producto);
        return "admin/table-datatable";
    }
    
    @GetMapping("admin/borrar/{idProducto}")
    public String borrarProducto(Producto producto) {
        iProductoService.eliminar(producto);
        return "admin/table-datatable";
    }
}
