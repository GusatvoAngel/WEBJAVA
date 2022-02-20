/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.Controller;

import java.util.List;
import javax.validation.Valid;
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
public class ControllerCategoria {


    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("admin/categoria/")
    public String listaCategoria(Model model) {
        List<Categoria> categoria = categoriaService.listarCategoria();
        model.addAttribute("categoria", categoria);
        return "admin/categoria";
    }
    
    @GetMapping("admin/agregarCategoria/")
    public String agregarCategoriaPage(Categoria categoria ) {
        return "admin/modificarCategoria";
    }
    
    @PostMapping("admin/agregarCategoria/")
    public String agregarCategoria(@Valid Categoria categoria, Errors error) {
        if (error.hasErrors()) {
            return "admin/modificarCategoria";
        }
        categoriaService.guardar(categoria);
       return "redirect:/admin/categoria/";
    }

    @GetMapping("/admin/editarCategoria/{id_cat}")
    public String editarCategoria(Categoria categoria, Model model) {
        categoria = categoriaService.encontrarCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "admin/modificarCategoria";
    }

    @GetMapping("admin/borrarcategoria/{id_cat}")
    public String borrarCategoria(Categoria categoria) {
        categoriaService.eliminar(categoria);
        return "admin/categoria";
    }

}
