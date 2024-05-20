
package Vista;

import Negocio.Conexion;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JFLogin extends javax.swing.JFrame {
    JFMenu jfmenu;
    Conexion conn = new Conexion();
    
    public JFLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        Toolkit im = Toolkit.getDefaultToolkit();
        setIconImage(im.getImage(getClass().getResource("/ImagenesLogin/ICONOPRINCIPAL.png")));//COLOCAR EL ÍCONO DEL PROGRAMA
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtCitasMedicas = new javax.swing.JLabel();
        IconoHospital = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LoginIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        UserIcon = new javax.swing.JLabel();
        jTFUser = new javax.swing.JTextField();
        PasswIcon = new javax.swing.JLabel();
        jTFPassword = new javax.swing.JPasswordField();
        jBSalir = new javax.swing.JButton();
        jBIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(69, 199, 197));

        TxtCitasMedicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/TextoCitasMedicas.png"))); // NOI18N

        IconoHospital.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/HospitalIcon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(TxtCitasMedicas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(IconoHospital)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(TxtCitasMedicas, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(IconoHospital)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/UserMain.png"))); // NOI18N
        jPanel2.add(LoginIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Iniciar Sesión");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(69, 199, 197));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 378, 248, 10));

        jSeparator2.setForeground(new java.awt.Color(69, 199, 197));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 454, 248, 10));

        UserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/UserIcono.png"))); // NOI18N
        UserIcon.setEnabled(false);
        jPanel2.add(UserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 342, -1, -1));

        jTFUser.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTFUser.setForeground(new java.awt.Color(153, 153, 153));
        jTFUser.setText("Ingrese su usuario");
        jTFUser.setBorder(null);
        jTFUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFUserMousePressed(evt);
            }
        });
        jTFUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFUserActionPerformed(evt);
            }
        });
        jPanel2.add(jTFUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 342, 200, 30));

        PasswIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/PasswordIcono.png"))); // NOI18N
        PasswIcon.setEnabled(false);
        jPanel2.add(PasswIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 418, -1, -1));

        jTFPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTFPassword.setForeground(new java.awt.Color(153, 153, 153));
        jTFPassword.setText("jPasswoFFFF");
        jTFPassword.setBorder(null);
        jTFPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFPasswordMousePressed(evt);
            }
        });
        jTFPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(jTFPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 418, 200, 30));

        jBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/IconoSalir.png"))); // NOI18N
        jBSalir.setBorderPainted(false);
        jBSalir.setContentAreaFilled(false);
        jBSalir.setFocusPainted(false);
        jBSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/IconoSalirPress.png"))); // NOI18N
        jBSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/IconoSalirSet.png"))); // NOI18N
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });
        jPanel2.add(jBSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 0, 37, 35));

        jBIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/IngresarIcon.png"))); // NOI18N
        jBIngresar.setBorderPainted(false);
        jBIngresar.setContentAreaFilled(false);
        jBIngresar.setFocusPainted(false);
        jBIngresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/IngresarIconPress.png"))); // NOI18N
        jBIngresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesLogin/IngresarIconSelect.png"))); // NOI18N
        jBIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(jBIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 160, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Usuario");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Contraseña");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 430, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresarActionPerformed
        try {
            //METODO PARA REALIZAR LA CONEXIÓN CON LA BASE DE DATOS, USANDO EL USUARIO ROOT Y LA CONTRASEÑA DESIGNADA (2021)
            jfmenu = new JFMenu();
        } catch (SQLException ex) {
            Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(this.jTFUser.getText().equalsIgnoreCase("root")&&(Arrays.equals(this.jTFPassword.getPassword(), new char[]{'2','0','2','1'}))){
            Connection con = Conexion.getConexion();
            JOptionPane.showMessageDialog(null,"BASE DE DATOS: CITAS MÉDICAS\nConexión exitosa ");
            jfmenu.setVisible(true);
            this.setVisible(false);
       }else{
           getToolkit().beep();//GENERA UN SONIDO DEL SISTEMA CUANDO SE INGRESA MAL LA CONTRASEÑA
           JOptionPane.showMessageDialog(null,"EL USUARIO O CONTRASEÑA NO COINCIDEN");
        //CÓDIGO CUANDO LA CONTRASEÑA ES INCORRECTA Y COLOCAR EL TEXTO INICIAL EN LOS CAMPOS
           this.jTFUser.setText("Ingrese su usuario");
           this.jTFUser.setForeground(Color.GRAY);
           this.jTFPassword.setText("jPasswoFFFF");
           this.jTFPassword.setForeground(Color.GRAY);
       }
    }//GEN-LAST:event_jBIngresarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTFPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPasswordActionPerformed

    }//GEN-LAST:event_jTFPasswordActionPerformed

    private void jTFPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFPasswordMousePressed
      //MÉTODO SIMULAR LOS EFECTOS DE INTERFAZ EN CONTRASEÑA Y USUARIO
        if(String.valueOf(this.jTFPassword.getPassword()).equals("jPasswoFFFF")){
            this.jTFPassword.setText("");
            this.jTFPassword.setForeground(Color.BLACK);
        }
        if(this.jTFUser.getText().isEmpty()){
            this.jTFUser.setText("Ingrese su usuario");
            this.jTFUser.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jTFPasswordMousePressed

    private void jTFUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFUserActionPerformed
        
    }//GEN-LAST:event_jTFUserActionPerformed

    private void jTFUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFUserMousePressed
       //MÉTODO SIMULAR LOS EFECTOS DE INTERFAZ EN CONTRASEÑA Y USUARIO
        if(this.jTFUser.getText().equals("Ingrese su usuario")){
            this.jTFUser.setText("");
            this.jTFUser.setForeground(Color.BLACK);
        }
        if(String.valueOf(this.jTFPassword.getPassword()).isEmpty()){
            this.jTFPassword.setText("jPasswoFFFF");
            this.jTFPassword.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jTFUserMousePressed

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
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconoHospital;
    private javax.swing.JLabel LoginIcon;
    private javax.swing.JLabel PasswIcon;
    private javax.swing.JLabel TxtCitasMedicas;
    private javax.swing.JLabel UserIcon;
    private javax.swing.JButton jBIngresar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField jTFPassword;
    private javax.swing.JTextField jTFUser;
    // End of variables declaration//GEN-END:variables
}
