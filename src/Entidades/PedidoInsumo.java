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
public class PedidoInsumo {
    private int Id_pedido;
    private int Cantidad;
    private String NombreInsumo;
    private String Estado;
    private int Id_insumo;
    private int Id_proovedor;

    public PedidoInsumo() {
    }

    public PedidoInsumo(int Id_pedido, int Cantidad, String NombreInsumo, String Estado, int Id_insumo, int Id_proovedor, int Id_tipo_insumo, int Id_tipo_familia) {
        this.Id_pedido = Id_pedido;
        this.Cantidad = Cantidad;
        this.NombreInsumo = NombreInsumo;
        this.Estado = Estado;
        this.Id_insumo = Id_insumo;
        this.Id_proovedor = Id_proovedor;
    }

    public int getId_pedido() {
        return Id_pedido;
    }

    public void setId_pedido(int Id_pedido) {
        this.Id_pedido = Id_pedido;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getNombreInsumo() {
        return NombreInsumo;
    }

    public void setNombreInsumo(String NombreInsumo) {
        this.NombreInsumo = NombreInsumo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getId_insumo() {
        return Id_insumo;
    }

    public void setId_insumo(int Id_insumo) {
        this.Id_insumo = Id_insumo;
    }

    public int getId_proovedor() {
        return Id_proovedor;
    }

    public void setId_proovedor(int Id_proovedor) {
        this.Id_proovedor = Id_proovedor;
    }

    @Override
    public String toString() {
        return Integer.toString(Id_pedido);
    }

    
}
