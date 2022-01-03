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
public class TipoInsumo {
    private int Id_tipo_insumo;
    private String Nom_tipo_insumo;

    public TipoInsumo() {
    }

    public TipoInsumo(int Id_tipo_insumo, String Nom_tipo_insumo) {
        this.Id_tipo_insumo = Id_tipo_insumo;
        this.Nom_tipo_insumo = Nom_tipo_insumo;
    }

    public int getId_tipo_insumo() {
        return Id_tipo_insumo;
    }

    public void setId_tipo_insumo(int Id_tipo_insumo) {
        this.Id_tipo_insumo = Id_tipo_insumo;
    }

    public String getNom_tipo_insumo() {
        return Nom_tipo_insumo;
    }

    public void setNom_tipo_insumo(String Nom_tipo_insumo) {
        this.Nom_tipo_insumo = Nom_tipo_insumo;
    }

    @Override
    public String toString() {
        return Nom_tipo_insumo;
    }

 
    
    
}
