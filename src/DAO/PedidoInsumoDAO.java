/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.PedidoInsumo;
import Entidades.Insumo;
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
public class PedidoInsumoDAO {
    private String mensaje =  "";
    
    public String agregarPedido(Connection con,PedidoInsumo ped){
        PreparedStatement pst = null;
        String sql = "INSERT INTO PEDIDO_INSUMO(ID_PEDIDO,CANTIDAD,ESTADO,ID_PROVEEDOR,ID_INSUMO,NOM_INSUMO)" 
                + "VALUES (?,?,?,?,?,?)";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,ped.getId_pedido());
            pst.setInt(2,ped.getCantidad());
            pst.setString(3,ped.getEstado());
            pst.setInt(4,ped.getId_proovedor());
            pst.setInt(5,ped.getId_insumo());
            pst.setString(6,ped.getNombreInsumo());
            mensaje = "Guardado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Guardar \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarPedido(Connection con, PedidoInsumo ped){
        PreparedStatement pst = null;
        String sql = "UPDATE PEDIDO_INSUMO SET ESTADO = ?"
                + "WHERE ID_PEDIDO = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,ped.getEstado());
            pst.setInt(2,ped.getId_pedido());
            mensaje = "Pedido Cancelado";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Cancelar su pedido" + e.getMessage();
        }
        return mensaje;
    }
    
    
    public void listarPedido(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"ID PEDIDO","CANTIDAD","ESTADO","NOMBRE INSUMO", "NOMBRE PROVEEDOR" };

        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT I.ID_PEDIDO, I.CANTIDAD, I.ESTADO, I.NOM_INSUMO, P.NOM_PROVEEDOR\n" +
                     "FROM PEDIDO_INSUMO I\n" +
                     "LEFT JOIN PROVEEDOR P\n" +
                     "ON I.ID_PROVEEDOR = P.ID_PROVEEDOR\n" +
                     "ORDER BY ID_PEDIDO";
        
        String [] filas = new String[5];
        Statement st = null;
        ResultSet rs = null;
        
        try{
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 5; i++) {
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
        String sql = "SELECT NVL(MAX(ID_PEDIDO+1),1) \n" +
                     "FROM PEDIDO_INSUMO";
        //String sql = "SELECT SEQ_IDCLIENTE.CURRVAL+1 FROM EMPLEADO";
        
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
    
    public ArrayList<PedidoInsumo> cargarLista(Connection con) {
        ArrayList<PedidoInsumo> pedidoInsumo = new ArrayList<PedidoInsumo>();
        PedidoInsumo pinsu = null;
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM PEDIDO_INSUMO";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                pinsu = new PedidoInsumo();
                pinsu.setId_pedido(rs.getInt("ID_PEDIDO"));
                pinsu.setEstado("ESTADO");
                pinsu.setId_insumo(rs.getInt("ID_INSUMO"));
                pinsu.setId_proovedor(rs.getInt("ID_PROVEEDOR"));
                pinsu.setNombreInsumo(rs.getString("NOM_INSUMO"));
                pinsu.setCantidad(rs.getInt("CANTIDAD"));
                pedidoInsumo.add(pinsu);
            }
            return pedidoInsumo;
        } catch (Exception e) {
            return pedidoInsumo;
        }
    }
    
    
    public void listapedidos(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"ID PEDIDO","CANTIDAD","INSUMO","ESTADO","ID PROVEEDOR","ID TIPO INSUMO","ID FAMILIA" };

        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT LPAD(I.ID_PEDIDO,3,0), LPAD(I.CANTIDAD,3,0), P.NOM_INSUMO, I.ESTADO, LPAD(I.ID_PROVEEDOR,3,0), LPAD(P.ID_TIPO_INSUMO,3,0), LPAD(P.ID_TIPO_FAMILIA,3,0)\n" +
                     "FROM PEDIDO_INSUMO I\n" +
                     "LEFT JOIN INSUMO P\n" +
                     "ON I.ID_INSUMO = P.ID_INSUMO\n" +
                     "WHERE I.ESTADO = 'EN CURSO'\n" +
                     "ORDER BY ID_PEDIDO DESC";
        
        String [] filas = new String[7];
        Statement st = null;
        ResultSet rs = null;
        
        try{
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se puede mostrar la tabla");
        }
    }
    
    public String modificarEstado(Connection con, PedidoInsumo pins){
        PreparedStatement pst = null;
        String sql = "UPDATE PEDIDO_INSUMO SET ESTADO = ?" 
                + "WHERE ID_PEDIDO = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,pins.getEstado());
            pst.setInt(2, pins.getId_pedido());

            mensaje = "Estado Cambiado Correctamente";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Cambiar el estado" + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarPedido(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM PEDIDO_INSUMO WHERE ID_PROVEEDOR = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            mensaje = "Pedidos Eliminados Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se pudo Eliminar \n " + e.getMessage();
        }
        return mensaje;
    }
}
