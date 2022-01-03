/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zuukens
 */
public class ServicioDAO {
    
    private String mensaje =  "";
    
    public String agregarServicio(Connection con,Servicio ser){
        PreparedStatement pst = null;
        String sql = "INSERT INTO SERVICIO(ID_SERVICIO,NOM_SERVICIO,DESCRIPCION_SERVICIO,VALOR_SERVICIO)" 
                + "VALUES (?,?,?,?)";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,ser.getId_servicio());
            pst.setString(2,ser.getNom_servicio());
            pst.setString(3,ser.getDescripcion_servicio());
            pst.setInt(4,ser.getValor_servicio());
            mensaje = "Guardado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Guardar \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarServicio(Connection con, Servicio ser){
        PreparedStatement pst = null;
        String sql = "UPDATE SERVICIO SET VALOR_SERVICIO = ?"
                + "WHERE ID_SERVICIO = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,ser.getValor_servicio());
            pst.setInt(2,ser.getId_servicio());
            mensaje = "Actualizado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Modificar \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarServicio(Connection con, int id){
        PreparedStatement pst = null;
        String sql = "DELETE FROM SERVICIO WHERE ID_SERVICIO = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);

            mensaje = "Servicio Eliminado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Eliminar el Servicio \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public void listarServicio(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"ID SERVICIO","NOMBRE","DESCRIPCION","VALOR"};

        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT ID_SERVICIO, NOM_SERVICIO, DESCRIPCION_SERVICIO, TO_CHAR(VALOR_SERVICIO, '$9G999G999') FROM SERVICIO ORDER BY ID_SERVICIO";
        
        String [] filas = new String[4];
        Statement st = null;
        ResultSet rs = null;
        
        try{
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se puede mostrar la tabla");
        }
    }
    
    public int getMaxID(Connection con){
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT NVL(MAX(ID_SERVICIO+1),1) \n" +
                     "FROM SERVICIO";
        
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
            System.out.println("Error al mostrar id " + e.getMessage());
        }
        return id;
    }
    
    public ArrayList<Servicio> cargarLista(Connection con) {
        ArrayList<Servicio> servicio = new ArrayList<Servicio>();
        Servicio serv = null;
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM SERVICIO";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                serv = new Servicio();
                serv.setId_servicio(rs.getInt("ID_SERVICIO"));
                serv.setNom_servicio(rs.getString("NOM_SERVICIO"));
                servicio.add(serv);
            }
            return servicio;
        } catch (Exception e) {
            return servicio;
        }
    }
    
    public String EliminarReserva(Connection con, int id){
        PreparedStatement pst = null;
        String sql = "DELETE FROM RESERVA WHERE ID_SERVICIO = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);

            mensaje = "Eliminados las Reservas asociados al Servicio Eliminado";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Eliminar Reserva \n " + e.getMessage();
        }
        return mensaje;
    }
}
