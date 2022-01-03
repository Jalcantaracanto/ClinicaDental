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
public class Control {
    private String Usuario;
    private String Fecha;
    private String Operacion;

    public Control() {
    }

    public Control(String Usuario, String Fecha, String Operacion) {
        this.Usuario = Usuario;
        this.Fecha = Fecha;
        this.Operacion = Operacion;
    }


    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getOperacion() {
        return Operacion;
    }

    public void setOperacion(String Operacion) {
        this.Operacion = Operacion;
    }

    @Override
    public String toString() {
        return "Control{" + "Usuario=" + Usuario + ", Fecha=" + Fecha + ", Operacion=" + Operacion + '}';
    }
    
    
    
}
