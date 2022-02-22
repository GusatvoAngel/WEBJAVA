/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.models;

import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import mx.edu.uteq.dto.UsuarioRegistroDTO;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usu;

    private String correo;

    @Column(name = "nom_usu")
    private String nom_usu;

    private String pass;

    @Column(name = "tipo_usu")
    private String tipo_usu;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "id_usu", referencedColumnName = "id_usu"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    )
    private Collection<Rol> roles;

    public long getId_usu() {
        return id_usu;
    }

    public void setId_usu(long id_usu) {
        this.id_usu = id_usu;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo_usu() {
        return tipo_usu;
    }

    public void setTipo_usu(String tipo_usu) {
        this.tipo_usu = tipo_usu;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    public Usuario(long id_usu, String correo, String pass, String tipo_usu, Collection<Rol> roles) {
        this.id_usu = id_usu;
        this.correo = correo;
        this.pass = pass;
        this.tipo_usu = tipo_usu;
        this.roles = roles;
    }

    public Usuario(String correo, String nom_usu, String pass, String tipo_usu, Collection<Rol> roles) {
        this.correo = correo;
        this.nom_usu = nom_usu;
        this.pass = pass;
        this.tipo_usu = tipo_usu;
        this.roles = roles;
    }

    public Usuario(long id_usu, String correo, String nom_usu, String pass, String tipo_usu) {
        this.id_usu = id_usu;
        this.correo = correo;
        this.nom_usu = nom_usu;
        this.pass = pass;
        this.tipo_usu = tipo_usu;
    }


    public Usuario() {
    }

    

}
