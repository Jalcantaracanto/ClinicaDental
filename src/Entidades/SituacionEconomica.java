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
public class SituacionEconomica {
    private int Id_sit_eco;
    private String Afp;
    private String Finiquito;
    private String Liquidacion;

    public SituacionEconomica() {
    }

    public SituacionEconomica(int Id_sit_eco, String Afp, String Finiquito, String Liquidacion) {
        this.Id_sit_eco = Id_sit_eco;
        this.Afp = Afp;
        this.Finiquito = Finiquito;
        this.Liquidacion = Liquidacion;
    }

    public int getId_sit_eco() {
        return Id_sit_eco;
    }

    public void setId_sit_eco(int Id_sit_eco) {
        this.Id_sit_eco = Id_sit_eco;
    }

    public String getAfp() {
        return Afp;
    }

    public void setAfp(String Afp) {
        this.Afp = Afp;
    }

    public String getFiniquito() {
        return Finiquito;
    }

    public void setFiniquito(String Finiquito) {
        this.Finiquito = Finiquito;
    }

    public String getLiquidacion() {
        return Liquidacion;
    }

    public void setLiquidacion(String Liquidacion) {
        this.Liquidacion = Liquidacion;
    }

    @Override
    public String toString() {
        return "SituacionEconomica{" + "Id_sit_eco=" + Id_sit_eco + ", Afp=" + Afp + ", Finiquito=" + Finiquito + ", Liquidacion=" + Liquidacion + '}';
    }
    
    
}
