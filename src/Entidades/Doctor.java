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
public class Doctor {
    private int Id_Doc;
    private String Nom_doc;
    private String Ape_doc;
    private String Rut_doc;
    private String Fono_doc;
    private String Mail_doc;
    private String Dire_doc;
    private int Id_tipo_usuario;
     
            
    public Doctor() {
    }

    public Doctor(int Id_Doc, String Nom_doc, String Ape_doc, String Rut_doc, String Fono_doc, String Mail_doc, String Dire_doc, int Id_tipo_usuario, TipoUsuario TipoUsuariox) {
        this.Id_Doc = Id_Doc;
        this.Nom_doc = Nom_doc;
        this.Ape_doc = Ape_doc;
        this.Rut_doc = Rut_doc;
        this.Fono_doc = Fono_doc;
        this.Mail_doc = Mail_doc;
        this.Dire_doc = Dire_doc;
        this.Id_tipo_usuario = Id_tipo_usuario;
    }

    public int getId_Doc() {
        return Id_Doc;
    }

    public void setId_Doc(int Id_Doc) {
        this.Id_Doc = Id_Doc;
    }

    public String getNom_doc() {
        return Nom_doc;
    }

    public void setNom_doc(String Nom_doc) {
        this.Nom_doc = Nom_doc;
    }

    public String getApe_doc() {
        return Ape_doc;
    }

    public void setApe_doc(String Ape_doc) {
        this.Ape_doc = Ape_doc;
    }

    public String getRut_doc() {
        return Rut_doc;
    }

    public void setRut_doc(String Rut_doc) {
        this.Rut_doc = Rut_doc;
    }

    public String getFono_doc() {
        return Fono_doc;
    }

    public void setFono_doc(String Fono_doc) {
        this.Fono_doc = Fono_doc;
    }

    public String getMail_doc() {
        return Mail_doc;
    }

    public void setMail_doc(String Mail_doc) {
        this.Mail_doc = Mail_doc;
    }

    public String getDire_doc() {
        return Dire_doc;
    }

    public void setDire_doc(String Dire_doc) {
        this.Dire_doc = Dire_doc;
    }

    public int getId_tipo_usuario() {
        return Id_tipo_usuario;
    }

    public void setId_tipo_usuario(int Id_tipo_usuario) {
        this.Id_tipo_usuario = Id_tipo_usuario;
    }

    @Override
    public String toString() {
        return  Ape_doc;
    }
     
    
}
