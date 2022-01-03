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
public class Empleado {
    private int Id_empleado;
    private String Nom_emp;
    private String Ape_emp;
    private String Rut_emp;
    private String Fono_emp;
    private String Dire_emp;
    private String Mail_emp;
    private int Id_clinica;
    private int Id_tipo_usuario;
    private String Pass_emp;
    

    public Empleado() {
    }

    public Empleado(int Id_empleado, String Nom_emp, String Ape_emp, String Rut_emp, String Fono_emp, String Dire_emp, String Mail_emp, int Id_clinica, int Id_tipo_usuario, String Pass_emp) {
        this.Id_empleado = Id_empleado;
        this.Nom_emp = Nom_emp;
        this.Ape_emp = Ape_emp;
        this.Rut_emp = Rut_emp;
        this.Fono_emp = Fono_emp;
        this.Dire_emp = Dire_emp;
        this.Mail_emp = Mail_emp;
        this.Id_clinica = Id_clinica;
        this.Id_tipo_usuario = Id_tipo_usuario;
        this.Pass_emp = Pass_emp;
    }

    public int getId_empleado() {
        return Id_empleado;
    }

    public void setId_empleado(int Id_empleado) {
        this.Id_empleado = Id_empleado;
    }

    public String getNom_emp() {
        return Nom_emp;
    }

    public void setNom_emp(String Nom_emp) {
        this.Nom_emp = Nom_emp;
    }

    public String getApe_emp() {
        return Ape_emp;
    }

    public void setApe_emp(String Ape_emp) {
        this.Ape_emp = Ape_emp;
    }

    public String getRut_emp() {
        return Rut_emp;
    }

    public void setRut_emp(String Rut_emp) {
        this.Rut_emp = Rut_emp;
    }

    public String getFono_emp() {
        return Fono_emp;
    }

    public void setFono_emp(String Fono_emp) {
        this.Fono_emp = Fono_emp;
    }

    public String getDire_emp() {
        return Dire_emp;
    }

    public void setDire_emp(String Dire_emp) {
        this.Dire_emp = Dire_emp;
    }

    public String getMail_emp() {
        return Mail_emp;
    }

    public void setMail_emp(String Mail_emp) {
        this.Mail_emp = Mail_emp;
    }

    public int getId_clinica() {
        return Id_clinica;
    }

    public void setId_clinica(int Id_clinica) {
        this.Id_clinica = Id_clinica;
    }

    public int getId_tipo_usuario() {
        return Id_tipo_usuario;
    }

    public void setId_tipo_usuario(int Id_tipo_usuario) {
        this.Id_tipo_usuario = Id_tipo_usuario;
    }

    public String getPass_emp() {
        return Pass_emp;
    }

    public void setPass_emp(String Pass_emp) {
        this.Pass_emp = Pass_emp;
    }

    @Override
    public String toString() {
        return "Empleado{" + "Id_empleado=" + Id_empleado + ", Nom_emp=" + Nom_emp + ", Ape_emp=" + Ape_emp + ", Rut_emp=" + Rut_emp + ", Fono_emp=" + Fono_emp + ", Dire_emp=" + Dire_emp + ", Mail_emp=" + Mail_emp + ", Id_clinica=" + Id_clinica + ", Id_tipo_usuario=" + Id_tipo_usuario + ", Pass_emp=" + Pass_emp + '}';
    }

}
