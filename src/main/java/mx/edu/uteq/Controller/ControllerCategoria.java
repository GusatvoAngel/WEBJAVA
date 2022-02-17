/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.Controller;

import java.util.List;
import mx.edu.uteq.models.Categoria;
import mx.edu.uteq.service.ICategoriaService;
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
public class ControllerCategoria {
    
   @RequestMapping("categoria/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "cliente/index";
    }
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("admin/usuario/")
    public String listaCategoria(Model model) {
        List<Categoria> usuarios = categoriaService.listarCategoria();
        model.addAttribute("usuario", usuarios);
        return "admin/table-datatable";
    }

    @PostMapping("admin/agregar-usuario/")
    public String agregarCategoria(Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/admin/usuario";
    }
    
    @GetMapping("admin/editarUsuario/{idUsuario}")
    public String editarCategoria(Categoria categoria,Model model) {
        categoria= categoriaService.encontrarCategoria(categoria);
         model.addAttribute("categoria", categoria);
        return "admin/table-datatable";
    }
    
    @GetMapping("admin/borrar/{idUsuario}")
    public String borrarCategoria(Categoria categoria) {
        categoriaService.eliminar(categoria);
        return "admin/table-datatable";
    }
    
}
