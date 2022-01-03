/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import BO.EmpleadoBO;
import Entidades.Empleado;
import com.placeholder.PlaceHolder;
import javax.swing.JOptionPane;

/**
 *
 * @author Zuukens
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    EmpleadoBO em = new EmpleadoBO();

    public Login() {
        initComponents();
    }
    
    public boolean validarContraseña() {
        if (txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Contraseña");
            return false;
        } else {
            return true;
        }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpIngreso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnManual = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpIngreso.setBackground(new java.awt.Color(255, 255, 255));
        jpIngreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpIngreso.setForeground(new java.awt.Color(255, 255, 255));
        jpIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 153, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setText("Contraseña:");
        jpIngreso.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel2.setBackground(new java.awt.Color(102, 153, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 153, 255));
        jLabel2.setText("Correo:");
        jpIngreso.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login.jpg"))); // NOI18N
        jpIngreso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(102, 102, 102));
        txtCorreo.setBorder(null);
        jpIngreso.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 190, 30));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setToolTipText("");
        jpIngreso.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 230, 20));

        txtPassword.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        txtPassword.setBorder(null);
        jpIngreso.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 190, 30));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setToolTipText("");
        jpIngreso.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 230, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/correo.png"))); // NOI18N
        jpIngreso.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 30, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clave.png"))); // NOI18N
        jpIngreso.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Entrar.jpg"))); // NOI18N
        btnEntrar.setBorder(null);
        btnEntrar.setBorderPainted(false);
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Entrar 2.jpg"))); // NOI18N
        btnEntrar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Entrar 2.jpg"))); // NOI18N
        btnEntrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Entrar 2.jpg"))); // NOI18N
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jpIngreso.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 120, 50));

        jLabel6.setBackground(new java.awt.Color(102, 153, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 153, 255));
        jLabel6.setText("Linda Sonrisa");
        jpIngreso.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        jLabel7.setBackground(new java.awt.Color(102, 153, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 153, 255));
        jLabel7.setText("Clinica");
        jpIngreso.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 180, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Linda Sonrisa.jpg"))); // NOI18N
        jpIngreso.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 100));

        btnManual.setBackground(new java.awt.Color(255, 255, 255));
        btnManual.setForeground(new java.awt.Color(255, 255, 255));
        btnManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pregunta.png"))); // NOI18N
        btnManual.setBorderPainted(false);
        btnManual.setContentAreaFilled(false);
        btnManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManualActionPerformed(evt);
            }
        });
        jpIngreso.add(btnManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 40, -1));

        getContentPane().add(jpIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (validarCorreo() == false || validarContraseña() == false) {
        } else {
            Empleado emp = new Empleado();

            emp.setMail_emp(txtCorreo.getText().toUpperCase());
            emp.setPass_emp(txtPassword.getText().toUpperCase());

            String mensaje = em.Login(emp);

            if (mensaje.equals("1")) {
                JOptionPane.showMessageDialog(null, "Bienvenido al Sistema");
                MenuAdministrador srb = new MenuAdministrador();
                srb.setVisible(true);
                this.setVisible(false);
            } else if (mensaje.equals("2")) {
                JOptionPane.showMessageDialog(null, "Bienvenido al Sistema");
                MenuDoctor srb = new MenuDoctor();
                srb.setVisible(true);
                this.setVisible(false);
            } else if (mensaje.equals("3")) {
                JOptionPane.showMessageDialog(null, "Bienvenido al Sistema");
                MenuSecretaria srb = new MenuSecretaria();
                srb.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO INVALIDO");
            }
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManualActionPerformed
        try {
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:\\Universidad\\Proyectos Java\\ClinicaDental\\PDF\\Manual de Usuario Escritorio.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chek File Details");
        }
    }//GEN-LAST:event_btnManualActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnManual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpIngreso;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
