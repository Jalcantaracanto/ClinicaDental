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
public class TipoFamilia {
    private int Id_tipo_familia;
    private String Nom_tipo_familia;

    public TipoFamilia() {
    }

    public TipoFamilia(int Id_tipo_familia, String Nom_tipo_familia) {
        this.Id_tipo_familia = Id_tipo_familia;
        this.Nom_tipo_familia = Nom_tipo_familia;
    }

    public int getId_tipo_familia() {
        return Id_tipo_familia;
    }

    public void setId_tipo_familia(int Id_tipo_familia) {
        this.Id_tipo_familia = Id_tipo_familia;
    }

    public String getNom_tipo_familia() {
        return Nom_tipo_familia;
    }

    public void setNom_tipo_familia(String Nom_tipo_familia) {
        this.Nom_tipo_familia = Nom_tipo_familia;
    }

    @Override
    public String toString() {
        return Nom_tipo_familia;
    }

}
