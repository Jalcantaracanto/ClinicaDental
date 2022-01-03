/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import BD.Conexion;
import DAO.InsumoDAO;
import Entidades.Insumo;
import Entidades.TipoFamilia;
import Entidades.TipoInsumo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;


/**
 *
 * @author Zuukens
 */
public class InsumoBO {
    
    private String mensaje = "";
    private InsumoDAO insdao = new InsumoDAO();
    
    public String agregarInsumo(Insumo ins){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = insdao.agregarInsumo(conn, ins);
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
    
    public String modificarInsumo(Insumo ins){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = insdao.modificarInsumo(conn, ins);
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
    
    public String eliminarInsumo(int id){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = insdao.eliminarInsumo(conn, id);
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
    
    public void listarInsumo(JTable tabla){
         Connection conn = Conexion.getConnection();
        insdao.listarInsumo(conn, tabla);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //CUSTOM
    
    public void listarInsumoCantidad(JTable tabla){
         Connection conn = Conexion.getConnection();
        insdao.listarInsumoCantidad(conn, tabla);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public String restarInsumo(Insumo ins){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = insdao.restarInsumo(conn, ins);
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
    
    public String sumarInsumo(Insumo ins){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = insdao.sumarInsumo(conn, ins);
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
  
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = insdao.getMaxID(conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public ArrayList<TipoInsumo> cargarListaTipo(){
        Connection conn = Conexion.getConnection();
        ArrayList<TipoInsumo> tipoUsuario = insdao.cargarListaTipo(conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       return tipoUsuario;
    }
    
    public ArrayList<TipoFamilia> cargarListaFamilia(){
        Connection conn = Conexion.getConnection();
        ArrayList<TipoFamilia> tipoFamilia = insdao.cargarListaFamilia(conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       return tipoFamilia;
    }
    
    public ArrayList<Insumo> cargarNombreInsumo(){
        Connection conn = Conexion.getConnection();
        ArrayList<Insumo> nInsumo = insdao.cargarNombreInsumo(conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       return nInsumo;
    }
    
    public String modificarPrecio(Insumo ins){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = insdao.modificarPrecio(conn, ins);
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
    
    public void filtroNombre(JTable tabla, String insumo) {
        Connection conn = Conexion.getConnection();
        insdao.filtroNombre(conn, tabla, insumo);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
