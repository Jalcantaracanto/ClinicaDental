/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;


import BD.Conexion;
import DAO.ClienteDAO;
import Entidades.Cliente;
import java.sql.*;
import javax.swing.JTable;
/**
 *
 * @author Zuukens
 */
public class ClienteBO {
    private String mensaje = "";
    private ClienteDAO clidao = new ClienteDAO();
    
    public String agregarCliente(Cliente cli){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = clidao.agregarCliente(conn, cli);
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
    
    public String modificarCliente(Cliente cli){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = clidao.modificarCliente(conn, cli);
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
    
    public String eliminarCliente(int id){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = clidao.eliminarCliente(conn, id);
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
    
    public void listarCliente(JTable tabla){
        Connection conn = Conexion.getConnection();
        clidao.listarCliente(conn, tabla);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //CUSTOMS
    public void listarClientesSimple(JTable tabla){
        Connection conn = Conexion.getConnection();
        clidao.listarClientesSimple(conn, tabla);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void filtroClienteRut(JTable tabla, String rut) {
        Connection conn = Conexion.getConnection();
        clidao.filtroClienteRut(conn, tabla, rut);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
