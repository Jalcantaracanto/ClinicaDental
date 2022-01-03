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
public class Boleta {
    private int Id_boleta;
    private String fecha_boleta;
    private String valor_boleta;
    private int Id_medio_pago;
    private int Id_servicio;
    private int Id_cliente;
    
    public Boleta() {
    }

    public Boleta(int Id_boleta, String fecha_boleta, String valor_boleta, int Id_clinica, int Id_medio_pago, int Id_servicio, int Id_cliente, MedioPago mediopagox, Servicio serviciox, Cliente clientex) {
        this.Id_boleta = Id_boleta;
        this.fecha_boleta = fecha_boleta;
        this.valor_boleta = valor_boleta;
        this.Id_medio_pago = Id_medio_pago;
        this.Id_servicio = Id_servicio;
        this.Id_cliente = Id_cliente;
    }

    public int getId_boleta() {
        return Id_boleta;
    }

    public void setId_boleta(int Id_boleta) {
        this.Id_boleta = Id_boleta;
    }

    public String getFecha_boleta() {
        return fecha_boleta;
    }

    public void setFecha_boleta(String fecha_boleta) {
        this.fecha_boleta = fecha_boleta;
    }

    public String getValor_boleta() {
        return valor_boleta;
    }

    public void setValor_boleta(String valor_boleta) {
        this.valor_boleta = valor_boleta;
    }

    public int getId_medio_pago() {
        return Id_medio_pago;
    }

    public void setId_medio_pago(int Id_medio_pago) {
        this.Id_medio_pago = Id_medio_pago;
    }

    public int getId_servicio() {
        return Id_servicio;
    }

    public void setId_servicio(int Id_servicio) {
        this.Id_servicio = Id_servicio;
    }

    public int getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(int Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    @Override
    public String toString() {
        return "Boleta{" + "Id_boleta=" + Id_boleta + ", fecha_boleta=" + fecha_boleta + ", valor_boleta=" + valor_boleta + ", Id_medio_pago=" + Id_medio_pago + ", Id_servicio=" + Id_servicio + ", Id_cliente=" + Id_cliente + '}';
    }
    
    
}
