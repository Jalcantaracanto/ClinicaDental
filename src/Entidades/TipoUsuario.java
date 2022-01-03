/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Zuukens
 */
public class TipoUsuario {
    private int Id_tipo_usuario;
    private String Nom_tipo_usuario;

    public TipoUsuario() {
    }

    public TipoUsuario(int Id_tipo_usuario, String Nom_tipo_usuario) {
        this.Id_tipo_usuario = Id_tipo_usuario;
        this.Nom_tipo_usuario = Nom_tipo_usuario;
    }

    public int getId_tipo_usuario() {
        return Id_tipo_usuario;
    }

    public void setId_tipo_usuario(int Id_tipo_usuario) {
        this.Id_tipo_usuario = Id_tipo_usuario;
    }

    public String getNom_tipo_usuario() {
        return Nom_tipo_usuario;
    }

    public void setNom_tipo_usuario(String Nom_tipo_usuario) {
        this.Nom_tipo_usuario = Nom_tipo_usuario;
    }

    @Override
    public String toString() {
        return Nom_tipo_usuario;
    }
    
}
