/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Conexion;
import Entidades.Empleado;
import Entidades.TipoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Array;

/**
 *
 * @author Zuukens
 */
public class EmpleadoDAO {

    private String mensaje = "";

    public String agregarEmpleado(Connection con, Empleado emp) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO EMPLEADO(ID_EMP, NOM_EMP,APE_EMP,RUT_EMP,FONO_EMP,DIRE_EMP,MAIL_EMP,ID_TIPO_USUARIO,PASS_EMP)"
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, emp.getId_empleado());
            pst.setString(2, emp.getNom_emp());
            pst.setString(3, emp.getApe_emp());
            pst.setString(4, emp.getRut_emp());
            pst.setString(5, emp.getFono_emp());
            pst.setString(6, emp.getDire_emp());
            pst.setString(7, emp.getMail_emp());
            pst.setInt(8, emp.getId_tipo_usuario());
            pst.setString(9, emp.getPass_emp());
            mensaje = "Empleado Guardado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se pudo Guardar \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarEmpleado(Connection con, Empleado emp) {
        PreparedStatement pst = null;
        String sql = "UPDATE EMPLEADO SET NOM_EMP = ?,APE_EMP = ?,RUT_EMP = ?,FONO_EMP = ?,DIRE_EMP = ?,MAIL_EMP = ?,ID_TIPO_USUARIO = ?"
                + "WHERE ID_EMP = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, emp.getNom_emp());
            pst.setString(2, emp.getApe_emp());
            pst.setString(3, emp.getRut_emp());
            pst.setString(4, emp.getFono_emp());
            pst.setString(5, emp.getDire_emp());
            pst.setString(6, emp.getMail_emp());
            pst.setInt(7, emp.getId_tipo_usuario());
            pst.setInt(8, emp.getId_empleado());
            mensaje = "Actualizado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se pudo Modificar \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarEmpleado(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM EMPLEADO WHERE ID_EMP = ?";

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

    public void listarEmpleado(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "APELLIDO", "RUT", "TELEFONO", "DIRECCION", "E-MAIL", "TIPO USUARIO", "CLAVE", "ID TIPO", "ID DOC"};

        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT E.ID_EMP, E.NOM_EMP, E.APE_EMP, E.RUT_EMP ,E.FONO_EMP, E.DIRE_EMP, E.MAIL_EMP, T.NOM_TIPO_USUARIO, E.PASS_EMP,E.ID_TIPO_USUARIO,D.ID_DOC\n"
                + "FROM EMPLEADO E\n"
                + "LEFT JOIN TIPO_USUARIO T\n"
                + "ON E.ID_TIPO_USUARIO = T.ID_TIPO_USUARIO\n"
                + "LEFT JOIN DOCTOR D\n"
                + "ON E.RUT_EMP = D.RUT_DOC\n"
                + "WHERE E.ID_TIPO_USUARIO = 2 OR E.ID_TIPO_USUARIO = 3\n"
                + "ORDER BY ID_EMP";

        String[] filas = new String[11];
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    //METODOS CUSTOM
    public int getMaxID(Connection con) {
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT NVL(MAX(ID_EMP+1),1) \n"
                + "FROM EMPLEADO";

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

    public ArrayList<TipoUsuario> cargarLista(Connection con) {
        ArrayList<TipoUsuario> tipoUsuario = new ArrayList<TipoUsuario>();
        TipoUsuario tusu = null;
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM TIPO_USUARIO\n"
                    + "WHERE id_tipo_usuario = 2 OR id_tipo_usuario = 3 ";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                tusu = new TipoUsuario();
                tusu.setId_tipo_usuario(rs.getInt("ID_TIPO_USUARIO"));
                tusu.setNom_tipo_usuario(rs.getString("NOM_TIPO_USUARIO"));
                tipoUsuario.add(tusu);
            }
            return tipoUsuario;
        } catch (Exception e) {
            return tipoUsuario;
        }
    }

    public String Login(Connection con, Empleado emp) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT ID_TIPO_USUARIO FROM EMPLEADO WHERE MAIL_EMP = ? AND PASS_EMP = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, emp.getMail_emp());
            pst.setString(2, emp.getPass_emp());
            rs = pst.executeQuery();
            if (rs.next()) {
                mensaje = rs.getString("ID_TIPO_USUARIO");
                pst.execute();
                pst.close();
            } else {
                mensaje = "Usuario Invalido ";
            }

        } catch (SQLException e) {
            mensaje = "otros errores " + e.getMessage();
        }
        return mensaje;
    }

    public void filtroEmpleadoRut(Connection con, JTable tabla, String rut) {

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "APELLIDO", "RUT", "TELEFONO", "DIRECCION", "E-MAIL", "TIPO USUARIO", "CLAVE", "ID TIPO", "ID DOC"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[11];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT E.ID_EMP, E.NOM_EMP, E.APE_EMP, E.RUT_EMP ,E.FONO_EMP, E.DIRE_EMP, E.MAIL_EMP, T.NOM_TIPO_USUARIO, E.PASS_EMP,E.ID_TIPO_USUARIO,D.ID_DOC\n"
                    + "FROM EMPLEADO E\n"
                    + "LEFT JOIN TIPO_USUARIO T\n"
                    + "ON E.ID_TIPO_USUARIO = T.ID_TIPO_USUARIO\n"
                    + "LEFT JOIN DOCTOR D\n"
                    + "ON E.RUT_EMP = D.RUT_DOC\n"
                    + "WHERE E.ID_TIPO_USUARIO BETWEEN 2 AND 3 AND E.RUT_EMP LIKE ?\n"
                    + "ORDER BY ID_EMP";

            pst = con.prepareStatement(sql);
            pst.setString(1, rut);
            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    public void filtroEmpleadoTipo(Connection con, JTable tabla, int tipo) {

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "APELLIDO", "RUT", "TELEFONO", "DIRECCION", "E-MAIL", "TIPO USUARIO", "CLAVE", "ID TIPO", "ID DOC"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[11];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT E.ID_EMP, E.NOM_EMP, E.APE_EMP, E.RUT_EMP ,E.FONO_EMP, E.DIRE_EMP, E.MAIL_EMP, T.NOM_TIPO_USUARIO, E.PASS_EMP,E.ID_TIPO_USUARIO,D.ID_DOC\n"
                    + "FROM EMPLEADO E\n"
                    + "LEFT JOIN TIPO_USUARIO T\n"
                    + "ON E.ID_TIPO_USUARIO = T.ID_TIPO_USUARIO\n"
                    + "LEFT JOIN DOCTOR D\n"
                    + "ON E.RUT_EMP = D.RUT_DOC\n"
                    + "WHERE E.ID_TIPO_USUARIO = ?"
                    + "ORDER BY ID_EMP";

            pst = con.prepareStatement(sql);
            pst.setInt(1, tipo);
            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    public void filtroEmpleadoRutTipo(Connection con, JTable tabla, int tipo, String rut) {

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "APELLIDO", "RUT", "TELEFONO", "DIRECCION", "E-MAIL", "TIPO USUARIO", "CLAVE", "ID TIPO", "ID DOC"};

        model = new DefaultTableModel(null, columnas);
        String[] filas = new String[11];
        Statement st = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT E.ID_EMP, E.NOM_EMP, E.APE_EMP, E.RUT_EMP ,E.FONO_EMP, E.DIRE_EMP, E.MAIL_EMP, T.NOM_TIPO_USUARIO, E.PASS_EMP,E.ID_TIPO_USUARIO,D.ID_DOC\n"
                    + "FROM EMPLEADO E\n"
                    + "LEFT JOIN TIPO_USUARIO T\n"
                    + "ON E.ID_TIPO_USUARIO = T.ID_TIPO_USUARIO\n"
                    + "LEFT JOIN DOCTOR D\n"
                    + "ON E.RUT_EMP = D.RUT_DOC\n"
                    + "WHERE E.RUT_EMP LIKE ? AND E.ID_TIPO_USUARIO = ?\n"
                    + "ORDER BY ID_EMP";

            pst = con.prepareStatement(sql);
            pst.setString(1, rut);
            pst.setInt(2, tipo);
            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    public String formatear(String rut) {
        int cont = 0;
        String format;
        if (rut.length() == 0) {
            return "";
        } else {
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            format = "-" + rut.substring(rut.length() - 1);
            for (int i = rut.length() - 2; i >= 0; i--) {
                format = rut.substring(i, i + 1) + format;
                cont++;
                if (cont == 3 && i != 0) {
                    format = "." + format;
                    cont = 0;
                }
            }
            return format;
        }
    }

    public boolean validar(String rut) {
        int suma = 0;
        String dvR, dvT;
        int[] serie = {2, 3, 4, 5, 6, 7};
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        dvR = rut.substring(rut.length() - 1);
        for (int i = rut.length() - 2; i >= 0; i--) {
            suma += Integer.valueOf(rut.substring(i, i + 1))
                    * serie[(rut.length() - 2 - i) % 6];
        }
        dvT = String.valueOf(11 - suma % 11);
        if (dvT.compareToIgnoreCase("10") == 0) {
            dvT = "K";
        }

        if (dvT.compareToIgnoreCase(dvR) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
