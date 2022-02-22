/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package mx.edu.uteq.Controller;

import  mx.edu.uteq.dto.UsuarioRegistroDTO;
import  mx.edu.uteq.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lenovo L460
 */
@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {
    @Autowired
    private IUsuarioService usuarioServicio;
    
    
    public RegistroUsuarioControlador(IUsuarioService usuarioServicio){
        super();
        this.usuarioServicio = usuarioServicio;
    }
    
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO(){
        return new UsuarioRegistroDTO();
    }
    
    @GetMapping
    public String mostrarFormularioRegistro(){
        return "auth-register";
    }
    
    @PostMapping
    public String registrasCuentaUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO){
        usuarioServicio.guardar(registroDTO);
        return "auth-login";
    }
    
}
