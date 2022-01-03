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
public class Insumo {
    private int Id_insumo;
    private String Nom_insumo;
    private int Id_tipo_insumo;
    private int Id_tipo_familia;
    private int Stock;
    private int precio_compra;

    public Insumo() {
    }

    public Insumo(int Id_insumo, String Nom_insumo, int Id_tipo_insumo, int Id_tipo_familia, int Stock, int precio_compra) {
        this.Id_insumo = Id_insumo;
        this.Nom_insumo = Nom_insumo;
        this.Id_tipo_insumo = Id_tipo_insumo;
        this.Id_tipo_familia = Id_tipo_familia;
        this.Stock = Stock;
        this.precio_compra = precio_compra;
    }

    public int getId_insumo() {
        return Id_insumo;
    }

    public void setId_insumo(int Id_insumo) {
        this.Id_insumo = Id_insumo;
    }

    public String getNom_insumo() {
        return Nom_insumo;
    }

    public void setNom_insumo(String Nom_insumo) {
        this.Nom_insumo = Nom_insumo;
    }

    public int getId_tipo_insumo() {
        return Id_tipo_insumo;
    }

    public void setId_tipo_insumo(int Id_tipo_insumo) {
        this.Id_tipo_insumo = Id_tipo_insumo;
    }

    public int getId_tipo_familia() {
        return Id_tipo_familia;
    }

    public void setId_tipo_familia(int Id_tipo_familia) {
        this.Id_tipo_familia = Id_tipo_familia;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }
   
    

    @Override
    public String toString() {
        return Nom_insumo;
    }
}
