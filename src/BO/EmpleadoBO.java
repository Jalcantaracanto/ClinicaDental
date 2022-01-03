/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import BD.Conexion;
import DAO.EmpleadoDAO;
import Entidades.Empleado;
import Entidades.TipoUsuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Zuukens
 */
public class EmpleadoBO {

    private String mensaje = "";
    private EmpleadoDAO empdao = new EmpleadoDAO();

    public String agregarEmpleado(Empleado emp) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = empdao.agregarEmpleado(conn, emp);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String modificarEmpleado(Empleado emp) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = empdao.modificarEmpleado(conn, emp);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String eliminarEmpleado(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = empdao.eliminarEmpleado(conn, id);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public void listarEmpleado(JTable tabla) {
        Connection conn = Conexion.getConnection();
        empdao.listarEmpleado(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //CUSTOM
    public int getMaxID() {
        Connection conn = Conexion.getConnection();
        int id = empdao.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public ArrayList<TipoUsuario> cargarLista() {
        Connection conn = Conexion.getConnection();
        ArrayList<TipoUsuario> tipoUsuario = empdao.cargarLista(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tipoUsuario;
    }

    public String Login(Empleado emp) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = empdao.Login(conn, emp);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public void filtroEmpleadoRut(JTable tabla, String rut) {
        Connection conn = Conexion.getConnection();
        empdao.filtroEmpleadoRut(conn, tabla, rut);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void filtroEmpleadoTipo(JTable tabla, int tipo) {
        Connection conn = Conexion.getConnection();
        empdao.filtroEmpleadoTipo(conn, tabla, tipo);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void filtroEmpleadoRutTipo(JTable tabla, int tipo, String rut) {
        Connection conn = Conexion.getConnection();
        empdao.filtroEmpleadoRutTipo(conn, tabla, tipo, rut);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean validar(String rut){
        Connection conn = Conexion.getConnection();
        boolean var = empdao.validar(rut);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return var;
    }
}
