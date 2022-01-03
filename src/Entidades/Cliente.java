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
public class Cliente {
    private int Id_cliente;
    private String Nom_cliente;
    private String Ape_cliente;
    private String Rut_cliente;
    private String Dire_cliente;
    private String Fono_cliente;
    private String Mail_cliente;
    private String Usuario_cliente;
    private String Password_cliente;
    private int Id_sit_eco;

    public Cliente() {
    }

    public Cliente(int Id_cliente, String Nom_cliente, String Ape_cliente, String Rut_cliente, String Dire_cliente, String Fono_cliente, String Mail_cliente, String Usuario_cliente, String Password_cliente, int id_sit_eco, SituacionEconomica SituacionEconomicax) {
        this.Id_cliente = Id_cliente;
        this.Nom_cliente = Nom_cliente;
        this.Ape_cliente = Ape_cliente;
        this.Rut_cliente = Rut_cliente;
        this.Dire_cliente = Dire_cliente;
        this.Fono_cliente = Fono_cliente;
        this.Mail_cliente = Mail_cliente;
        this.Usuario_cliente = Usuario_cliente;
        this.Password_cliente = Password_cliente;
        this.Id_sit_eco = id_sit_eco;
    }

    public int getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(int Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public String getNom_cliente() {
        return Nom_cliente;
    }

    public void setNom_cliente(String Nom_cliente) {
        this.Nom_cliente = Nom_cliente;
    }

    public String getApe_cliente() {
        return Ape_cliente;
    }

    public void setApe_cliente(String Ape_cliente) {
        this.Ape_cliente = Ape_cliente;
    }

    public String getRut_cliente() {
        return Rut_cliente;
    }

    public void setRut_cliente(String Rut_cliente) {
        this.Rut_cliente = Rut_cliente;
    }

    public String getDire_cliente() {
        return Dire_cliente;
    }

    public void setDire_cliente(String Dire_cliente) {
        this.Dire_cliente = Dire_cliente;
    }

    public String getFono_cliente() {
        return Fono_cliente;
    }

    public void setFono_cliente(String Fono_cliente) {
        this.Fono_cliente = Fono_cliente;
    }

    public String getMail_cliente() {
        return Mail_cliente;
    }

    public void setMail_cliente(String Mail_cliente) {
        this.Mail_cliente = Mail_cliente;
    }

    public String getUsuario_cliente() {
        return Usuario_cliente;
    }

    public void setUsuario_cliente(String Usuario_cliente) {
        this.Usuario_cliente = Usuario_cliente;
    }

    public String getPassword_cliente() {
        return Password_cliente;
    }

    public void setPassword_cliente(String Password_cliente) {
        this.Password_cliente = Password_cliente;
    }

    public int getId_sit_eco() {
        return Id_sit_eco;
    }

    public void setId_sit_eco(int id_sit_eco) {
        this.Id_sit_eco = id_sit_eco;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Id_cliente=" + Id_cliente + ", Nom_cliente=" + Nom_cliente + ", Ape_cliente=" + Ape_cliente + ", Rut_cliente=" + Rut_cliente + ", Dire_cliente=" + Dire_cliente + ", Fono_cliente=" + Fono_cliente + ", Mail_cliente=" + Mail_cliente + ", Usuario_cliente=" + Usuario_cliente + ", Password_cliente=" + Password_cliente + ", Id_sit_eco=" + Id_sit_eco + '}';
    }

}
