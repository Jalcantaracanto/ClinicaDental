/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import BD.Conexion;
import DAO.ServicioDAO;
import Entidades.Servicio;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Zuukens
 */
public class ServicioBO {
    
    private String mensaje = "";
    private ServicioDAO serdao = new ServicioDAO();
    
    public String agregarServicio(Servicio ser){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = serdao.agregarServicio(conn, ser);
        }catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
        }finally{
            try{
                if (conn != null) {
                    conn.close();
                }
            }catch(Exception e){
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String modificarServicio(Servicio ser){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = serdao.modificarServicio(conn, ser);
        }catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
        }finally{
            try{
                if (conn != null) {
                    conn.close();
                }
            }catch(Exception e){
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String eliminarServicio(int id){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = serdao.eliminarServicio(conn, id);
        }catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
        }finally{
            try{
                if (conn != null) {
                    conn.close();
                }
            }catch(Exception e){
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public void listarServicio(JTable tabla){
         Connection conn = Conexion.getConnection();
        serdao.listarServicio(conn, tabla);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = serdao.getMaxID(conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public ArrayList<Servicio> cargarLista() {
        Connection conn = Conexion.getConnection();
        ArrayList<Servicio> tipoUsuario = serdao.cargarLista(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tipoUsuario;
    }
    
    public String eliminarReserva(int id){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = serdao.EliminarReserva(conn, id);
        }catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
        }finally{
            try{
                if (conn != null) {
                    conn.close();
                }
            }catch(Exception e){
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
}
