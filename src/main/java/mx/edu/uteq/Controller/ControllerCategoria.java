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
public class ControllerCategoria {
    
   @RequestMapping("categoria/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "cliente/index";
    }
    
}
