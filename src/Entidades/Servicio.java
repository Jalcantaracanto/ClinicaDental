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
public class Servicio {
    private int Id_servicio;
    private String Nom_servicio;
    private String Descripcion_servicio;
    private int Valor_servicio;

    public Servicio() {
    }

    public Servicio(int Id_servicio, String Nom_servicio, String Descripcion_servicio, int Valor_servicio) {
        this.Id_servicio = Id_servicio;
        this.Nom_servicio = Nom_servicio;
        this.Descripcion_servicio = Descripcion_servicio;
        this.Valor_servicio = Valor_servicio;
    }

    public int getId_servicio() {
        return Id_servicio;
    }

    public void setId_servicio(int Id_servicio) {
        this.Id_servicio = Id_servicio;
    }

    public String getNom_servicio() {
        return Nom_servicio;
    }

    public void setNom_servicio(String Nom_servicio) {
        this.Nom_servicio = Nom_servicio;
    }

    public String getDescripcion_servicio() {
        return Descripcion_servicio;
    }

    public void setDescripcion_servicio(String Descripcion_servicio) {
        this.Descripcion_servicio = Descripcion_servicio;
    }

    public int getValor_servicio() {
        return Valor_servicio;
    }

    public void setValor_servicio(int Valor_servicio) {
        this.Valor_servicio = Valor_servicio;
    }

    @Override
    public String toString() {
        return Nom_servicio;
    }
    
    

}
