
package Vista;

import Negocio.Conexion;
import Negocio.Paciente;
import Table.TablePaciente;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JFPaciente extends javax.swing.JFrame {
    Paciente paciente;
    TablePaciente tabla = new TablePaciente();
    
    public JFPaciente() throws SQLException {
        initComponents();
        PacienteTable();
        paciente = new Paciente();
        this.setLocationRelativeTo(null);
        this.setTitle("Paciente");
        Icon ic = new ImageIcon(getClass().getResource("/ImagenesLogin/ICONOPRINCIPAL.png"));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.jTFFechaActual.setText(dtf.format(LocalDateTime.now()));
        Toolkit im = Toolkit.getDefaultToolkit();
        setIconImage(im.getImage(getClass().getResource("/ImagenesLogin/ICONOPRINCIPAL.png")));
        jTablePaciente.getTableHeader().setFont(new Font("Dialog", 0 , 12));
        bloquear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFNumeroCedula = new javax.swing.JTextField();
        jTFApellidoPaciente = new javax.swing.JTextField();
        jTFNombrePaciente = new javax.swing.JTextField();
        jTFEdadPaciente = new javax.swing.JTextField();
        jTFTelefonoPaciente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFSintomas = new javax.swing.JTextField();
        jBNuevo = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBBorra = new javax.swing.JButton();
        jBRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLimpiar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTFBuscar = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTFFechaActual = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(184, 207, 229), null), "Ingreso de datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("No. de Cédula");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Edad");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Teléfono");

        jTFNumeroCedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFNumeroCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFNumeroCedulaMousePressed(evt);
            }
        });
        jTFNumeroCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNumeroCedulaActionPerformed(evt);
            }
        });
        jTFNumeroCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNumeroCedulaKeyTyped(evt);
            }
        });

        jTFApellidoPaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFApellidoPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFApellidoPacienteMousePressed(evt);
            }
        });
        jTFApellidoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFApellidoPacienteActionPerformed(evt);
            }
        });
        jTFApellidoPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFApellidoPacienteKeyTyped(evt);
            }
        });

        jTFNombrePaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFNombrePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFNombrePacienteMousePressed(evt);
            }
        });
        jTFNombrePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombrePacienteActionPerformed(evt);
            }
        });
        jTFNombrePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombrePacienteKeyTyped(evt);
            }
        });

        jTFEdadPaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFEdadPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFEdadPacienteMousePressed(evt);
            }
        });
        jTFEdadPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEdadPacienteActionPerformed(evt);
            }
        });
        jTFEdadPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFEdadPacienteKeyTyped(evt);
            }
        });

        jTFTelefonoPaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFTelefonoPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFTelefonoPacienteMousePressed(evt);
            }
        });
        jTFTelefonoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTelefonoPacienteActionPerformed(evt);
            }
        });
        jTFTelefonoPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTelefonoPacienteKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Síntomas");

        jTFSintomas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFSintomas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFSintomasMousePressed(evt);
            }
        });
        jTFSintomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFSintomasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFTelefonoPaciente)
                    .addComponent(jTFSintomas)
                    .addComponent(jTFNumeroCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jTFApellidoPaciente)
                    .addComponent(jTFNombrePaciente)
                    .addComponent(jTFEdadPaciente))
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFNumeroCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFEdadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jBNuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Nuevo.png"))); // NOI18N
        jBNuevo.setText(" Nuevo");
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

        jBBorra.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBBorra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Eliminar.png"))); // NOI18N
        jBBorra.setText(" Eliminar");
        jBBorra.setBorderPainted(false);
        jBBorra.setContentAreaFilled(false);
        jBBorra.setFocusPainted(false);
        jBBorra.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/EliminarPress.png"))); // NOI18N
        jBBorra.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/EliminarRoll.png"))); // NOI18N
        jBBorra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorraActionPerformed(evt);
            }
        });

        jBRegresar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Regresar.png"))); // NOI18N
        jBRegresar.setText(" Regresar");
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

        jTablePaciente = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jTablePaciente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTablePaciente.setForeground(new java.awt.Color(51, 51, 51));
        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Apellido", "Nombre", "Edad", "Telefono", "Síntomas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePaciente.setRowHeight(19);
        jTablePaciente.getTableHeader().setReorderingAllowed(false);
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePacienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePaciente);
        if (jTablePaciente.getColumnModel().getColumnCount() > 0) {
            jTablePaciente.getColumnModel().getColumn(0).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(1).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(2).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(3).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(4).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Buscar paciente:");

        jLimpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Limpiar.png"))); // NOI18N
        jLimpiar.setText(" Limpiar");
        jLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimpiarActionPerformed(evt);
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

        jPanel2.setBackground(new java.awt.Color(99, 199, 197));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Paciente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(268, 268, 268))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTFBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFBuscar.setForeground(new java.awt.Color(153, 153, 153));
        jTFBuscar.setText("Cédula");
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

        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Buscar.png"))); // NOI18N
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
                .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTFFechaActual.setEditable(false);
        jTFFechaActual.setBackground(new java.awt.Color(255, 255, 255));
        jTFFechaActual.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTFFechaActual.setBorder(null);
        jTFFechaActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFFechaActualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTFFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTFFechaActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBGuardar)
                            .addComponent(jBNuevo)
                            .addComponent(jBActualizar)
                            .addComponent(jBBorra)
                            .addComponent(jBRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jBNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBBorra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLimpiar))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        try {
            cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(JFPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBRegresarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(JFPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTFNumeroCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNumeroCedulaActionPerformed
      Pattern pat = Pattern.compile("^([0-1][0-9]|2[0-4])([0-5])(\\d{7})$");
        Matcher mat = pat.matcher(this.jTFNumeroCedula.getText());
        if(mat.matches()){
            this.jTFApellidoPaciente.requestFocus();
        }else{
           JOptionPane.showMessageDialog(null, "Por favor un número de cédula válido", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_jTFNumeroCedulaActionPerformed

    private void jTFApellidoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFApellidoPacienteActionPerformed
        this.jTFNombrePaciente.requestFocus();
    }//GEN-LAST:event_jTFApellidoPacienteActionPerformed

    private void jTFNombrePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombrePacienteActionPerformed
        this.jTFEdadPaciente.requestFocus();
    }//GEN-LAST:event_jTFNombrePacienteActionPerformed

    private void jTFEdadPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEdadPacienteActionPerformed
        Pattern pat = Pattern.compile("^[0-9]||[1-9][0-9]||1[0-5][0-9]$");
        Matcher mat = pat.matcher(this.jTFEdadPaciente.getText());
        if(mat.matches()){
            this.jTFTelefonoPaciente.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese una edad válida", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_jTFEdadPacienteActionPerformed

    private void jTFTelefonoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTelefonoPacienteActionPerformed
        Pattern patCelular = Pattern.compile("^([0][9]\\d{8})$");
        Pattern patFijo = Pattern.compile("^([^0]\\d{6})$");
        Matcher mat = patCelular.matcher(this.jTFTelefonoPaciente.getText());
        Matcher mat2 = patFijo.matcher(this.jTFTelefonoPaciente.getText());
        if(mat.matches()|| mat2.matches()){
            this.jTFSintomas.requestFocus();   
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese un número telefónico válido", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        } 
    }//GEN-LAST:event_jTFTelefonoPacienteActionPerformed

    private void jTFSintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFSintomasActionPerformed
        this.jBGuardar.requestFocus();
    }//GEN-LAST:event_jTFSintomasActionPerformed

    private void jTFEdadPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFEdadPacienteKeyTyped
        char variable = evt.getKeyChar();
        if(Character.isLetter(variable)||Character.isSpaceChar(variable)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO NÚMEROS","Citas Médicas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTFEdadPacienteKeyTyped

    private void jTFTelefonoPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoPacienteKeyTyped
        char variable = evt.getKeyChar();
        if(Character.isLetter(variable)||Character.isSpaceChar(variable)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO NÚMEROS","Citas Médicas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTFTelefonoPacienteKeyTyped

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        limpiar();
        desbloquear();
        resetBuscar();
        this.jTFNumeroCedula.requestFocus(); 
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        resetBuscar();
        Pattern patTelfCelular = Pattern.compile("^([0][9]\\d{8})$");
        Pattern patTelfFijo = Pattern.compile("^([^0]\\d{6})$");
        Pattern patcedula = Pattern.compile("^([0-1][0-9]|2[0-4])([0-5])(\\d{7})$");
        Pattern patEdad = Pattern.compile("^[0-9]||[1-9][0-9]||1[0-5][0-9]$");
        Matcher matEdad = patEdad.matcher(this.jTFEdadPaciente.getText());
        Matcher matCedula = patcedula.matcher(this.jTFNumeroCedula.getText());
        Matcher matTelfCelular = patTelfCelular.matcher(this.jTFTelefonoPaciente.getText());
        Matcher matTelfFijo = patTelfFijo.matcher(this.jTFTelefonoPaciente.getText());
        if(this.jTFNumeroCedula.getText().isEmpty()||this.jTFApellidoPaciente.getText().isEmpty()||this.jTFNombrePaciente.getText().isEmpty()
                ||this.jTFEdadPaciente.getText().isEmpty()||this.jTFSintomas.getText().isEmpty()||this.jTFTelefonoPaciente.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }else{
            if(matTelfCelular.matches()|| matTelfFijo.matches()){
                if(matCedula.matches()){
                    if(matEdad.matches()){
                    try{
                        int cedula = Integer.parseInt(this.jTFNumeroCedula.getText());
                        String apellido = this.jTFApellidoPaciente.getText();
                        String nombre = this.jTFNombrePaciente.getText();
                        int edad = Integer.parseInt(this.jTFEdadPaciente.getText());
                        String telefono = this.jTFTelefonoPaciente.getText();
                        String diagnostico = this.jTFSintomas.getText();
                        Paciente pacienteactualizar = new Paciente(cedula, apellido, nombre, edad, telefono, diagnostico);
                        tabla.ActualizarPaciente(pacienteactualizar);
                        PacienteTable();
                        limpiar ();
                        bloquear();
                    }catch (SQLException ex){
                            JOptionPane.showMessageDialog(null, "Error al actualizar los datos del paciente", "Citas Médicas", JOptionPane.ERROR_MESSAGE);       
                            System.out.println(ex);
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Ingrese número telefónico o de cédula válido", "Citas Médicas", JOptionPane.ERROR_MESSAGE);
                        System.out.print(e);
                }
                     }else{
                        JOptionPane.showMessageDialog(null, "Ingrese una edad válida", "Citas Médicas", JOptionPane.ERROR_MESSAGE);
                        this.jTFEdadPaciente.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese una cédula válida", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                    this.jTFNumeroCedula.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un número telefónico válido", "Citas Médicas", JOptionPane.ERROR_MESSAGE);
                this.jTFTelefonoPaciente.requestFocus();
            }
    }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBBorraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorraActionPerformed
        resetBuscar();
        String botones[] = {"  Borrar  ", " Cancelar "};
        int op = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar el registro?", "Sistema de citas médicas", 0, 0, null, botones, this);
        if(op == JOptionPane.YES_OPTION){
            paciente.setCedula(Integer.parseInt(this.jTFNumeroCedula.getText()));
            try{
                tabla.EliminarPaciente(paciente);
                PacienteTable();
                limpiar();
                bloquear();
            } catch (SQLException ex) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Error al eliminar registro", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                System.out.println(ex.toString());
            }catch (ArrayIndexOutOfBoundsException e){
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Error al eliminar registro", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                System.out.println(e.toString());
            }
        }else if(op == JOptionPane.NO_OPTION){
            
        }
    }//GEN-LAST:event_jBBorraActionPerformed

    private void jTFBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFBuscarMousePressed
        if(this.jTFBuscar.getText().equals("Cédula")){
            this.jTFBuscar.setText("");
            this.jTFBuscar.setForeground(Color.BLACK);
       }
    }//GEN-LAST:event_jTFBuscarMousePressed

    private void jTFNumeroCedulaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFNumeroCedulaMousePressed
        resetBuscar();
    }//GEN-LAST:event_jTFNumeroCedulaMousePressed

    private void jTFApellidoPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFApellidoPacienteMousePressed
        resetBuscar();
    }//GEN-LAST:event_jTFApellidoPacienteMousePressed

    private void jTFNombrePacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFNombrePacienteMousePressed
        resetBuscar();
    }//GEN-LAST:event_jTFNombrePacienteMousePressed

    private void jTFEdadPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFEdadPacienteMousePressed
        resetBuscar();
    }//GEN-LAST:event_jTFEdadPacienteMousePressed

    private void jTFTelefonoPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFTelefonoPacienteMousePressed
        resetBuscar();
    }//GEN-LAST:event_jTFTelefonoPacienteMousePressed

    private void jTFSintomasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFSintomasMousePressed
        resetBuscar();
    }//GEN-LAST:event_jTFSintomasMousePressed

    private void jTFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBuscarActionPerformed
        this.jBBuscar.requestFocus();
    }//GEN-LAST:event_jTFBuscarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        resetBuscar();
        Pattern patTelfCelular = Pattern.compile("^([0][9]\\d{8})$");
        Pattern patTelfFijo = Pattern.compile("^([^0]\\d{6})$");
        Pattern patcedula = Pattern.compile("^([0-1][0-9]|2[0-4])([0-5])(\\d{7})$");
        Pattern patEdad = Pattern.compile("^[0-9]||[1-9][0-9]||1[0-5][0-9]$");
        Matcher matEdad = patEdad.matcher(this.jTFEdadPaciente.getText());
        Matcher matCedula = patcedula.matcher(this.jTFNumeroCedula.getText());
        Matcher matTelfCelular = patTelfCelular.matcher(this.jTFTelefonoPaciente.getText());
        Matcher matTelfFijo = patTelfFijo.matcher(this.jTFTelefonoPaciente.getText());
        if(this.jTFNumeroCedula.getText().isEmpty()||this.jTFApellidoPaciente.getText().isEmpty()||this.jTFNombrePaciente.getText().isEmpty()
                ||this.jTFEdadPaciente.getText().isEmpty()||this.jTFSintomas.getText().isEmpty()||this.jTFTelefonoPaciente.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }else{
            if(matTelfCelular.matches()|| matTelfFijo.matches()){
                if(matCedula.matches()){
                    if(matEdad.matches()){
                    try{
                        int cedula = Integer.parseInt(this.jTFNumeroCedula.getText());
                        String apellido = this.jTFApellidoPaciente.getText();
                        String nombre = this.jTFNombrePaciente.getText();
                        int edad = Integer.parseInt(this.jTFEdadPaciente.getText());
                        String telefono = this.jTFTelefonoPaciente.getText();
                        String diagnostico = this.jTFSintomas.getText();
                        Paciente pacienteguardar = new Paciente(cedula, apellido, nombre, edad, telefono, diagnostico);
                        tabla.GuardarPaciente(pacienteguardar);
                        PacienteTable();
                        limpiar ();
                        bloquear();
                    }catch (SQLException ex){
                            JOptionPane.showMessageDialog(null, "Error al guardar paciente\nUse el botón para guardar pacientes nuevos", 
                                    "Citas Médicas", JOptionPane.ERROR_MESSAGE);       
                            System.out.println(ex);
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Ingrese número telefónico o de cédula válido", "Citas Médicas", JOptionPane.ERROR_MESSAGE);
                        System.out.print(e);
                }
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingrese una edad válida", "Citas Médicas", JOptionPane.ERROR_MESSAGE);
                        this.jTFEdadPaciente.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese una cédula válida", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                    this.jTFNumeroCedula.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un número telefónico válido", "Citas Médicas", JOptionPane.ERROR_MESSAGE);
                this.jTFTelefonoPaciente.requestFocus();
            }
    }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        if(this.jTFBuscar.getText().equals("")||this.jTFBuscar.getText().equals("Cédula")){
            try {
                PacienteTable();
            } catch (SQLException ex) {
                Logger.getLogger(JFPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                PacienteBuscar(this.jTFBuscar.getText());
            } catch (SQLException ex) {
                Logger.getLogger(JFPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLimpiarActionPerformed
        limpiar();
        bloquear ();
        resetBuscar();
    }//GEN-LAST:event_jLimpiarActionPerformed

    private void jTablePacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMousePressed
        resetBuscar();
        this.jTFNumeroCedula.setEditable(false);
        this.jBGuardar.setEnabled(false);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = Conexion.getConexion();
            int Fila = jTablePaciente.getSelectedRow();
            String codigo = jTablePaciente.getValueAt(Fila, 0).toString();
            ps = conn.prepareStatement("SELECT numcedulap, apellido, nombre, edad, telefono, Sintomas FROM paciente WHERE numcedulap=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                this.jTFNumeroCedula.setText(rs.getString("numcedulap"));
                this.jTFApellidoPaciente.setText(rs.getString("Apellido"));
                this.jTFNombrePaciente.setText(rs.getString("Nombre"));
                this.jTFEdadPaciente.setText(rs.getString("Edad"));
                this.jTFTelefonoPaciente.setText(rs.getString("Telefono"));
                this.jTFSintomas.setText(rs.getString("Sintomas"));
            }
            desbloquear();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jTablePacienteMousePressed

    private void jTFNumeroCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNumeroCedulaKeyTyped
        char variable = evt.getKeyChar();
        if(Character.isLetter(variable)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO NÚMEROS","Citas Médicas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTFNumeroCedulaKeyTyped

    private void jTFApellidoPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoPacienteKeyTyped
        char variable = evt.getKeyChar();
        if(Character.isDigit(variable)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS","Citas Médicas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTFApellidoPacienteKeyTyped

    private void jTFFechaActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFFechaActualActionPerformed

    }//GEN-LAST:event_jTFFechaActualActionPerformed

    private void jTFNombrePacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombrePacienteKeyTyped
        char variable = evt.getKeyChar();
        if(Character.isDigit(variable)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS","Citas Médicas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTFNombrePacienteKeyTyped
      
    private void limpiar(){
        this.jTFNumeroCedula.setText("");
        this.jTFApellidoPaciente.setText("");
        this.jTFNombrePaciente.setText("");
        this.jTFEdadPaciente.setText("");
        this.jTFTelefonoPaciente.setText("");
        this.jTFSintomas.setText("");
        this.jTFNumeroCedula.requestFocus();
        this.jBGuardar.setEnabled(true);
        this.jTFNumeroCedula.setEditable(true);
    }
    private void bloquear (){
        this.jTFNumeroCedula.setEnabled(false);
        this.jTFApellidoPaciente.setEnabled(false);
        this.jTFNombrePaciente.setEnabled(false);
        this.jTFEdadPaciente.setEnabled(false);
        this.jTFTelefonoPaciente.setEnabled(false);
        this.jTFSintomas.setEnabled(false);
    }
    private void desbloquear (){
        this.jTFNumeroCedula.setEnabled(true);
        this.jTFApellidoPaciente.setEnabled(true);
        this.jTFNombrePaciente.setEnabled(true);
        this.jTFEdadPaciente.setEnabled(true);
        this.jTFTelefonoPaciente.setEnabled(true);
        this.jTFSintomas.setEnabled(true);
    }
    private void cerrar() throws SQLException{
        this.jBNuevo.requestFocus();
        limpiar();
        bloquear();
        PacienteTable();
        this.setVisible(false);
        this.jTFBuscar.setText("Cédula");
        this.jTFBuscar.setForeground(Color.GRAY);
    }
    private void PacienteTable() throws SQLException{
        tabla.DesplegarPaciente(jTablePaciente);
        setSize();
    }
    
    private void PacienteBuscar(String aux) throws SQLException{
        tabla.BuscarPaciente(jTablePaciente, aux);
        setSize();
    }
    
    private void resetBuscar(){
        if(this.jTFBuscar.getText().isEmpty()){
            this.jTFBuscar.setText("Cédula");
            this.jTFBuscar.setForeground(Color.GRAY);
        }
    }
    
    private void setSize(){
        jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(32);
        jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(32);
        jTablePaciente.getColumnModel().getColumn(3).setPreferredWidth(5);
        jTablePaciente.getColumnModel().getColumn(4).setPreferredWidth(26);  
        jTablePaciente.getColumnModel().getColumn(5).setPreferredWidth(120);  
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
            java.util.logging.Logger.getLogger(JFPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFPaciente().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFPaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBorra;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFApellidoPaciente;
    private javax.swing.JTextField jTFBuscar;
    private javax.swing.JTextField jTFEdadPaciente;
    private javax.swing.JTextField jTFFechaActual;
    private javax.swing.JTextField jTFNombrePaciente;
    private javax.swing.JTextField jTFNumeroCedula;
    private javax.swing.JTextField jTFSintomas;
    private javax.swing.JTextField jTFTelefonoPaciente;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
