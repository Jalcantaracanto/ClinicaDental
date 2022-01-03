/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Insumo;
import Entidades.TipoFamilia;
import Entidades.TipoInsumo;
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
public class InsumoDAO {
    private String mensaje =  "";
    
    
    public String agregarInsumo(Connection con,Insumo ins){
        PreparedStatement pst = null;
        String sql = "INSERT INTO INSUMO(ID_INSUMO, NOM_INSUMO, ID_TIPO_INSUMO, ID_TIPO_FAMILIA, STOCK, PRECIO_COMPRA)" 
                + "VALUES (?,?,?,?,?,?)";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,ins.getId_insumo());
            pst.setString(2,ins.getNom_insumo());
            pst.setInt(3,ins.getId_tipo_insumo());
            pst.setInt(4,ins.getId_tipo_familia());
            pst.setInt(5,ins.getStock());
            pst.setInt(6,ins.getPrecio_compra());
            mensaje = "Guardado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Guardar \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarInsumo(Connection con, Insumo ins){
        PreparedStatement pst = null;
        String sql = "UPDATE INSUMO SET NOM_INSUMO = ?, ID_TIPO_INSUMO = ?, ID_TIPO_FAMILIA = ?, STOCK = ?, PRECIO_COMPRA = ?"
                + "WHERE ID_INSUMO = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,ins.getNom_insumo());
            pst.setInt(2,ins.getId_tipo_insumo());
            pst.setInt(3, ins.getId_tipo_familia());
            pst.setInt(4,ins.getStock());
            pst.setInt(5,ins.getPrecio_compra());
            pst.setInt(6,ins.getId_insumo());

            mensaje = "Actualizado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Modificar \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarInsumo(Connection con, int id){
        PreparedStatement pst = null;
        String sql = "DELETE FROM INSUMO WHERE ID_INSUMO = ?";

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
    
    public void listarInsumo(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"ID", "NOMBRE", "CANTIDAD", "TIPO INSUMO", "FAMILIA INSUMO", "PRECIO COMPRA"};

        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT I.ID_INSUMO, I.NOM_INSUMO, I.STOCK, T.NOM_TIPO_INSUMO, F.NOM_TIPO_FAMILIA, TO_CHAR(I.PRECIO_COMPRA, '$9G999G999') \n" +
                     "FROM INSUMO I\n" +
                     "LEFT JOIN TIPO_INSUMO T\n" +
                     "ON I.ID_TIPO_INSUMO = T.ID_TIPO_INSUMO\n" +
                     "LEFT JOIN TIPO_FAMILIA F\n" +
                     "ON I.ID_TIPO_FAMILIA = F.ID_TIPO_FAMILIA\n" +
                     "ORDER BY ID_INSUMO";
        
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
    
    
    //METODOS CUSTOM
    
    public void listarInsumoCantidad(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"NOMBRE", "CANTIDAD"};

        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT NOM_INSUMO, STOCK  "
                   + "FROM INSUMO "
                   + "ORDER BY ID_INSUMO";
        
        String [] filas = new String[2];
        Statement st = null;
        ResultSet rs = null;
        
        try{
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 2; i++) {
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se puede mostrar la tabla");
        }
    }
    
    public void filtroNombre(Connection con, JTable tabla, String insumo) {

        DefaultTableModel model;
        String[] columnas = {"NOMBRE", "CANTIDAD"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[2];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT NOM_INSUMO, STOCK\n" +
                         "FROM INSUMO\n" +
                         "WHERE NOM_INSUMO LIKE ?\n" +
                         "ORDER BY ID_INSUMO";

            pst = con.prepareStatement(sql);
            pst.setString(1, insumo);
            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 2; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el Filtro");
        }
    }
    
    public String sumarInsumo(Connection con, Insumo ins){
        PreparedStatement pst = null;
        String sql = "UPDATE INSUMO SET STOCK = STOCK + ?" 
                + "WHERE NOM_INSUMO = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,ins.getStock());
            pst.setString(2, ins.getNom_insumo());

            mensaje = " Sumado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Sumar" + e.getMessage();
        }
        return mensaje;
    }
    
    public String restarInsumo(Connection con, Insumo ins){
        PreparedStatement pst = null;
        String sql = "UPDATE INSUMO SET STOCK = STOCK - ?" 
                + "WHERE ID_INSUMO = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,ins.getStock());
            pst.setInt(2, ins.getId_insumo());

            mensaje = "Restado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Restar" + e.getMessage();
        }
        return mensaje;
    }

    
    public int getMaxID(Connection con) {
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT NVL(MAX(ID_INSUMO+1),1) \n" +
                     "FROM INSUMO";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar id " + e.getMessage());
        }
        return id;
    }
    
    public ArrayList<TipoInsumo> cargarListaTipo(Connection con) {
        ArrayList<TipoInsumo> tipoInsumo = new ArrayList<TipoInsumo>();
        TipoInsumo tins = null;
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM TIPO_INSUMO";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                tins = new TipoInsumo();
                tins.setId_tipo_insumo(rs.getInt("ID_TIPO_INSUMO"));
                tins.setNom_tipo_insumo(rs.getString("NOM_TIPO_INSUMO"));
                tipoInsumo.add(tins);
            }
            return tipoInsumo;
        } catch (Exception e) {
            return tipoInsumo;
        }
    }
    
    public ArrayList<TipoFamilia> cargarListaFamilia(Connection con) {
        ArrayList<TipoFamilia> tipoFamilia = new ArrayList<TipoFamilia>();
        TipoFamilia tfam = null;
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM TIPO_FAMILIA";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                tfam = new TipoFamilia();
                tfam.setId_tipo_familia(rs.getInt("ID_TIPO_FAMILIA"));
                tfam.setNom_tipo_familia(rs.getString("NOM_TIPO_FAMILIA"));
                tipoFamilia.add(tfam);
            }
            return tipoFamilia;
        } catch (Exception e) {
            return tipoFamilia;
        }
    }
    
    public ArrayList<Insumo> cargarNombreInsumo(Connection con) {
        ArrayList<Insumo> nInsumo = new ArrayList<Insumo>();
        Insumo insu = null;
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM INSUMO";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                insu = new Insumo();
                insu.setNom_insumo(rs.getString("NOM_INSUMO"));
                insu.setId_insumo(rs.getInt("ID_INSUMO"));
                insu.setStock(rs.getInt("STOCK"));
                nInsumo.add(insu);
            }
            return nInsumo;
        } catch (Exception e) {
            return nInsumo;
        }
    }
    
    public String modificarPrecio(Connection con, Insumo ins){
        PreparedStatement pst = null;
        String sql = "UPDATE INSUMO SET NOM_INSUMO = ?, PRECIO_COMPRA = ?"
                + "WHERE ID_INSUMO = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,ins.getNom_insumo());
            pst.setInt(2,ins.getPrecio_compra());;
            pst.setInt(3,ins.getId_insumo());
            mensaje = "Actualizado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Modificar \n " + e.getMessage();
        }
        return mensaje;
    }
}
