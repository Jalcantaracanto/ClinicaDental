/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import BD.Conexion;
import DAO.PedidoInsumoDAO;
import Entidades.PedidoInsumo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Zuukens
 */
public class PedidoInsumoBO {
    private String mensaje = "";
    private PedidoInsumoDAO peddao = new PedidoInsumoDAO();
    
    public String AgregarPedido(PedidoInsumo ped){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = peddao.agregarPedido(conn, ped);
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
    
    public String modificarPedido(PedidoInsumo ped){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = peddao.modificarPedido(conn, ped);
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
    
    
    public void listarPedido(JTable tabla){
         Connection conn = Conexion.getConnection();
        peddao.listarPedido(conn, tabla);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = peddao.getMaxID(conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public ArrayList<PedidoInsumo> cargarLista(){
        Connection conn = Conexion.getConnection();
        ArrayList<PedidoInsumo> pInsu = peddao.cargarLista(conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       return pInsu;
    }
    
    public void listapedidos(JTable tabla){
         Connection conn = Conexion.getConnection();
        peddao.listapedidos(conn, tabla);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public String modificarEstado(PedidoInsumo ped){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = peddao.modificarEstado(conn, ped);
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
    
    public String eliminarPedido(int id){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = peddao.eliminarPedido(conn, id);
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
