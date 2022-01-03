/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import BD.Conexion;
import DAO.DoctorDAO;
import Entidades.Doctor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Zuukens
 */
public class DoctorBO {
    private String mensaje = "";
    private DoctorDAO docdao = new DoctorDAO();
    
    public String agregarDoctor(Doctor doc){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = docdao.agregarDoctor(conn, doc);
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
    
    public String modificarDoctor(Doctor doc){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = docdao.modificarDoctor(conn, doc);
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
    
    public String eliminarDoctor(String rut){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = docdao.eliminarDoctor(conn, rut);
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
    
    public void listarDoctor(JTable tabla){
         Connection conn = Conexion.getConnection();
        docdao.listarDoctor(conn, tabla);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID() {
        Connection conn = Conexion.getConnection();
        int id = docdao.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public void listarHorasMedicas(JTable tabla){
        Connection conn = Conexion.getConnection();
        docdao.listarHorasMedicas(conn, tabla);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void filtroHorasRut(JTable tabla, String rut) {
        Connection conn = Conexion.getConnection();
        docdao.filtroHorasRut(conn, tabla, rut);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void filtroHorasServicio(JTable tabla, String servicio) {
        Connection conn = Conexion.getConnection();
        docdao.filtroHorasServicio(conn, tabla, servicio);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void filtroHorasServicioRut(JTable tabla, String rut, String servicio) {
        Connection conn = Conexion.getConnection();
        docdao.filtroHorasServicioRut(conn, tabla, rut, servicio);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void filtroHorasRutDoc(JTable tabla, String rut, String doctor) {
        Connection conn = Conexion.getConnection();
        docdao.filtroHorasRutDoc(conn, tabla, rut, doctor);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void filtroHorasServicioRutDoc(JTable tabla, String rut, String doctor, String servicio) {
        Connection conn = Conexion.getConnection();
        docdao.filtroHorasServicioRutDoc(conn, tabla, rut, doctor, servicio);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void filtroHorasServicioDoc(JTable tabla, String servicio, String doctor) {
        Connection conn = Conexion.getConnection();
        docdao.filtroHorasServicioDoc(conn, tabla, servicio, doctor);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public ArrayList<Doctor> cargarListaDoctor(){
        Connection conn = Conexion.getConnection();
        ArrayList<Doctor> doctores = docdao.cargarListaDoctor(conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       return doctores;
    }
    
    public String eliminarHoraMedica(int id){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = docdao.eliminarHoraMedica(conn, id);
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
    
    public String eliminarReserva(int id){
        Connection conn = Conexion.getConnection();
        try{
            mensaje = docdao.EliminarReserva(conn, id);
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
