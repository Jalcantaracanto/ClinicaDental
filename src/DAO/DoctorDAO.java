/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Doctor;
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
public class DoctorDAO {

    private String mensaje = "";

    public String agregarDoctor(Connection con, Doctor doc) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO DOCTOR (ID_DOC,NOM_DOC,APE_DOC,RUT_DOC,FONO_DOC,MAIL_DOC,DIRE_DOC,ID_TIPO_USUARIO)"
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, doc.getId_Doc());
            pst.setString(2, doc.getNom_doc());
            pst.setString(3, doc.getApe_doc());
            pst.setString(4, doc.getRut_doc());
            pst.setString(5, doc.getFono_doc());
            pst.setString(6, doc.getMail_doc());
            pst.setString(7, doc.getDire_doc());
            pst.setInt(8, doc.getId_tipo_usuario());
            mensaje = "Doctor Guardado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se pudo Guardar \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarDoctor(Connection con, Doctor doc) {
        PreparedStatement pst = null;
        String sql = "UPDATE DOCTOR SET NOM_DOC = ?,APE_DOC = ?,FONO_DOC = ?,MAIL_DOC = ?,DIRE_DOC = ?,ID_TIPO_USUARIO = ?"
                + "WHERE RUT_DOC = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, doc.getNom_doc());
            pst.setString(2, doc.getApe_doc());
            pst.setString(3, doc.getFono_doc());
            pst.setString(4, doc.getMail_doc());
            pst.setString(5, doc.getDire_doc());
            pst.setInt(6, doc.getId_tipo_usuario());
            pst.setString(7, doc.getRut_doc());
            mensaje = "Doctor Actualizado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se pudo Actualizar \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarDoctor(Connection con, String rut) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM DOCTOR WHERE RUT_DOC = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, rut);

            mensaje = "Doctor Eliminado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se pudo Eliminar \n " + e.getMessage();
        }
        return mensaje;
    }

    public void listarDoctor(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "APELLIDO", "RUT", "TELEFONO", "E-MAIL", "DIRECCION", "TIPO USUARIO"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM DOCTOR ORDER BY ID_DOC";

        String[] filas = new String[8];
        Statement st = null;
        ResultSet rs = null;

        try {

            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 8; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    public int getMaxID(Connection con) {
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT NVL(MAX(ID_DOC+1),1) \n"
                + "FROM DOCTOR";

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

    public void listarHorasMedicas(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "RUT", "NOMBRE COMPLETO", "FECHA RESERVA", "DOCTOR", "SERVICIO"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT R.ID_RESERVA,C.RUT_CLIENTE,C.NOM_CLIENTE||' '||C.APE_CLIENTE,R.FECHA_HORA_RESERVA, D.APE_DOC,S.NOM_SERVICIO\n"
                + "FROM RESERVA R\n"
                + "LEFT JOIN CLIENTE C\n"
                + "ON C.ID_CLIENTE = R.ID_CLIENTE\n"
                + "JOIN DOCTOR D\n"
                + "ON D.ID_DOC = R.ID_DOC\n"
                + "LEFT JOIN SERVICIO S\n"
                + "ON S.ID_SERVICIO = R.ID_SERVICIO\n"
                + "ORDER BY R.ID_RESERVA";

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

    public void filtroHorasRut(Connection con, JTable tabla, String rut) {

        DefaultTableModel model;
        String[] columnas = {"ID", "RUT", "NOMBRE COMPLETO", "FECHA RESERVA", "DOCTOR", "SERVICIO"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[6];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT R.ID_RESERVA,C.RUT_CLIENTE,C.NOM_CLIENTE||' '||C.APE_CLIENTE,R.FECHA_HORA_RESERVA, D.APE_DOC,S.NOM_SERVICIO\n"
                    + "FROM RESERVA R\n"
                    + "LEFT JOIN CLIENTE C\n"
                    + "ON C.ID_CLIENTE = R.ID_CLIENTE\n"
                    + "JOIN DOCTOR D\n"
                    + "ON D.ID_DOC = R.ID_DOC\n"
                    + "LEFT JOIN SERVICIO S\n"
                    + "ON S.ID_SERVICIO = R.ID_SERVICIO\n"
                    + "WHERE C.RUT_CLIENTE LIKE ?\n"
                    + "ORDER BY R.ID_RESERVA";
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
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    public void filtroHorasServicio(Connection con, JTable tabla, String servicio) {

        DefaultTableModel model;
        String[] columnas = {"ID", "RUT", "NOMBRE COMPLETO", "FECHA RESERVA", "DOCTOR", "SERVICIO"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[6];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT R.ID_RESERVA,C.RUT_CLIENTE,C.NOM_CLIENTE||' '||C.APE_CLIENTE,R.FECHA_HORA_RESERVA, D.APE_DOC,S.NOM_SERVICIO\n"
                    + "FROM RESERVA R\n"
                    + "LEFT JOIN CLIENTE C\n"
                    + "ON C.ID_CLIENTE = R.ID_CLIENTE\n"
                    + "JOIN DOCTOR D\n"
                    + "ON D.ID_DOC = R.ID_DOC\n"
                    + "LEFT JOIN SERVICIO S\n"
                    + "ON S.ID_SERVICIO = R.ID_SERVICIO\n"
                    + "WHERE S.NOM_SERVICIO = ?\n"
                    + "ORDER BY R.ID_RESERVA";
            pst = con.prepareStatement(sql);
            pst.setString(1, servicio);
            rs = pst.executeQuery();
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

    public void filtroHorasServicioRut(Connection con, JTable tabla, String rut, String servicio) {

        DefaultTableModel model;
        String[] columnas = {"ID", "RUT", "NOMBRE COMPLETO", "FECHA RESERVA", "DOCTOR", "SERVICIO"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[6];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT R.ID_RESERVA,C.RUT_CLIENTE,C.NOM_CLIENTE||' '||C.APE_CLIENTE,R.FECHA_HORA_RESERVA, D.APE_DOC,S.NOM_SERVICIO\n"
                    + "FROM RESERVA R\n"
                    + "LEFT JOIN CLIENTE C\n"
                    + "ON C.ID_CLIENTE = R.ID_CLIENTE\n"
                    + "JOIN DOCTOR D\n"
                    + "ON D.ID_DOC = R.ID_DOC\n"
                    + "LEFT JOIN SERVICIO S\n"
                    + "ON S.ID_SERVICIO = R.ID_SERVICIO\n"
                    + "WHERE C.RUT_CLIENTE LIKE ? AND S.NOM_SERVICIO = ?\n"
                    + "ORDER BY R.ID_RESERVA";

            pst = con.prepareStatement(sql);
            pst.setString(1, rut);
            pst.setString(2, servicio);
            rs = pst.executeQuery();
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
    
    public void filtroHorasRutDoc(Connection con, JTable tabla, String rut, String doctor) {

        DefaultTableModel model;
        String[] columnas = {"ID", "RUT", "NOMBRE COMPLETO", "FECHA RESERVA", "DOCTOR", "SERVICIO"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[6];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT R.ID_RESERVA,C.RUT_CLIENTE,C.NOM_CLIENTE||' '||C.APE_CLIENTE,R.FECHA_HORA_RESERVA, D.APE_DOC,S.NOM_SERVICIO\n"
                    + "FROM RESERVA R\n"
                    + "LEFT JOIN CLIENTE C\n"
                    + "ON C.ID_CLIENTE = R.ID_CLIENTE\n"
                    + "JOIN DOCTOR D\n"
                    + "ON D.ID_DOC = R.ID_DOC\n"
                    + "LEFT JOIN SERVICIO S\n"
                    + "ON S.ID_SERVICIO = R.ID_SERVICIO\n"
                    + "WHERE C.RUT_CLIENTE LIKE ? AND D.APE_DOC LIKE ?\n"
                    + "ORDER BY R.ID_RESERVA";

            pst = con.prepareStatement(sql);
            pst.setString(1, rut);
            pst.setString(2, doctor);
            rs = pst.executeQuery();
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
    
    public void filtroHorasServicioRutDoc(Connection con, JTable tabla, String rut, String doctor, String servicio) {

        DefaultTableModel model;
        String[] columnas = {"ID", "RUT", "NOMBRE COMPLETO", "FECHA RESERVA", "DOCTOR", "SERVICIO"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[6];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT R.ID_RESERVA,C.RUT_CLIENTE,C.NOM_CLIENTE||' '||C.APE_CLIENTE,R.FECHA_HORA_RESERVA, D.APE_DOC,S.NOM_SERVICIO\n"
                    + "FROM RESERVA R\n"
                    + "LEFT JOIN CLIENTE C\n"
                    + "ON C.ID_CLIENTE = R.ID_CLIENTE\n"
                    + "JOIN DOCTOR D\n"
                    + "ON D.ID_DOC = R.ID_DOC\n"
                    + "LEFT JOIN SERVICIO S\n"
                    + "ON S.ID_SERVICIO = R.ID_SERVICIO\n"
                    + "WHERE C.RUT_CLIENTE LIKE ? AND D.APE_DOC LIKE ? AND S.NOM_SERVICIO = ?"
                    + "ORDER BY R.ID_RESERVA";

            pst = con.prepareStatement(sql);
            pst.setString(1, rut);
            pst.setString(2, doctor);
            pst.setString(3, servicio);
            rs = pst.executeQuery();
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
    
    public void filtroHorasServicioDoc(Connection con, JTable tabla, String servicio, String doctor) {

        DefaultTableModel model;
        String[] columnas = {"ID", "RUT", "NOMBRE COMPLETO", "FECHA RESERVA", "DOCTOR", "SERVICIO"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[6];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT R.ID_RESERVA,C.RUT_CLIENTE,C.NOM_CLIENTE||' '||C.APE_CLIENTE,R.FECHA_HORA_RESERVA, D.APE_DOC,S.NOM_SERVICIO\n"
                    + "FROM RESERVA R\n"
                    + "LEFT JOIN CLIENTE C\n"
                    + "ON C.ID_CLIENTE = R.ID_CLIENTE\n"
                    + "JOIN DOCTOR D\n"
                    + "ON D.ID_DOC = R.ID_DOC\n"
                    + "LEFT JOIN SERVICIO S\n"
                    + "ON S.ID_SERVICIO = R.ID_SERVICIO\n"
                    + "WHERE D.APE_DOC LIKE ? AND S.NOM_SERVICIO = ?"
                    + "ORDER BY R.ID_RESERVA";

            pst = con.prepareStatement(sql);
            pst.setString(1, doctor);
            pst.setString(2, servicio);
            rs = pst.executeQuery();
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
    

    public ArrayList<Doctor> cargarListaDoctor(Connection con) {
        ArrayList<Doctor> doc = new ArrayList<Doctor>();
        Doctor docs = null;
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM DOCTOR";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                docs = new Doctor();
                docs.setId_Doc(rs.getInt("ID_DOC"));
                docs.setApe_doc(rs.getString("APE_DOC"));
                doc.add(docs);
            }
            return doc;
        } catch (Exception e) {
            return doc;
        }
    }
    
    public String eliminarHoraMedica(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM RESERVA WHERE ID_RESERVA = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            mensaje = "Reserva Tomada Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se pudo tomar la Reserva \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String EliminarReserva(Connection con, int id){
        PreparedStatement pst = null;
        String sql = "DELETE FROM RESERVA WHERE ID_DOC = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);

            mensaje = "Eliminados las Reservas asociados al Servicio Doctor";
            pst.execute();
            pst.close();
        }catch(SQLException e){
            mensaje = "No se pudo Eliminar Reserva \n " + e.getMessage();
        }
        return mensaje;
    }
}
