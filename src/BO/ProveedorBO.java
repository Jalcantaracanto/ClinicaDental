/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import BD.Conexion;
import DAO.ProveedorDAO;
import Entidades.Proveedor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Zuukens
 */
public class ProveedorBO {
    
    private String mensaje = "";
    private ProveedorDAO prodao = new ProveedorDAO();
    
    public String agregarProveedor(Proveedor pro){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = prodao.agregarProveedor(conn, pro);
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
    
    public String modificarProveedor(Proveedor pro){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = prodao.modificarProveedor(conn, pro);
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
    
    public String eliminarProveedor(int id){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = prodao.eliminarProveedor(conn, id);
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
    
    public void listarProveedor(JTable tabla){
         Connection conn = Conexion.getConnection();
        prodao.listarProveedor(conn, tabla);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = prodao.getMaxID(conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public ArrayList<Proveedor> CargarComboProveedor(){
        Connection conn = Conexion.getConnection();
        ArrayList<Proveedor> tipoUsuario = prodao.CargarComboProveedor(conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       return tipoUsuario;
    }
}
