/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mx.edu.uteq.dao.IUsuarioDao;
import mx.edu.uteq.dto.UsuarioRegistroDTO;
import mx.edu.uteq.models.Rol;
import mx.edu.uteq.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioRepositorio;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioServiceImp(IUsuarioDao usuarioRepositoriDao) {
        super();
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getCorreo(),
                registroDTO.getNom_usu(),
                passwordEncoder.encode(registroDTO.getPass()),
                registroDTO.getTipo_usu(),
                Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByCorreo(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Credenciales invalidas");
        }
        return new User(usuario.getCorreo(), usuario.getPass(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public void eliminar(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }

    @Override
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuarioRepositorio.findById(usuario.getId_usu()).orElse(null);

    }

    @Override
    public void guardarv2(Usuario usuario) {
         usuario = new Usuario(usuario.getId_usu(),usuario.getCorreo(),
                usuario.getNom_usu(),
                passwordEncoder.encode(usuario.getPass()),
                usuario.getTipo_usu());
         usuarioRepositorio.save(usuario);
    }

}
