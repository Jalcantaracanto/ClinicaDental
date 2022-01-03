/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Proveedor;
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
public class ProveedorDAO {
    
    private String mensaje =  "";
    
    public String agregarProveedor(Connection con,Proveedor pro){
        PreparedStatement pst = null;
        String sql = "INSERT INTO PROVEEDOR(ID_PROVEEDOR,RUT_PROVEEDOR,NOM_PROVEEDOR,FONO_PROVEEDOR,DIRE_PROVEEDOR,MAIL_PROVEEDOR)" 
                + "VALUES (?,?,?,?,?,?)";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,pro.getId_proveedor());
            pst.setString(2,pro.getRut_proveedor());
            pst.setString(3,pro.getNom_proveedor());
            pst.setString(4,pro.getFono_proveedor());
            pst.setString(5,pro.getDire_proveedor());
            pst.setString(6,pro.getMail_proveedor());
            mensaje = "Guardado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Guardar \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarProveedor(Connection con, Proveedor pro){
        PreparedStatement pst = null;
        String sql = "UPDATE PROVEEDOR SET RUT_PROVEEDOR = ?,NOM_PROVEEDOR = ?,FONO_PROVEEDOR = ?,DIRE_PROVEEDOR = ?,MAIL_PROVEEDOR = ?"
                + "WHERE ID_PROVEEDOR = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,pro.getRut_proveedor());
            pst.setString(2,pro.getNom_proveedor());
            pst.setString(3,pro.getFono_proveedor());
            pst.setString(4,pro.getDire_proveedor());
            pst.setString(5,pro.getMail_proveedor());
            pst.setInt(6,pro.getId_proveedor());
            mensaje = "Actualizado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Modificar \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarProveedor(Connection con, int id){
        PreparedStatement pst = null;
        String sql = "DELETE FROM PROVEEDOR WHERE ID_PROVEEDOR = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);

            mensaje = "Eliminado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Eliminar \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public void listarProveedor(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"ID PROVEEDOR", "RUT","NOMBRE","FONO","DIRECCION","E-MAIL"};

        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM PROVEEDOR ORDER BY ID_PROVEEDOR";
        
        String [] filas = new String[6];
        Statement st = null;
        ResultSet rs = null;
        
        try{
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 6; i++) {
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
        String sql = "SELECT NVL(MAX(ID_PROVEEDOR+1),1) \n" +
                     "FROM PROVEEDOR";
        
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
    
    public ArrayList<Proveedor> CargarComboProveedor(Connection con) {
        ArrayList<Proveedor> prove = new ArrayList<Proveedor>();
        Proveedor prov = null;
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM PROVEEDOR";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                prov = new Proveedor();
                prov.setNom_proveedor(rs.getString("NOM_PROVEEDOR"));
                prov.setId_proveedor(rs.getInt("ID_PROVEEDOR"));
                prove.add(prov);
            }
            return prove;
        } catch (Exception e) {
            return prove;
        }
    }
}
