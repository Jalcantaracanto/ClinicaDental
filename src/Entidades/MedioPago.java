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
public class MedioPago {
    private int Id_medio_pago;
    private String Nom_medio_pago;

    public MedioPago() {
    }

    public MedioPago(int Id_medio_pago, String Nom_medio_pago) {
        this.Id_medio_pago = Id_medio_pago;
        this.Nom_medio_pago = Nom_medio_pago;
    }

    public int getId_medio_pago() {
        return Id_medio_pago;
    }

    public void setId_medio_pago(int Id_medio_pago) {
        this.Id_medio_pago = Id_medio_pago;
    }

    public String getNom_medio_pago() {
        return Nom_medio_pago;
    }

    public void setNom_medio_pago(String Nom_medio_pago) {
        this.Nom_medio_pago = Nom_medio_pago;
    }

    @Override
    public String toString() {
        return "MedioPago{" + "Id_medio_pago=" + Id_medio_pago + ", Nom_medio_pago=" + Nom_medio_pago + '}';
    }
    
    
}
