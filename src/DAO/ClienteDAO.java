/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zuukens
 */
public class ClienteDAO {

    private String mensaje = "";

    public String agregarCliente(Connection con, Cliente cli) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO CLIENTE(ID_CLIENTE, NOM_CLIENTE,APE_CLIENTE,RUT_CLIENTE,DIRE_CLIENTE,FONO_CLIENTE,MAIL_CLIENTE,USUARIO_CLIENTE,PASSWORD_CLIENTE,ID_SIT_ECO)"
                + "VALUES (SEQ_IDCLIENTE.NEXTVAL,?,?,?,?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cli.getNom_cliente());
            pst.setString(2, cli.getApe_cliente());
            pst.setString(3, cli.getRut_cliente());
            pst.setString(4, cli.getDire_cliente());
            pst.setString(5, cli.getFono_cliente());
            pst.setString(6, cli.getMail_cliente());
            pst.setString(7, cli.getUsuario_cliente());
            pst.setString(8, cli.getPassword_cliente());
            mensaje = "Guardado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se pudo Guardar \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarCliente(Connection con, Cliente cli) {
        PreparedStatement pst = null;
        String sql = "UPDATE CLIENTE SET NOM_CLIENTE = ?,APE_CLIENTE = ?,RUT_CLIENTE = ?,DIRE_CLIENTE = ?,FONO_CLIENTE = ?,MAIL_CLIENTE = ?,USUARIO_CLIENTE = ?,PASSWORD_CLIENTE = ?,ID_SIT_ECO = ?)"
                + "WHERE ID_CLIENTE = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cli.getNom_cliente());
            pst.setString(2, cli.getApe_cliente());
            pst.setString(3, cli.getRut_cliente());
            pst.setString(4, cli.getDire_cliente());
            pst.setString(5, cli.getFono_cliente());
            pst.setString(6, cli.getMail_cliente());
            pst.setString(7, cli.getUsuario_cliente());
            pst.setString(8, cli.getPassword_cliente());
            pst.setInt(9, cli.getId_cliente());
            mensaje = "Empleado Actualizado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se pudo Actualizar \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarCliente(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            mensaje = "Empleado Eliminado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se pudo Eliminar \n " + e.getMessage();
        }
        return mensaje;
    }

    public void listarCliente(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "APELLIDO", "RUT", "DIRECCION", "TELEFONO", "E-MAIL", "PASSWORD", "SITUACION ECONOMICA"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM CLIENTE ORDER BY ID_CLIENTE";

        String[] filas = new String[9];
        Statement st = null;
        ResultSet rs = null;

        try {

            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 9; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    //CUSTOMS
    public void listarClientesSimple(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"RUT", "NOMBRE COMPLETO", "DIRECCION", "TELEFONO", "E-MAIL", "SITUACION ECONOMICA"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT C.RUT_CLIENTE,C.NOM_CLIENTE||' '||C.APE_CLIENTE,C.DIRE_CLIENTE,C.FONO_CLIENTE,C.MAIL_CLIENTE,S.AFP\n"
                + "FROM CLIENTE C\n"
                + "JOIN SITUACION_ECONOMICA S\n"
                + "ON C.ID_SIT_ECO = S.ID_SIT_ECO\n"
                + "ORDER BY ID_CLIENTE";

        String[] filas = new String[6];
        Statement st = null;
        ResultSet rs = null;

        try {

            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    public void filtroClienteRut(Connection con, JTable tabla, String rut) {

        DefaultTableModel model;
        String[] columnas = {"RUT", "NOMBRE COMPLETO", "DIRECCION", "TELEFONO", "E-MAIL", "SITUACION ECONOMICA"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[6];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT C.RUT_CLIENTE,C.NOM_CLIENTE||' '||C.APE_CLIENTE,C.DIRE_CLIENTE,C.FONO_CLIENTE,C.MAIL_CLIENTE,S.AFP\n"
                    + "FROM CLIENTE C\n"
                    + "JOIN SITUACION_ECONOMICA S\n"
                    + "ON C.ID_SIT_ECO = S.ID_SIT_ECO\n"
                    + "WHERE RUT_CLIENTE LIKE ?\n"
                    + "ORDER BY ID_CLIENTE";

            pst = con.prepareStatement(sql);
            pst.setString(1, rut);
            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla filtro Rut");
        }
    }

}
