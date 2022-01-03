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
public class Proveedor {
    private int Id_proveedor;
    private String Rut_proveedor;
    private String Nom_proveedor;
    private String Fono_proveedor;
    private String Dire_proveedor;
    private String Mail_proveedor;
    
    public Proveedor() {
    }

    public Proveedor(int Id_proveedor, String Rut_proveedor, String Rubro_proveedor, String Nom_proveedor, String Fono_proveedor, String Dire_proveedor, String Mail_proveedor) {
        this.Id_proveedor = Id_proveedor;
        this.Rut_proveedor = Rut_proveedor;
        this.Nom_proveedor = Nom_proveedor;
        this.Fono_proveedor = Fono_proveedor;
        this.Dire_proveedor = Dire_proveedor;
        this.Mail_proveedor = Mail_proveedor;
    }

    public int getId_proveedor() {
        return Id_proveedor;
    }

    public void setId_proveedor(int Id_proveedor) {
        this.Id_proveedor = Id_proveedor;
    }

    public String getRut_proveedor() {
        return Rut_proveedor;
    }

    public void setRut_proveedor(String Rut_proveedor) {
        this.Rut_proveedor = Rut_proveedor;
    }


    public String getNom_proveedor() {
        return Nom_proveedor;
    }

    public void setNom_proveedor(String Nom_proveedor) {
        this.Nom_proveedor = Nom_proveedor;
    }

    public String getFono_proveedor() {
        return Fono_proveedor;
    }

    public void setFono_proveedor(String Fono_proveedor) {
        this.Fono_proveedor = Fono_proveedor;
    }

    public String getDire_proveedor() {
        return Dire_proveedor;
    }

    public void setDire_proveedor(String Dire_proveedor) {
        this.Dire_proveedor = Dire_proveedor;
    }

    public String getMail_proveedor() {
        return Mail_proveedor;
    }

    public void setMail_proveedor(String Mail_proveedor) {
        this.Mail_proveedor = Mail_proveedor;
    }

    @Override
    public String toString() {
        return Nom_proveedor;
    }

    

    
}
