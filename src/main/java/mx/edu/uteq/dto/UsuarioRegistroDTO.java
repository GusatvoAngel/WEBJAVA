/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dto;

public class UsuarioRegistroDTO {

    private long id_usu;
    
    private String correo;

    private String nom_usu;

    private String pass;

    private String tipo_usu;

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

    public UsuarioRegistroDTO(String correo, String nom_usu, String pass, String tipo_usu) {
        this.correo = correo;
        this.nom_usu = nom_usu;
        this.pass = pass;
        this.tipo_usu = tipo_usu;
    }

    public UsuarioRegistroDTO() {
    }

    


}

//id_usu, nom_usu, pass, tipo_usu, correo
