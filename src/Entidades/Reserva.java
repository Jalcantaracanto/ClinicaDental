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
public class Reserva {
    private int Id_reserva;
    private String Fecha_reserva;
    private String Hora_reserva;
    private int Id_doc;
    private int Id_cliente;
    private int Id_servicio;

    public Reserva() {
    }

    public Reserva(int Id_reserva, String Fecha_reserva, String Hora_reserva, int Id_clinica, int Id_doc, int Id_cliente, int Id_servicio, Doctor Doctox, Cliente Clientex, Servicio servicio) {
        this.Id_reserva = Id_reserva;
        this.Fecha_reserva = Fecha_reserva;
        this.Hora_reserva = Hora_reserva;
        this.Id_doc = Id_doc;
        this.Id_cliente = Id_cliente;
        this.Id_servicio = Id_servicio;
    }

    public int getId_reserva() {
        return Id_reserva;
    }

    public void setId_reserva(int Id_reserva) {
        this.Id_reserva = Id_reserva;
    }

    public String getFecha_reserva() {
        return Fecha_reserva;
    }

    public void setFecha_reserva(String Fecha_reserva) {
        this.Fecha_reserva = Fecha_reserva;
    }

    public String getHora_reserva() {
        return Hora_reserva;
    }

    public void setHora_reserva(String Hora_reserva) {
        this.Hora_reserva = Hora_reserva;
    }

    public int getId_doc() {
        return Id_doc;
    }

    public void setId_doc(int Id_doc) {
        this.Id_doc = Id_doc;
    }

    public int getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(int Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public int getId_servicio() {
        return Id_servicio;
    }

    public void setId_servicio(int Id_servicio) {
        this.Id_servicio = Id_servicio;
    }

    @Override
    public String toString() {
        return "Reserva{" + "Id_reserva=" + Id_reserva + ", Fecha_reserva=" + Fecha_reserva + ", Hora_reserva=" + Hora_reserva + ", Id_clinica=" + Id_doc + ", Id_cliente=" + Id_cliente + ", Id_servicio=" + Id_servicio + '}';
    }
}
