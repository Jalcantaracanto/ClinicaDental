/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import BO.DoctorBO;
import BO.EmpleadoBO;
import Entidades.Cliente;
import Entidades.Doctor;
import Entidades.Empleado;
import Entidades.TipoUsuario;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author marck
 */
public class SistemaEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form SistemaEmpleado
     */
    private EmpleadoBO ebo = new EmpleadoBO();
    private DoctorBO dbo = new DoctorBO();

    public SistemaEmpleado() {
        initComponents();
        listarEmpleado();
        idMax();
        activo();
        cargarCombo();
        cargarEmpleado();
        idMaxDoc();
    }

    public void listarEmpleado() {
        ebo.listarEmpleado(tbEmpleados);
    }

    public void idMax() {
        txtID.setText(ebo.getMaxID() + "");
    }

    public void idMaxDoc() {
        txtIdDoc.setText(dbo.getMaxID() + "");
    }

    public void activo() {
        txtID.setVisible(false);
        txtIdDoc.setVisible(false);
        txtID2.setVisible(false);
        txtServicio.setVisible(false);
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtRut.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtCorreo.setEnabled(true);
        cboTipoEmpleado.setEnabled(true);
        txtPass.setEnabled(true);
    }

    public void desactivado() {
        txtID.setVisible(false);
        txtIdDoc.setVisible(false);
        txtID2.setVisible(false);
        txtServicio.setVisible(false);
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtRut.setEnabled(false);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtCorreo.setEnabled(true);
        cboTipoEmpleado.setEnabled(false);
        txtPass.setEnabled(false);
    }

    public void cargarCombo() {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) this.cboTipoEmpleado.getModel();
        modelo.removeAllElements();
        ArrayList<TipoUsuario> tusu = new ArrayList<TipoUsuario>();
        EmpleadoBO tu = new EmpleadoBO();
        tusu = tu.cargarLista();
        modelo.addElement("Seleccione");
        for (TipoUsuario temp : tusu) {
            modelo.addElement(temp);
        }
    }

    public void cargarEmpleado() {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) this.cboEmpleado.getModel();
        modelo.removeAllElements();
        ArrayList<TipoUsuario> tusu = new ArrayList<TipoUsuario>();
        EmpleadoBO tu = new EmpleadoBO();
        tusu = tu.cargarLista();
        modelo.addElement("Seleccione");
        for (TipoUsuario temp : tusu) {
            modelo.addElement(temp);
        }
    }

    public TipoUsuario rescatoIDEmpleado() {
        TipoUsuario usu = new TipoUsuario();
        usu = (TipoUsuario) this.cboEmpleado.getSelectedItem();
        return usu;
    }

    public TipoUsuario rescatoID() {
        TipoUsuario usu = new TipoUsuario();
        usu = (TipoUsuario) this.cboTipoEmpleado.getSelectedItem();
        return usu;
    }

    public void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtRut.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        cboTipoEmpleado.setSelectedIndex(0);
        txtPass.setText("");
    }

    public boolean validarCorreo() {
        if (txtCorreo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Correo");
            return false;
        } else if (!txtCorreo.getText().contains("@") || !txtCorreo.getText().contains(".")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un correo Valido");
            return false;
        } else {
            return true;
        }
    }

    public boolean validarRut() {
        if (txtRut.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Rut");
            return false;
        } else if (!txtRut.getText().contains(".") || !txtRut.getText().contains("-")) {
            JOptionPane.showMessageDialog(null, "Ingrese Rut en Formato xx.xxx.xxx-x");
            return false;
        } else {
            return true;
        }
    }

    public boolean validarNombre() {
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Nombre");
            return false;
        } else {
            return true;
        }
    }

    public Boolean validarApellido() {
        if (txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Apellido");
            return false;
        } else {
            return true;
        }
    }

    public Boolean validarTelefono() {
        if (txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Telefono");
            return false;
        } else if (!txtTelefono.getText().matches("[0-9]{1,20}")) {
            JOptionPane.showMessageDialog(null, "Ingrese Digitos en Telefono");
            return false;
        } else {
            return true;
        }
    }

    public Boolean validarDireccion() {
        if (txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Dirección");
            return false;
        } else {
            return true;
        }
    }

    public Boolean validarClave() {
        if (txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Contraseña");
            return false;
        } else {
            return true;
        }
    }

    public Boolean validarUsuario() {
        if (cboTipoEmpleado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione Tipo Usuario");
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtRut = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtBRut = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        txtIdDoc = new javax.swing.JTextField();
        cboTipoEmpleado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        cboEmpleado = new javax.swing.JComboBox<>();
        txtID2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JToggleButton();
        btnRegistrar = new javax.swing.JToggleButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtServicio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 160, -1));

        txtApellido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtApellido.setBorder(null);
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 160, -1));

        txtDireccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtDireccion.setBorder(null);
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 160, -1));

        txtCorreo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCorreo.setBorder(null);
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 160, -1));

        txtRut.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtRut.setBorder(null);
        jPanel1.add(txtRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 160, -1));

        txtTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTelefono.setBorder(null);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 160, -1));

        txtBRut.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtBRut.setBorder(null);
        txtBRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBRutKeyReleased(evt);
            }
        });
        jPanel1.add(txtBRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 130, -1));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, 134, -1));

        txtPass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPass.setBorder(null);
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 160, -1));

        txtIdDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDocActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, 47, -1));

        cboTipoEmpleado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cboTipoEmpleado.setBorder(null);
        cboTipoEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTipoEmpleadoItemStateChanged(evt);
            }
        });
        cboTipoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoEmpleadoActionPerformed(evt);
            }
        });
        cboTipoEmpleado.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboTipoEmpleadoPropertyChange(evt);
            }
        });
        jPanel1.add(cboTipoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 160, -1));

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpleados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 817, 294));

        cboEmpleado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cboEmpleado.setBorder(null);
        cboEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboEmpleadoItemStateChanged(evt);
            }
        });
        jPanel1.add(cboEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 134, -1));
        jPanel1.add(txtID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, 134, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 100, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 160, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 160, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 160, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 160, 10));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 160, 10));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 160, 10));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 160, 10));

        jLabel11.setBackground(new java.awt.Color(102, 153, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 153, 255));
        jLabel11.setText("Sistema Empleados");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 350, 50));

        jLabel13.setBackground(new java.awt.Color(102, 153, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 153, 255));
        jLabel13.setText("Apellido");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 60, -1));

        jLabel14.setBackground(new java.awt.Color(102, 153, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 153, 255));
        jLabel14.setText("Password");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 80, -1));

        jLabel15.setBackground(new java.awt.Color(102, 153, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 153, 255));
        jLabel15.setText("Busqueda:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 100, -1));

        jLabel16.setBackground(new java.awt.Color(102, 153, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 153, 255));
        jLabel16.setText("Rut");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 60, -1));

        jLabel17.setBackground(new java.awt.Color(102, 153, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 153, 255));
        jLabel17.setText("Telefono");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 70, -1));

        jLabel18.setBackground(new java.awt.Color(102, 153, 255));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 153, 255));
        jLabel18.setText("Dirección");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 70, -1));

        jLabel19.setBackground(new java.awt.Color(102, 153, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 153, 255));
        jLabel19.setText("Correo");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 70, -1));

        jLabel20.setBackground(new java.awt.Color(102, 153, 255));
        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 153, 255));
        jLabel20.setText("Tipo Empleado");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 110, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Linda Sonrisa.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 100));

        jLabel21.setBackground(new java.awt.Color(102, 153, 255));
        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 153, 255));
        jLabel21.setText("Rut:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 30, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Atrás.png"))); // NOI18N
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Atrás 2.png"))); // NOI18N
        btnAtras.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Atrás 2.png"))); // NOI18N
        btnAtras.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Atrás 2.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 40, 40));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiar.jpg"))); // NOI18N
        btnLimpiar.setBorder(null);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiar 2.jpg"))); // NOI18N
        btnLimpiar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiar 2.jpg"))); // NOI18N
        btnLimpiar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiar 2.jpg"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 130, 31));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Registrar.jpg"))); // NOI18N
        btnRegistrar.setBorder(null);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Registrar 2.jpg"))); // NOI18N
        btnRegistrar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Registrar 2.jpg"))); // NOI18N
        btnRegistrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Registrar 2.jpg"))); // NOI18N
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 130, 30));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.jpg"))); // NOI18N
        btnModificar.setBorder(null);
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar 2.jpg"))); // NOI18N
        btnModificar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar 2.jpg"))); // NOI18N
        btnModificar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar 2.jpg"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 130, 30));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar.jpg"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar 2.jpg"))); // NOI18N
        btnEliminar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar 2.jpg"))); // NOI18N
        btnEliminar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar 2.jpg"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 130, 31));

        jSeparator9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 460, 40));

        jLabel22.setBackground(new java.awt.Color(102, 153, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 153, 255));
        jLabel22.setText("Linda Sonrisa");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, -1));

        jLabel23.setBackground(new java.awt.Color(102, 153, 255));
        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 153, 255));
        jLabel23.setText("Nombre");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 60, -1));

        jLabel24.setBackground(new java.awt.Color(102, 153, 255));
        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 153, 255));
        jLabel24.setText("Tipo Empleado:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 110, -1));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 130, 10));
        jPanel1.add(txtServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1198, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        MenuAdministrador srb = new MenuAdministrador();
        srb.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Object[] options = {"Si", "No"};
        int var = JOptionPane.showOptionDialog(this, "Si Elimina el Doctor se eliminaran Reservas asociados a el.\n ¿Desea Continuar?", "¡CUIDADO!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
        if (txtID2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un Empleado para Eliminar");
        } else {

            int seleccion = cboTipoEmpleado.getSelectedIndex();
            String mensaje1 = "";
            String mensaje2 = "";
            String mensaje3 = "";
            
            if ( var == 0 && rescatoID().getId_tipo_usuario() == 2) {
                mensaje3 = dbo.eliminarReserva(Integer.parseInt(txtServicio.getText()));
                mensaje1 = dbo.eliminarDoctor(txtRut.getText().toString());
                mensaje2 = ebo.eliminarEmpleado(Integer.parseInt(txtID.getText()));
                JOptionPane.showMessageDialog(null, mensaje1);
                JOptionPane.showMessageDialog(null, mensaje2);
                JOptionPane.showMessageDialog(null, mensaje3);
                listarEmpleado();
                limpiar();
                idMax();
                idMaxDoc();
                activo();
            } else {
                mensaje2 = ebo.eliminarEmpleado(Integer.parseInt(txtID.getText()));
                JOptionPane.showMessageDialog(null, mensaje2);
                listarEmpleado();
                limpiar();
                idMax();
                idMaxDoc();
                activo();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cboEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEmpleadoItemStateChanged
        if (cboEmpleado.getSelectedIndex() == 0) {
            ebo.filtroEmpleadoRut(tbEmpleados, txtBRut.getText().toUpperCase() + '%');
        } else if (txtBRut.getText().isEmpty()) {
            ebo.filtroEmpleadoTipo(tbEmpleados, rescatoIDEmpleado().getId_tipo_usuario());
        } else if (cboEmpleado.getSelectedIndex() > 0) {
            ebo.filtroEmpleadoRutTipo(tbEmpleados, rescatoIDEmpleado().getId_tipo_usuario(), txtBRut.getText().toUpperCase() + '%');
        }
    }//GEN-LAST:event_cboEmpleadoItemStateChanged

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked
        int seleccion = tbEmpleados.rowAtPoint(evt.getPoint());
        txtID.setText(tbEmpleados.getValueAt(seleccion, 0) + "");
        txtID2.setText(tbEmpleados.getValueAt(seleccion, 0) + "");
        txtNombre.setText(tbEmpleados.getValueAt(seleccion, 1) + "");
        txtApellido.setText(tbEmpleados.getValueAt(seleccion, 2) + "");
        txtRut.setText(tbEmpleados.getValueAt(seleccion, 3) + "");
        txtTelefono.setText(tbEmpleados.getValueAt(seleccion, 4) + "");
        txtDireccion.setText(tbEmpleados.getValueAt(seleccion, 5) + "");
        txtCorreo.setText(tbEmpleados.getValueAt(seleccion, 6) + "");
        String var = tbEmpleados.getValueAt(seleccion, 7) + "";
        txtPass.setText(tbEmpleados.getValueAt(seleccion, 8) + "");
        txtServicio.setText(tbEmpleados.getValueAt(seleccion, 10) + "");

        switch (var) {
            case "DOCTOR":
                cboTipoEmpleado.setSelectedIndex(1);
                break;
            case "SECRETARIA/O":
                cboTipoEmpleado.setSelectedIndex(2);
                break;
        }

        desactivado();
    }//GEN-LAST:event_tbEmpleadosMouseClicked

    private void cboTipoEmpleadoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboTipoEmpleadoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoEmpleadoPropertyChange

    private void cboTipoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoEmpleadoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoEmpleadoActionPerformed

    private void cboTipoEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTipoEmpleadoItemStateChanged
        if (this.cboTipoEmpleado.getSelectedIndex() > 0) {
            TipoUsuario tipo = new TipoUsuario();
            tipo = (TipoUsuario) this.cboTipoEmpleado.getSelectedItem();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoEmpleadoItemStateChanged

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtID2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un Empleado a Modificar");
        } else if (validarNombre() == false || validarApellido() == false || validarRut() == false || validarTelefono() == false || validarDireccion() == false || validarCorreo() == false || validarUsuario() == false || validarClave() == false) {
        } else {

            Doctor doc = new Doctor();
            Empleado emp = new Empleado();

            if (rescatoID().getId_tipo_usuario() == 2) {

                doc.setNom_doc(txtNombre.getText().toUpperCase());
                doc.setApe_doc(txtApellido.getText().toUpperCase());
                doc.setRut_doc(txtRut.getText().toUpperCase());
                doc.setFono_doc(txtTelefono.getText().toUpperCase());
                doc.setDire_doc(txtDireccion.getText().toUpperCase());
                doc.setMail_doc(txtCorreo.getText().toUpperCase());
                doc.setId_tipo_usuario(rescatoID().getId_tipo_usuario());
                String mensaje1 = dbo.modificarDoctor(doc);

                emp.setId_empleado(Integer.parseInt(txtID.getText()));
                emp.setNom_emp(txtNombre.getText().toUpperCase());
                emp.setApe_emp(txtApellido.getText().toUpperCase());
                emp.setRut_emp(txtRut.getText().toUpperCase());
                emp.setFono_emp(txtTelefono.getText().toUpperCase());
                emp.setDire_emp(txtDireccion.getText().toUpperCase());
                emp.setMail_emp(txtCorreo.getText().toUpperCase());
                emp.setId_clinica(1);
                emp.setId_tipo_usuario(rescatoID().getId_tipo_usuario());
                emp.setPass_emp(txtPass.getText());

                String mensaje2 = ebo.modificarEmpleado(emp);
                JOptionPane.showMessageDialog(null, mensaje1);
                JOptionPane.showMessageDialog(null, mensaje2);
            } else {
                emp.setId_empleado(Integer.parseInt(txtID.getText()));
                emp.setNom_emp(txtNombre.getText().toUpperCase());
                emp.setApe_emp(txtApellido.getText().toUpperCase());
                emp.setRut_emp(txtRut.getText().toUpperCase());
                emp.setFono_emp(txtTelefono.getText().toUpperCase());
                emp.setDire_emp(txtDireccion.getText().toUpperCase());
                emp.setMail_emp(txtCorreo.getText().toUpperCase());
                emp.setId_clinica(1);
                emp.setId_tipo_usuario(rescatoID().getId_tipo_usuario());
                emp.setPass_emp(txtPass.getText());

                String mensaje2 = ebo.modificarEmpleado(emp);
                JOptionPane.showMessageDialog(null, mensaje2);
            }
            listarEmpleado();
            limpiar();
            idMax();
            idMaxDoc();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarNombre() == false || validarApellido() == false || validarRut() == false || validarTelefono() == false || validarDireccion() == false || validarCorreo() == false || validarUsuario() == false || validarClave() == false) {
        } else {

            Doctor doc = new Doctor();
            Empleado emp = new Empleado();

            if (rescatoID().getId_tipo_usuario() == 2) {
                doc.setId_Doc(Integer.parseInt(txtIdDoc.getText()));
                doc.setNom_doc(txtNombre.getText().toUpperCase());
                doc.setApe_doc(txtApellido.getText().toUpperCase());
                doc.setRut_doc(txtRut.getText().toUpperCase());
                doc.setFono_doc(txtTelefono.getText().toUpperCase());
                doc.setDire_doc(txtDireccion.getText().toUpperCase());
                doc.setMail_doc(txtCorreo.getText().toUpperCase());
                doc.setId_tipo_usuario(rescatoID().getId_tipo_usuario());
                String mensaje1 = dbo.agregarDoctor(doc);

                emp.setId_empleado(Integer.parseInt(txtID.getText()));
                emp.setNom_emp(txtNombre.getText().toUpperCase());
                emp.setApe_emp(txtApellido.getText().toUpperCase());
                emp.setRut_emp(txtRut.getText().toUpperCase());
                emp.setFono_emp(txtTelefono.getText().toUpperCase());
                emp.setDire_emp(txtDireccion.getText().toUpperCase());
                emp.setMail_emp(txtCorreo.getText().toUpperCase());
                emp.setId_tipo_usuario(rescatoID().getId_tipo_usuario());
                emp.setPass_emp(txtPass.getText().toUpperCase());

                String mensaje2 = ebo.agregarEmpleado(emp);
                JOptionPane.showMessageDialog(null, mensaje1);
                JOptionPane.showMessageDialog(null, mensaje2);
            } else {
                emp.setId_empleado(Integer.parseInt(txtID.getText()));
                emp.setNom_emp(txtNombre.getText().toUpperCase());
                emp.setApe_emp(txtApellido.getText().toUpperCase());
                emp.setRut_emp(txtRut.getText().toUpperCase());
                emp.setFono_emp(txtTelefono.getText().toUpperCase());
                emp.setDire_emp(txtDireccion.getText().toUpperCase());
                emp.setMail_emp(txtCorreo.getText().toUpperCase());
                emp.setId_tipo_usuario(rescatoID().getId_tipo_usuario());
                emp.setPass_emp(txtPass.getText().toUpperCase());

                String mensaje2 = ebo.agregarEmpleado(emp);
                JOptionPane.showMessageDialog(null, mensaje2);
            }
            listarEmpleado();
            limpiar();
            idMax();
            idMaxDoc();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        idMax();
        activo();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtIdDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDocActionPerformed

    private void txtBRutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBRutKeyReleased
        if (cboEmpleado.getSelectedIndex() == 0) {
            ebo.filtroEmpleadoRut(tbEmpleados, txtBRut.getText().toUpperCase() + '%');
        } else if (txtBRut.getText().isEmpty()) {
            ebo.filtroEmpleadoTipo(tbEmpleados, rescatoIDEmpleado().getId_tipo_usuario());
        } else if (cboEmpleado.getSelectedIndex() > 0) {
            ebo.filtroEmpleadoRutTipo(tbEmpleados, rescatoIDEmpleado().getId_tipo_usuario(), txtBRut.getText().toUpperCase() + '%');
        }
    }//GEN-LAST:event_txtBRutKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SistemaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JToggleButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JToggleButton btnRegistrar;
    private javax.swing.JComboBox<String> cboEmpleado;
    private javax.swing.JComboBox<String> cboTipoEmpleado;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBRut;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtIdDoc;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
