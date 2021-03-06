/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JOptionPane;

/**
 *
 * @author Zuukens
 */
public class MenuSecretaria extends javax.swing.JFrame {

    /**
     * Creates new form MenuSecretaria
     */
    public MenuSecretaria() {
        initComponents();
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
        btnPedidos = new javax.swing.JButton();
        btnHorasMedicas = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnManual = new javax.swing.JButton();
        btnDesconectar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pedidos.jpg"))); // NOI18N
        btnPedidos.setBorderPainted(false);
        btnPedidos.setContentAreaFilled(false);
        btnPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPedidos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pedidos 2.jpg"))); // NOI18N
        btnPedidos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pedidos 2.jpg"))); // NOI18N
        btnPedidos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pedidos 2.jpg"))); // NOI18N
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });
        jPanel1.add(btnPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 200, 41));

        btnHorasMedicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Horas Medicas.jpg"))); // NOI18N
        btnHorasMedicas.setBorderPainted(false);
        btnHorasMedicas.setContentAreaFilled(false);
        btnHorasMedicas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHorasMedicas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Horas Medicas 2.jpg"))); // NOI18N
        btnHorasMedicas.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Horas Medicas 2.jpg"))); // NOI18N
        btnHorasMedicas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Horas Medicas 2.jpg"))); // NOI18N
        btnHorasMedicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorasMedicasActionPerformed(evt);
            }
        });
        jPanel1.add(btnHorasMedicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 200, 41));

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes.jpg"))); // NOI18N
        btnClientes.setContentAreaFilled(false);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setDefaultCapable(false);
        btnClientes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes 2.jpg"))); // NOI18N
        btnClientes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes 2.jpg"))); // NOI18N
        btnClientes.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes 2.jpg"))); // NOI18N
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 200, 40));

        jLabel7.setBackground(new java.awt.Color(102, 153, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 153, 255));
        jLabel7.setText("Menu Secretaria");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 280, 50));

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
        jPanel1.add(btnManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 40, -1));

        btnDesconectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Desconectar.jpg"))); // NOI18N
        btnDesconectar.setBorderPainted(false);
        btnDesconectar.setContentAreaFilled(false);
        btnDesconectar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesconectar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Desconectar 2.jpg"))); // NOI18N
        btnDesconectar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Desconectar 2.jpg"))); // NOI18N
        btnDesconectar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Desconectar 2.jpg"))); // NOI18N
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 120, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Linda Sonrisa.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 90, 70));

        jLabel13.setBackground(new java.awt.Color(102, 153, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 153, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/servicios.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 80, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pedidos.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 90, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        ListaClientes srb = new ListaClientes();
        srb.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        IngresarInsumosSEC srb = new IngresarInsumosSEC();
        srb.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnHorasMedicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorasMedicasActionPerformed
        HorasMedicasSec srb = new HorasMedicasSec();
        srb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHorasMedicasActionPerformed

    private void btnManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManualActionPerformed
        try {
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:\\Universidad\\Proyectos Java\\ClinicaDental\\PDF\\Manual de Usuario Escritorio.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chek File Details");
        }
    }//GEN-LAST:event_btnManualActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        Login srb = new Login();
        srb.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesconectarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuSecretaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnHorasMedicas;
    private javax.swing.JButton btnManual;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
