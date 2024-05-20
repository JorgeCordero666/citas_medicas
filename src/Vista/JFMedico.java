
package Vista;

import Negocio.Conexion;
import Negocio.Especialidad;
import Negocio.GenerarCodigo;
import Negocio.Medico;
import Table.TableMedico;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class JFMedico extends javax.swing.JFrame {
    Medico medico ;
    ArrayList<String> comboEspecialidades;
    TableMedico tabla =  new TableMedico();

    public JFMedico() throws SQLException {
        initComponents();
        MedicoTable();
        medico = new Medico();
        comboEspecialidades = new ArrayList<String>();
        this.setLocationRelativeTo(null);
        this.setTitle("Médico");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Toolkit im = Toolkit.getDefaultToolkit();
        setIconImage(im.getImage(getClass().getResource("/ImagenesLogin/ICONOPRINCIPAL.png")));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        jTFFechaActual.setText(dtf.format(LocalDateTime.now()));
        cargarEspecialidades();
        jTableMedico.getTableHeader().setFont(new Font("Dialog", 0 , 12));
        bloquear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFIdMedico = new javax.swing.JTextField();
        jTFApellidoMedico = new javax.swing.JTextField();
        jTFNombreMedico = new javax.swing.JTextField();
        jCBEspecialidades = new javax.swing.JComboBox<>();
        jTFTelefonoMedico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMedico = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTFFechaActual = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jBNuevo = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jBRegresar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTFBuscar = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jBLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(99, 199, 197));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Médico");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(280, 280, 280))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(184, 207, 229), null), "Ingreso de datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("ID Médico");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Especialidad");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Teléfono");

        jTFIdMedico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFIdMedico.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTFIdMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFIdMedicoMousePressed(evt);
            }
        });

        jTFApellidoMedico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFApellidoMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFApellidoMedicoMousePressed(evt);
            }
        });
        jTFApellidoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFApellidoMedicoActionPerformed(evt);
            }
        });
        jTFApellidoMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFApellidoMedicoKeyTyped(evt);
            }
        });

        jTFNombreMedico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFNombreMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFNombreMedicoMousePressed(evt);
            }
        });
        jTFNombreMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreMedicoActionPerformed(evt);
            }
        });
        jTFNombreMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreMedicoKeyTyped(evt);
            }
        });

        jCBEspecialidades.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCBEspecialidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        jCBEspecialidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBEspecialidadesMousePressed(evt);
            }
        });

        jTFTelefonoMedico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFTelefonoMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFTelefonoMedicoMousePressed(evt);
            }
        });
        jTFTelefonoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTelefonoMedicoActionPerformed(evt);
            }
        });
        jTFTelefonoMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTelefonoMedicoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTFApellidoMedico)
                    .addComponent(jTFNombreMedico, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFTelefonoMedico, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBEspecialidades, javax.swing.GroupLayout.Alignment.LEADING, 0, 120, Short.MAX_VALUE)
                    .addComponent(jTFIdMedico))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFApellidoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTFNombreMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCBEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFTelefonoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTableMedico = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jTableMedico.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTableMedico.setForeground(new java.awt.Color(51, 51, 51));
        jTableMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Médico", "Apellido", "Nombre", "Especialidad", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMedico.setRowHeight(19);
        jTableMedico.getTableHeader().setReorderingAllowed(false);
        jTableMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableMedicoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMedico);
        if (jTableMedico.getColumnModel().getColumnCount() > 0) {
            jTableMedico.getColumnModel().getColumn(0).setResizable(false);
            jTableMedico.getColumnModel().getColumn(0).setHeaderValue("ID Médico");
            jTableMedico.getColumnModel().getColumn(1).setResizable(false);
            jTableMedico.getColumnModel().getColumn(1).setHeaderValue("Apellido");
            jTableMedico.getColumnModel().getColumn(2).setResizable(false);
            jTableMedico.getColumnModel().getColumn(2).setHeaderValue("Nombre");
            jTableMedico.getColumnModel().getColumn(3).setResizable(false);
            jTableMedico.getColumnModel().getColumn(3).setHeaderValue("Especialidad");
            jTableMedico.getColumnModel().getColumn(4).setResizable(false);
            jTableMedico.getColumnModel().getColumn(4).setHeaderValue("Telefono");
        }

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTFFechaActual.setEditable(false);
        jTFFechaActual.setBackground(new java.awt.Color(255, 255, 255));
        jTFFechaActual.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTFFechaActual.setBorder(null);
        jTFFechaActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFFechaActualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTFFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTFFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jBNuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Nuevo.png"))); // NOI18N
        jBNuevo.setText("  Nuevo");
        jBNuevo.setBorder(null);
        jBNuevo.setBorderPainted(false);
        jBNuevo.setContentAreaFilled(false);
        jBNuevo.setFocusPainted(false);
        jBNuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/NuevoPress.png"))); // NOI18N
        jBNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/NuevoRoll.png"))); // NOI18N
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBActualizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Actualizar.png"))); // NOI18N
        jBActualizar.setText(" Actualizar");
        jBActualizar.setBorderPainted(false);
        jBActualizar.setContentAreaFilled(false);
        jBActualizar.setFocusPainted(false);
        jBActualizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/ActualizarPress.png"))); // NOI18N
        jBActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/ActualizarRoll.png"))); // NOI18N
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBBorrar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Eliminar.png"))); // NOI18N
        jBBorrar.setText(" Eliminar");
        jBBorrar.setBorderPainted(false);
        jBBorrar.setContentAreaFilled(false);
        jBBorrar.setFocusPainted(false);
        jBBorrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/EliminarPress.png"))); // NOI18N
        jBBorrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/EliminarRoll.png"))); // NOI18N
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });

        jBRegresar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Regresar.png"))); // NOI18N
        jBRegresar.setText("Regresar");
        jBRegresar.setBorderPainted(false);
        jBRegresar.setContentAreaFilled(false);
        jBRegresar.setFocusPainted(false);
        jBRegresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/RegresarPress.png"))); // NOI18N
        jBRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/RegresarRoll.png"))); // NOI18N
        jBRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarActionPerformed(evt);
            }
        });

        jBGuardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Guardar.png"))); // NOI18N
        jBGuardar.setText(" Guardar");
        jBGuardar.setBorderPainted(false);
        jBGuardar.setContentAreaFilled(false);
        jBGuardar.setFocusPainted(false);
        jBGuardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/GuardarPress.png"))); // NOI18N
        jBGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/GuardarRoll.png"))); // NOI18N
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBActualizar)
                    .addComponent(jBBorrar)
                    .addComponent(jBRegresar)
                    .addComponent(jBGuardar)
                    .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTFBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFBuscar.setForeground(new java.awt.Color(153, 153, 153));
        jTFBuscar.setText("Nombre");
        jTFBuscar.setBorder(null);
        jTFBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFBuscarMousePressed(evt);
            }
        });
        jTFBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBuscarActionPerformed(evt);
            }
        });
        jTFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarKeyTyped(evt);
            }
        });

        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Buscar.png"))); // NOI18N
        jBBuscar.setBorder(null);
        jBBuscar.setBorderPainted(false);
        jBBuscar.setContentAreaFilled(false);
        jBBuscar.setFocusPainted(false);
        jBBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/BuscarPress.png"))); // NOI18N
        jBBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/BuscarRoll.png"))); // NOI18N
        jBBuscar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/BuscarRoll.png"))); // NOI18N
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jBBuscar))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jBBuscar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jTFBuscar)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Buscar médico:");

        jBLimpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Limpiar.png"))); // NOI18N
        jBLimpiar.setText(" Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(jBLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 33, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpiar))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        resetBuscar();
        limpiar();
        Connection conn = Conexion.getConexion();
        desbloquear ();
        try {
            int i;
            String aux="";
            String aux2="";
          //SE EXTRAE NÚMERO MAYOR GENERADO EN IDMEDICO
            String SQL = "SELECT max(idmedico) from medico";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs.next()){              
                aux = rs.getString(1);
            }
          //SI NO EXISTEN IDMEDICOS EN LA BASE DE DATOS, SE SELECCIONA M0001
            if(aux==null){
                jTFIdMedico.setText("M0001");
            }else{
              //SE COMPARA CADA UNO DE LOS DÍGITOS DEL IDMEDICO
                char r1 = aux.charAt(1);
                char r2 = aux.charAt(2);
                char r3 = aux.charAt(3);
                char r4 = aux.charAt(4);
                aux2=""+r1+r2+r3+r4;
                i=Integer.parseInt(aux2);
                GenerarCodigo gen= new GenerarCodigo();
                gen.generar(i);
                jTFIdMedico.setText("M"+gen.serie());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar un nuevo registro", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            cerrar ();
        } catch (SQLException ex) {
            Logger.getLogger(JFMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        resetBuscar();
        String botones[] = {"  Borrar  ", " Cancelar "};
        int op = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar el registro?", "Citas médicas", JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, botones, this);
        if(op == JOptionPane.YES_OPTION){
            medico.setIdmedico(this.jTFIdMedico.getText());
            try {
              //ELIMINA EL REGISTRO EN LA BASE DE DATOS
                tabla.EliminarMedico(medico);
              //SE HACE VISIBLE EN LA INTERFAZ
                MedicoTable();
                limpiar();
                bloquear();
            } catch (SQLException ex) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Error al eliminar registro", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                System.out.println(ex.toString());
        }
        }else if(op == JOptionPane.NO_OPTION){
    }
    }//GEN-LAST:event_jBBorrarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        resetBuscar();
        Pattern patCelular = Pattern.compile("^([0][9]\\d{8})$");//VALIDACIÓN NUMEROS CELULARES
        Pattern patFijo = Pattern.compile("^([^0]\\d{6})$");//VALIDAD NÚMEROS CONVENCIONALES
        Matcher mat = patCelular.matcher(this.jTFTelefonoMedico.getText());
        Matcher mat2 = patFijo.matcher(this.jTFTelefonoMedico.getText());
        String idmedico = this.jTFIdMedico.getText();
        String apellido = this.jTFApellidoMedico.getText();
        String nombre = this.jTFNombreMedico.getText();
        Especialidad espec = new Especialidad(this.jCBEspecialidades.getSelectedItem().toString());
        String telefono = this.jTFTelefonoMedico.getText();
        Medico medicoactualizado = new Medico(idmedico, apellido, nombre, espec, telefono);
        if(this.jTFIdMedico.getText().isEmpty()||this.jTFApellidoMedico.getText().isEmpty()||this.jTFNombreMedico.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }else{
            if(mat.matches()|| mat2.matches()){
                try{
                tabla.ActualizarMedico(medicoactualizado);
                MedicoTable();
                limpiar();
                bloquear();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar médico", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                System.out.println(ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese un número telefónico valido", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
            jTFTelefonoMedico.requestFocus();
        }
        }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        try {
            cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(JFMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBRegresarActionPerformed

    private void jTFApellidoMedicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFApellidoMedicoMousePressed
        resetBuscar();
    }//GEN-LAST:event_jTFApellidoMedicoMousePressed

    private void jTFNombreMedicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFNombreMedicoMousePressed
        resetBuscar();
    }//GEN-LAST:event_jTFNombreMedicoMousePressed

    private void jTFTelefonoMedicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFTelefonoMedicoMousePressed
        resetBuscar();
    }//GEN-LAST:event_jTFTelefonoMedicoMousePressed

    private void jCBEspecialidadesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBEspecialidadesMousePressed
        resetBuscar();
    }//GEN-LAST:event_jCBEspecialidadesMousePressed

    private void jTFBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFBuscarMousePressed
        if(this.jTFBuscar.getText().equals("Nombre")){
            this.jTFBuscar.setText("");
            this.jTFBuscar.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTFBuscarMousePressed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        resetBuscar();
      //VALIDACIÓN DATOS, NÚMEROS TELEFÓNICOS
        Pattern patCelular = Pattern.compile("^([0][9]\\d{8})$");
        Pattern patFijo = Pattern.compile("^([^0]\\d{6})$");
        Matcher mat = patCelular.matcher(this.jTFTelefonoMedico.getText());
        Matcher mat2 = patFijo.matcher(this.jTFTelefonoMedico.getText());
        String idmedico = this.jTFIdMedico.getText();
        String apellido = this.jTFApellidoMedico.getText();
        String nombre = this.jTFNombreMedico.getText();
        Especialidad espec = new Especialidad(this.jCBEspecialidades.getSelectedItem().toString());
        String telefono = this.jTFTelefonoMedico.getText();
        Medico medicoguardar = new Medico(idmedico, apellido, nombre, espec, telefono);
        if(this.jTFIdMedico.getText().isEmpty()||this.jTFApellidoMedico.getText().isEmpty()||this.jTFNombreMedico.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }else{
            if(mat.matches()|| mat2.matches()){
                try{
                    tabla.GuardarMedico(medicoguardar);
                    MedicoTable();
                    limpiar();
                    bloquear();
                }catch(SQLException ex){
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Error al guardar médico\nUse el botón para guardar pacientes nuevos", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                    System.out.print(ex);
                }
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor un número telefónico válido", 
                            "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                    this.jTFTelefonoMedico.requestFocus();
                }
            }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jTFIdMedicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFIdMedicoMousePressed
        resetBuscar();
    }//GEN-LAST:event_jTFIdMedicoMousePressed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiar();
        resetBuscar();
        bloquear ();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jTFApellidoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFApellidoMedicoActionPerformed
        this.jTFNombreMedico.requestFocus();
    }//GEN-LAST:event_jTFApellidoMedicoActionPerformed

    private void jTFNombreMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreMedicoActionPerformed
        this.jCBEspecialidades.requestFocus();
    }//GEN-LAST:event_jTFNombreMedicoActionPerformed

    private void jTFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBuscarActionPerformed
        this.jBBuscar.requestFocus();
    }//GEN-LAST:event_jTFBuscarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        try {
          //PERMITE DESPLEGAR TODA LA INFORMACIÓN DE LA BASE DE DATOS DE LA TABLA MÉDICO
            if(this.jTFBuscar.getText().equals("")||this.jTFBuscar.getText().equals("Nombre")){
                MedicoTable();
            }else{
              //PERMITE DESPLEGAR SOLO LA INFORMACIÓN SOLICITADA DE LA BASE DE DATOS DE LA TABLA MÉDICO
                MedicoBuscar(jTFBuscar.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(JFMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTFFechaActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFFechaActualActionPerformed
      //EXTRAE LA FECHA ACTUAL Y SE ESCRIBE EN JTFFECHAACTUAL
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        jTFFechaActual.setText(dtf.format(LocalDateTime.now()));
    }//GEN-LAST:event_jTFFechaActualActionPerformed

    private void jTableMedicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMedicoMousePressed
        resetBuscar();
        this.jBGuardar.setEnabled(false);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            try (Connection conn = Conexion.getConexion()) {
                //PERMITE DESPLEGAR LAS INFORMACIÓN DEL MYSQL A LOS CAMPOS DE TEXTO
                int Fila = jTableMedico.getSelectedRow();
                String codigo = jTableMedico.getValueAt(Fila, 0).toString();
                ps = conn.prepareStatement("SELECT idmedico, apellido, nombre, especialidad, telefono FROM medico WHERE idmedico=?");
                ps.setString(1, codigo);
                rs = ps.executeQuery();
                while (rs.next()) {
                    jTFIdMedico.setText(rs.getString("IDMedico"));
                    jTFApellidoMedico.setText(rs.getString("Apellido"));
                    jCBEspecialidades.setSelectedItem(rs.getString("especialidad"));
                    jTFNombreMedico.setText(rs.getString("Nombre"));
                    jTFTelefonoMedico.setText(rs.getString("Telefono"));
                }
                desbloquear();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jTableMedicoMousePressed

    private void jTFTelefonoMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoMedicoKeyTyped
        char variable = evt.getKeyChar();
        if(Character.isLetter(variable)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO NÚMEROS","Citas Médicas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTFTelefonoMedicoKeyTyped

    private void jTFTelefonoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTelefonoMedicoActionPerformed
        this.jBGuardar.requestFocus();
    }//GEN-LAST:event_jTFTelefonoMedicoActionPerformed

    private void jTFApellidoMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoMedicoKeyTyped
        char variable = evt.getKeyChar();
        if(Character.isDigit(variable)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS","Citas Médicas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTFApellidoMedicoKeyTyped

    private void jTFNombreMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreMedicoKeyTyped
        char variable = evt.getKeyChar();
        if(Character.isDigit(variable)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS","Citas Médicas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTFNombreMedicoKeyTyped

    private void jTFBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarKeyTyped
        char variable = evt.getKeyChar();
        if(Character.isDigit(variable)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS","Citas Médicas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTFBuscarKeyTyped

    private void limpiar (){
        jTFIdMedico.setText("");
        jTFApellidoMedico.setText("");
        jTFNombreMedico.setText("");
        jCBEspecialidades.setSelectedIndex(0);
        jTFTelefonoMedico.setText("");
        this.jBGuardar.setEnabled(true);
    }
    private void bloquear (){
        jTFIdMedico.setEnabled(false);
        jTFApellidoMedico.setEnabled(false);
        jTFNombreMedico.setEnabled(false);
        jCBEspecialidades.setEnabled(false);
        jTFTelefonoMedico.setEnabled(false);
    }
    private void desbloquear (){
        jTFIdMedico.setEnabled(true);
        jTFIdMedico.setEditable(false);
        jTFApellidoMedico.setEnabled(true);
        jTFNombreMedico.setEnabled(true);
        jCBEspecialidades.setEnabled(true);
        jTFTelefonoMedico.setEnabled(true);
    }
    private void cerrar () throws SQLException{
        this.jBNuevo.requestFocus();
        this.setVisible(false);
        MedicoTable();
        limpiar ();
        bloquear ();
        this.jTFBuscar.setText("Nombre");
        this.jTFBuscar.setForeground(Color.GRAY);
    }
//
    private void MedicoTable() throws SQLException{
        tabla.DesplegarMedico(jTableMedico);
        setSize();
    }
    
    private void MedicoBuscar(String aux) throws SQLException{
        tabla.BuscarMedico(jTableMedico, aux);
        setSize();
    }
    
    private void resetBuscar(){
      //MÉTODO PARA DE VOLVER EL TEXTO PREDETERMINADO EN JTFBUSCAR
        if(this.jTFBuscar.getText().isEmpty()){
            this.jTFBuscar.setText("Nombre");
            this.jTFBuscar.setForeground(Color.GRAY);
        }
    }
//    
    private void setSize(){
        jTableMedico.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTableMedico.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTableMedico.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTableMedico.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableMedico.getColumnModel().getColumn(4).setPreferredWidth(20);        
    }
    
    private void cargarEspecialidades(){
        comboEspecialidades = tabla.ComboBoxEspecialidades();
        for(int i=0 ; i<comboEspecialidades.size() ;i++){
            jCBEspecialidades.addItem(comboEspecialidades.get(i));
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFMedico().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFMedico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JComboBox<String> jCBEspecialidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFApellidoMedico;
    private javax.swing.JTextField jTFBuscar;
    private javax.swing.JTextField jTFFechaActual;
    private javax.swing.JTextField jTFIdMedico;
    private javax.swing.JTextField jTFNombreMedico;
    private javax.swing.JTextField jTFTelefonoMedico;
    private javax.swing.JTable jTableMedico;
    // End of variables declaration//GEN-END:variables

}
