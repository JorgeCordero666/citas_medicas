
package Vista;

import Negocio.Circulo;
import Negocio.CitaMedica;
import Negocio.Conexion;
import Negocio.Especialidad;
import Negocio.GenerarCodigo;
import Negocio.Horario;
import Table.TableCitaMedica;
import Table.TableMedico;
import Table.TablePaciente;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class JFCitaMedica extends javax.swing.JFrame {
    CitaMedica citamedica;
    TableMedico tablaMedico = new TableMedico();
    TablePaciente tablaPaciente = new TablePaciente();
    TableCitaMedica tablaCitas = new TableCitaMedica();
    ArrayList<String> comboHorario;
    JFBuscarIDMedico jfbuscaridmedico;
    JFBuscarPaciente jfbuscarpaciente;
    
    public JFCitaMedica() throws SQLException {
        initComponents();
        CitasTable();
        PacienteTable();
        MedicoTable();
        jfbuscaridmedico = new JFBuscarIDMedico();
        jfbuscarpaciente = new JFBuscarPaciente();
        citamedica = new CitaMedica();
        this.setLocationRelativeTo(null);
        this.setTitle("Cita Médica");
        this.jBNuevo.requestFocus();
        this.jTFaux.setVisible(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Toolkit im = Toolkit.getDefaultToolkit();
        setIconImage(im.getImage(getClass().getResource("/ImagenesLogin/ICONOPRINCIPAL.png")));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        jTFFechaActual.setText(dtf.format(LocalDateTime.now()));
        jTableCita.getTableHeader().setFont(new Font("Dialog", 0 , 12));
        bloquear();
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jBLimpiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFIdCita = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFConsultorio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCBHorarioCitas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTFFechaCita = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTFEspecialidad = new javax.swing.JTextField();
        jTFCedulaPaciente = new javax.swing.JTextField();
        jTFIDMedico = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCBEstadoCita = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanelReserva = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCita = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFBuscar = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTFFechaActual = new javax.swing.JTextField();
        jTFaux = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablaMedicos = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTFBuscarMedico = new javax.swing.JTextField();
        jBBuscarMedico = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablaPaciente = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTFBuscarPaciente = new javax.swing.JTextField();
        jBBuscarPaciente = new javax.swing.JButton();
        jBNuevo = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBRegresar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("Buscar cita:");

        jBLimpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Limpiar.png"))); // NOI18N
        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(184, 207, 229), null), "Ingreso de datos\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("ID Cita");

        jTFIdCita.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFIdCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFIdCitaMousePressed(evt);
            }
        });
        jTFIdCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdCitaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Consultorio");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Fecha Cita");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Horario");

        jTFConsultorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFConsultorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFConsultorioMousePressed(evt);
            }
        });
        jTFConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFConsultorioActionPerformed(evt);
            }
        });
        jTFConsultorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFConsultorioKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Cédula Paciente");

        jCBHorarioCitas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCBHorarioCitas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        jCBHorarioCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCBHorarioCitasMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBHorarioCitasMousePressed(evt);
            }
        });
        jCBHorarioCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBHorarioCitasActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("ID Médico");

        jTFFechaCita.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFFechaCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFFechaCitaMousePressed(evt);
            }
        });
        jTFFechaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFFechaCitaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setText("Especialidad");

        jTFEspecialidad.setEditable(false);
        jTFEspecialidad.setBackground(new java.awt.Color(255, 255, 255));
        jTFEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTFCedulaPaciente.setEditable(false);
        jTFCedulaPaciente.setBackground(new java.awt.Color(255, 255, 255));
        jTFCedulaPaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTFIDMedico.setEditable(false);
        jTFIDMedico.setBackground(new java.awt.Color(255, 255, 255));
        jTFIDMedico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Estado");

        jCBEstadoCita.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCBEstadoCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Reservado" }));
        jCBEstadoCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBEstadoCitaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jTFIdCita, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTFCedulaPaciente))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTFIDMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)))
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFEspecialidad)
                            .addComponent(jTFFechaCita)
                            .addComponent(jCBHorarioCitas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jCBEstadoCita, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTFEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTFFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jCBHorarioCitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTFIdCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTFConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTFCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jCBEstadoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTFIDMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel9.setText("Estado");

        jPanelReserva.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelReservaLayout = new javax.swing.GroupLayout(jPanelReserva);
        jPanelReserva.setLayout(jPanelReservaLayout);
        jPanelReservaLayout.setHorizontalGroup(
            jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanelReservaLayout.setVerticalGroup(
            jPanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jTableCita = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jTableCita.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTableCita.setForeground(new java.awt.Color(51, 51, 51));
        jTableCita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cita", "Consultorio", "Cédula Paciente", "ID Médico", "Fecha Cita", "Hora", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCita.setRowHeight(19);
        jTableCita.getTableHeader().setReorderingAllowed(false);
        jTableCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCitaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableCitaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCita);
        if (jTableCita.getColumnModel().getColumnCount() > 0) {
            jTableCita.getColumnModel().getColumn(0).setResizable(false);
            jTableCita.getColumnModel().getColumn(1).setResizable(false);
            jTableCita.getColumnModel().getColumn(2).setResizable(false);
            jTableCita.getColumnModel().getColumn(3).setResizable(false);
            jTableCita.getColumnModel().getColumn(4).setResizable(false);
            jTableCita.getColumnModel().getColumn(5).setResizable(false);
            jTableCita.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel3.setBackground(new java.awt.Color(99, 199, 197));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cita Médica");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(337, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(342, 342, 342))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTFBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFBuscar.setForeground(new java.awt.Color(153, 153, 153));
        jTFBuscar.setText("Cédula paciente");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTFBuscar)
            .addComponent(jBBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTFFechaActual.setEditable(false);
        jTFFechaActual.setBackground(new java.awt.Color(255, 255, 255));
        jTFFechaActual.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTFFechaActual.setBorder(null);

        jTFaux.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(430, Short.MAX_VALUE)
                .addComponent(jTFaux, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253)
                .addComponent(jTFFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTFFechaActual, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addComponent(jTFaux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selección de médico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTablaMedicos = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jTablaMedicos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTablaMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablaMedicos.getTableHeader().setReorderingAllowed(false);
        jTablaMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablaMedicosMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTablaMedicos);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel12.setText("Buscar");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTFBuscarMedico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFBuscarMedico.setForeground(new java.awt.Color(153, 153, 153));
        jTFBuscarMedico.setText("Especialidad");
        jTFBuscarMedico.setBorder(null);
        jTFBuscarMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFBuscarMedicoMousePressed(evt);
            }
        });
        jTFBuscarMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarMedicoKeyTyped(evt);
            }
        });

        jBBuscarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Buscar.png"))); // NOI18N
        jBBuscarMedico.setBorderPainted(false);
        jBBuscarMedico.setContentAreaFilled(false);
        jBBuscarMedico.setFocusPainted(false);
        jBBuscarMedico.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/BuscarPress.png"))); // NOI18N
        jBBuscarMedico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/BuscarRoll.png"))); // NOI18N
        jBBuscarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jTFBuscarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBBuscarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTFBuscarMedico, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jBBuscarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 141, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selección de paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTablaPaciente = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jTablaPaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTablaPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablaPaciente.getTableHeader().setReorderingAllowed(false);
        jTablaPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablaPacienteMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(jTablaPaciente);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel13.setText("Buscar");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jTFBuscarPaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFBuscarPaciente.setForeground(new java.awt.Color(153, 153, 153));
        jTFBuscarPaciente.setText("Cédula");
        jTFBuscarPaciente.setBorder(null);
        jTFBuscarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFBuscarPacienteMousePressed(evt);
            }
        });
        jTFBuscarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarPacienteKeyTyped(evt);
            }
        });

        jBBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Buscar.png"))); // NOI18N
        jBBuscarPaciente.setBorderPainted(false);
        jBBuscarPaciente.setContentAreaFilled(false);
        jBBuscarPaciente.setFocusPainted(false);
        jBBuscarPaciente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/BuscarPress.png"))); // NOI18N
        jBBuscarPaciente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/BuscarRoll.png"))); // NOI18N
        jBBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTFBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jBBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTFBuscarPaciente)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jBBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 151, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jBNuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Nuevo.png"))); // NOI18N
        jBNuevo.setText("  Nuevo");
        jBNuevo.setBorder(null);
        jBNuevo.setContentAreaFilled(false);
        jBNuevo.setFocusPainted(false);
        jBNuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/NuevoPress.png"))); // NOI18N
        jBNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/NuevoRoll.png"))); // NOI18N
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBGuardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Guardar.png"))); // NOI18N
        jBGuardar.setText(" Guardar");
        jBGuardar.setBorder(null);
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

        jBBorrar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Eliminar.png"))); // NOI18N
        jBBorrar.setText(" Eliminar");
        jBBorrar.setBorder(null);
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

        jBActualizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Actualizar.png"))); // NOI18N
        jBActualizar.setText(" Actualizar");
        jBActualizar.setBorder(null);
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

        jBRegresar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Regresar.png"))); // NOI18N
        jBRegresar.setText("Regresar");
        jBRegresar.setBorder(null);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73)
                                        .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(108, 108, 108)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBActualizar)
                                    .addComponent(jBGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBorrar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(12, 12, 12))
                            .addComponent(jPanelReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBLimpiar))))))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(JFCitaMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTFIdCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdCitaActionPerformed
        this.jTFConsultorio.requestFocus();
    }//GEN-LAST:event_jTFIdCitaActionPerformed

    private void jTFConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFConsultorioActionPerformed
        Pattern pat = Pattern.compile("^[1-9]||[1-9][0-9]||[1-9][0-9][0-9]$");
        Matcher mat = pat.matcher(this.jTFConsultorio.getText());
        if(mat.matches()){
            this.jCBEstadoCita.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese una número de consultorio válido", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_jTFConsultorioActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        if(jTFIDMedico.getText().isEmpty()||this.jTFCedulaPaciente.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione un Médico y un Paciente", "Citas Medicas",JOptionPane.ERROR_MESSAGE);
           }
        else{
        
        resetFecha();
        resetBuscar();
        resetMedico();
        resetPaciente();
        Connection conn = Conexion.getConexion();
        desbloquear ();
        jTFIdCita.setText("");
        jTFConsultorio.setText("");
        jTFFechaCita.setText("");
        jCBHorarioCitas.setSelectedIndex(0);
        jCBEstadoCita.setSelectedIndex(0);
        jPanelReserva.repaint();
        this.jBGuardar.setEnabled(true);
        this.jTFFechaCita.setText("AAAA-MM-DD");
        this.jTFFechaCita.setForeground(Color.GRAY);
        try {
            int i;
            String aux="";
            String aux2="";
            String SQL = "Select max(IDCita) from citamedica";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs.next()){              
                aux = rs.getString(1);
            }
            if(aux==null){
                jTFIdCita.setText("CM0001");
            }else{
                char r1 = aux.charAt(2);
                char r2 = aux.charAt(3);
                char r3 = aux.charAt(4);
                char r4 = aux.charAt(5);
                aux2 = "" +r1+r2+r3+r4;
                i=Integer.parseInt(aux2);
                GenerarCodigo gen= new GenerarCodigo();
                gen.generar(i);
                jTFIdCita.setText("CM"+gen.serie());
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar un nuevo registro", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }
        }
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        resetBuscar();
        resetFecha();
        this.jTFBuscarPaciente.setText("Cédula");
        this.jTFBuscarPaciente.setForeground(Color.GRAY);
        this.jTFBuscarMedico.setText("Especialidad");
        this.jTFBuscarMedico.setForeground(Color.GRAY);
        PreparedStatement ps = null;
        Pattern patConsultorio = Pattern.compile("^[1-9]||[1-9][0-9]||[1-9][0-9][0-9]$");  //Valida el número del consultorio
        Matcher matConsultorio = patConsultorio.matcher(this.jTFConsultorio.getText());
        if(this.jTFConsultorio.getText().isEmpty()||this.jTFFechaCita.getText().isEmpty()||this.jTFFechaCita.getText().equals("AAAA-MM-DD")
                ||this.jTFCedulaPaciente.getText().isEmpty()||
                jCBHorarioCitas.getSelectedItem().toString().equals("Seleccionar")){
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }else{
            fecha();
            if(matConsultorio.matches()){
            try{
                ActualizarDisponibilidad2();
                String idcita = this.jTFIdCita.getText();
                int consultorio = Integer.parseInt(this.jTFConsultorio.getText());
                int cedula = Integer.parseInt(this.jTFCedulaPaciente.getText());
                Especialidad esp = new Especialidad(this.jTFEspecialidad.getText());
                String fechac = this.jTFFechaCita.getText();
                String idmedico = this.jTFIDMedico.getText();
                Horario horario = new Horario(this.jCBHorarioCitas.getSelectedItem().toString(), fechac);
                String estado = this.jCBEstadoCita.getSelectedItem().toString();
                CitaMedica citaactualizar = new CitaMedica(idcita, consultorio, cedula, idmedico, esp, horario, estado);
                tablaCitas.ActualizarCita(citaactualizar);
                CitasTable();
                bloquear();
                limpiar ();
             }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al actualizar la Cita Médica", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                System.out.println(ex);
            }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un número de consultorio válido", "Citas Médicas", JOptionPane.ERROR_MESSAGE);
                this.jTFConsultorio.getText();
            }
    }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        resetBuscar();
        resetFecha();
        this.jTFBuscarPaciente.setText("Cédula");
        this.jTFBuscarPaciente.setForeground(Color.GRAY);
        this.jTFBuscarMedico.setText("Especialidad");
        this.jTFBuscarMedico.setForeground(Color.GRAY);
        String botones[] = {"  Borrar  ", " Cancelar "};
        int op = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar el registro?", "Sistema de citas médicas", 0, 0, null, botones, this);
        if(op == JOptionPane.YES_OPTION){
            citamedica.setIdcita(this.jTFIdCita.getText());
            try{
                ActualizarDisponibilidadBORRAR();
                tablaCitas.EliminarCita(citamedica);
                CitasTable();
                limpiar ();
                bloquear ();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al eliminar la cita médica", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                 System.out.println(ex.toString());
            }
        }else if (op == JOptionPane.NO_OPTION){
            
        }
    }//GEN-LAST:event_jBBorrarActionPerformed

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        try {
            cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(JFCitaMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBRegresarActionPerformed

    private void jTFIdCitaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFIdCitaMousePressed
        resetFecha();
        resetBuscar();
        resetMedico();
        resetPaciente();
    }//GEN-LAST:event_jTFIdCitaMousePressed

    private void jTFConsultorioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFConsultorioMousePressed
        resetFecha();
        resetBuscar();
        resetMedico();
        resetPaciente();
    }//GEN-LAST:event_jTFConsultorioMousePressed

    private void jTFFechaCitaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFFechaCitaMousePressed
        if(this.jTFFechaCita.getText().equals("AAAA-MM-DD")){
            this.jTFFechaCita.setText("");
            this.jTFFechaCita.setForeground(Color.BLACK);
        }
        resetBuscar();
        resetMedico();
        resetPaciente();
        cargarHorarios();
    }//GEN-LAST:event_jTFFechaCitaMousePressed

    private void jCBEstadoCitaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBEstadoCitaMousePressed
        resetFecha();
        resetBuscar();
        resetMedico();
        resetPaciente();
    }//GEN-LAST:event_jCBEstadoCitaMousePressed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        resetBuscar();
        resetFecha();
        this.jTFBuscarPaciente.setText("Cédula");
        this.jTFBuscarPaciente.setForeground(Color.GRAY);
        this.jTFBuscarMedico.setText("Especialidad");
        this.jTFBuscarMedico.setForeground(Color.GRAY);
        PreparedStatement ps = null;
        Pattern patConsultorio = Pattern.compile("^[1-9]||[1-9][0-9]||[1-9][0-9][0-9]$");  //Valida el número del consultorio
        Matcher matConsultorio = patConsultorio.matcher(this.jTFConsultorio.getText());
        if(this.jTFConsultorio.getText().isEmpty()||this.jTFFechaCita.getText().isEmpty()||this.jTFFechaCita.getText().equals("AAAA-MM-DD")
                ||this.jTFCedulaPaciente.getText().isEmpty()||
                jCBHorarioCitas.getSelectedItem().toString().equals("Seleccionar")){
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
        }else{
            fecha();
            if(matConsultorio.matches()){
                try{
                    ActualizarDisponibilidad();
                    String idcita = this.jTFIdCita.getText();
                    int consultorio = Integer.parseInt(this.jTFConsultorio.getText());
                    int cedula = Integer.parseInt(this.jTFCedulaPaciente.getText());
                    Especialidad esp = new Especialidad(this.jTFEspecialidad.getText());
                    String fechac = this.jTFFechaCita.getText();
                    String idmedico = this.jTFIDMedico.getText();
                    Horario horario = new Horario(this.jCBHorarioCitas.getSelectedItem().toString(), fechac);
                    String estado = this.jCBEstadoCita.getSelectedItem().toString();
                    CitaMedica citaguardar = new CitaMedica(idcita, consultorio, cedula, idmedico, esp, horario, estado);
                    tablaCitas.GuardarCita(citaguardar);
                    CitasTable();
                    bloquear();
                    limpiar ();
                 }catch(SQLException ex){
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Error al guardar cita médica\nUse el botón para guardar nuevas citas", 
                            "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                    System.out.println(ex);                
                }catch(NumberFormatException ex){
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Error al guardar cita médica\nUse el botón para guardar nuevas citas", 
                            "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
                    System.out.println(ex);   
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un número de consultorio válido", "Citas Médicas", JOptionPane.ERROR_MESSAGE);
                this.jTFConsultorio.getText();
            }
    }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        try {
            limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(JFCitaMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
        bloquear();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jTFBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFBuscarMousePressed
        resetMedico();
        resetPaciente();
        if(this.jTFBuscar.getText().equals("Cédula paciente")){
            this.jTFBuscar.setText("");
            this.jTFBuscar.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTFBuscarMousePressed

    private void jTFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBuscarActionPerformed
        this.jBBuscar.requestFocus();
    }//GEN-LAST:event_jTFBuscarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        try{
            if(this.jTFBuscar.getText().equals("")||this.jTFBuscar.getText().equals("Cédula paciente")){
                CitasTable();
            }else{
                buscar(this.jTFBuscar.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(JFCitaMedica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTFFechaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFFechaCitaActionPerformed
        fecha();
    }//GEN-LAST:event_jTFFechaCitaActionPerformed

    private void jCBHorarioCitasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBHorarioCitasMouseEntered
      //RECARGA LOS HORARIOS CADA QUE EL MOUSE PASA POR ENCIMA Y CUANDO EL ITEM SELECIONADO ES IGUAL A (SELECCIONAR)
      //SI EL ITEM SELECCIONADO ES DIFERENTE DE (SELECCIONAR) NO OCURRE NADA
      try{  
          if(jCBHorarioCitas.getSelectedItem().toString().equals("Seleccionar")){
                resetBuscar();
                cargarHorarios();
            }
      }catch(NullPointerException e){
          System.out.print("Citas vacias");
      }
    }//GEN-LAST:event_jCBHorarioCitasMouseEntered

    private void jTFConsultorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFConsultorioKeyTyped
        char variable = evt.getKeyChar();
        if(Character.isLetter(variable)||Character.isSpaceChar(variable)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO NÚMEROS\nEl número de consultorio","Citas Médicas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTFConsultorioKeyTyped

    private void jCBHorarioCitasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBHorarioCitasMousePressed
        resetBuscar();
        resetFecha();
        resetMedico();
        resetPaciente();
        cargarHorarios();
    }//GEN-LAST:event_jCBHorarioCitasMousePressed

    private void jTableCitaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCitaMousePressed
        this.jTFFechaCita.setForeground(Color.BLACK);
        this.jBGuardar.setEnabled(false);
        resetBuscar();
        this.jTFBuscarMedico.setText("Especialidad");
        this.jTFBuscarMedico.setForeground(Color.GRAY);
        Circulo circulo;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = Conexion.getConexion();
            int Fila = jTableCita.getSelectedRow();
            String codigo = jTableCita.getValueAt(Fila, 0).toString();
            ps = con.prepareStatement("SELECT  IDCita, NumCedulaP, IDMedico, especialidades, Consultorio, FechaCita, Hora, EstadoCita FROM citamedica WHERE IDCita=? ");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()){
                jTFIdCita.setText(rs.getString("IDCita"));                
                jTFCedulaPaciente.setText(rs.getString("NumCedulaP"));
                jTFIDMedico.setText(rs.getString("IDMedico"));     
                jTFEspecialidad.setText(rs.getString("especialidades"));
                jTFConsultorio.setText(rs.getString("Consultorio"));
                jTFFechaCita.setText(rs.getString("FechaCita"));
                jCBEstadoCita.setSelectedItem(rs.getString("EstadoCita"));
            }  
            desbloquear();
            con.close();
        }catch(SQLException ex){
             System.out.println(ex.toString());
        }
        //CONDICIONAL PARA QUE SE DIBUJE EL CIRCULO CORRESPONDIENTE AL ESTADO DE LA CITA
        circulo = new Circulo(30, 12, 7);
        if(jCBEstadoCita.getSelectedItem().toString().equals("Reservado")){
            circulo.DibujarReserva(jPanelReserva.getGraphics(), 12, 7, 30);
        }else{
            circulo.DibujarLibre(jPanelReserva.getGraphics(), 12, 7, 30);
        }  
    }//GEN-LAST:event_jTableCitaMousePressed

    private void jTableCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCitaMouseClicked

    }//GEN-LAST:event_jTableCitaMouseClicked

    private void jCBHorarioCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBHorarioCitasActionPerformed

    }//GEN-LAST:event_jCBHorarioCitasActionPerformed

    private void jTFBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarKeyTyped
        try {
            buscar(this.jTFBuscar.getText());
        } catch (SQLException ex) {
            Logger.getLogger(JFCitaMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTFBuscarKeyTyped

    private void jTFBuscarMedicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFBuscarMedicoMousePressed
        resetFecha();
        resetPaciente();
        try {
            MedicoTable();
        } catch (SQLException ex) {
            Logger.getLogger(JFCitaMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(this.jTFBuscarMedico.getText().equals("Especialidad")){
            this.jTFBuscarMedico.setText("");
            this.jTFBuscarMedico.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTFBuscarMedicoMousePressed

    private void jTFBuscarPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFBuscarPacienteMousePressed
        resetFecha();
        resetMedico();
        try {
            PacienteTable();
        } catch (SQLException ex) {
            Logger.getLogger(JFCitaMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(this.jTFBuscarPaciente.getText().equals("Cédula")){
            this.jTFBuscarPaciente.setText("");
            this.jTFBuscarPaciente.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTFBuscarPacienteMousePressed

    private void jBBuscarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarMedicoActionPerformed
        try {
            if(this.jTFBuscarMedico.getText().equals("")||this.jTFBuscarMedico.getText().equals("Especialidad")){
                MedicoTable();
            }else{
                buscarMedico(this.jTFBuscarMedico.getText());
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jBBuscarMedicoActionPerformed

    private void jBBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarPacienteActionPerformed
        try {
            if(this.jTFBuscarPaciente.getText().equals("")||this.jTFBuscarPaciente.getText().equals("Cédula")){
                PacienteTable();
            }else{
                buscarPaciente(this.jTFBuscarPaciente.getText());
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jBBuscarPacienteActionPerformed

    private void jTFBuscarMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarMedicoKeyTyped
        try {
            buscarMedico(this.jTFBuscarMedico.getText());
        } catch (SQLException ex) {
            Logger.getLogger(JFCitaMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTFBuscarMedicoKeyTyped

    private void jTFBuscarPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarPacienteKeyTyped
        try {
            buscarPaciente(this.jTFBuscarPaciente.getText());
        } catch (SQLException ex) {
            Logger.getLogger(JFCitaMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTFBuscarPacienteKeyTyped

    private void jTablaMedicosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMedicosMousePressed
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = Conexion.getConexion();
            int Fila = jTablaMedicos.getSelectedRow();
            String codigo = jTablaMedicos.getValueAt(Fila, 0).toString();
            ps = conn.prepareStatement("SELECT idmedico, apellido, nombre, especialidad FROM medico WHERE idmedico=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                jTFIDMedico.setText(rs.getString("IDMedico"));
                jTFEspecialidad.setText(rs.getString("especialidad"));
            }
            Conexion.Cerrar(conn);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jTablaMedicosMousePressed

    private void jTablaPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaPacienteMousePressed
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = Conexion.getConexion();
            int Fila = jTablaPaciente.getSelectedRow();
            String codigo = jTablaPaciente.getValueAt(Fila, 0).toString();
            ps = conn.prepareStatement("SELECT NumCedulaP, apellido, nombre, telefono FROM paciente WHERE NumCedulaP=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                jTFCedulaPaciente.setText(rs.getString("NumCedulaP"));
            }
            Conexion.Cerrar(conn);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jTablaPacienteMousePressed
    
    private void limpiar () throws SQLException{
        CitasTable();
        PacienteTable();
        MedicoTable();
        jTFIdCita.setText("");
        jTFConsultorio.setText("");
        jTFFechaCita.setText("");
        jTFEspecialidad.setText("");
        jTFIDMedico.setText("");
        jTFCedulaPaciente.setText("");
        jCBHorarioCitas.setSelectedIndex(0);
        jCBEstadoCita.setSelectedIndex(0);
        this.jBGuardar.setEnabled(true);
        jPanelReserva.repaint();
        this.jTFBuscar.setText("Cédula paciente");
        this.jTFBuscar.setForeground(Color.GRAY);
        this.jTFBuscarPaciente.setText("Cédula");
        this.jTFBuscarPaciente.setForeground(Color.GRAY);
        this.jTFBuscarMedico.setText("Especialidad");
        this.jTFBuscarMedico.setForeground(Color.GRAY);
        this.jTFFechaCita.setText("AAAA-MM-DD");
        this.jTFFechaCita.setForeground(Color.GRAY);
    }
    private void bloquear (){
        jTFIdCita.setEnabled(false);
        jTFConsultorio.setEnabled(false);
        jTFFechaCita.setEnabled(false);
        jTFIDMedico.setEnabled(false);
        jTFEspecialidad.setEnabled(false);
        jTFCedulaPaciente.setEnabled(false);
        jCBHorarioCitas.setEnabled(false);
        jCBEstadoCita.setEnabled(false);
    }
    private void desbloquear (){
        jTFIdCita.setEnabled(true);
        jTFIdCita.setEditable(false);
        jTFConsultorio.setEnabled(true);
        jTFFechaCita.setEnabled(true);
        jTFEspecialidad.setEnabled(true);
        jTFIDMedico.setEnabled(true);
        jTFCedulaPaciente.setEnabled(true);
        jCBHorarioCitas.setEnabled(true);
        jCBEstadoCita.setEnabled(true);
    }
    private void cerrar () throws SQLException{
        CitasTable();
        PacienteTable();
        MedicoTable();
        this.setVisible(false);
        this.jBNuevo.requestFocus();
        limpiar ();
        bloquear ();
        CitasTable();
        this.jTFBuscar.setText("Cédula paciente");
        this.jTFBuscar.setForeground(Color.GRAY);
        this.jTFBuscarPaciente.setText("Cédula");
        this.jTFBuscarPaciente.setForeground(Color.GRAY);
        this.jTFBuscarMedico.setText("Especialidad");
        this.jTFBuscarMedico.setForeground(Color.GRAY);
        this.jTFFechaCita.setText("AAAA-MM-DD");
        this.jTFFechaCita.setForeground(Color.GRAY);
    }

    public void CitasTable() throws SQLException{
        tablaCitas.DesplegarCitas(jTableCita);
        setSizeCitas();
    }
    
    private void buscar(String valor) throws SQLException{
        tablaCitas.BuscarCita(jTableCita, valor);
        setSizeCitas();
    }
    
    public void MedicoTable() throws SQLException{
        tablaCitas.DesplegarMedicoINF(jTablaMedicos);
        setSizeMedico();
    }
 
    private void buscarMedico(String valor) throws SQLException{
        tablaCitas.BuscarMedicoINF(jTablaMedicos, valor);
        setSizeMedico();
    }

    public void PacienteTable() throws SQLException{
        tablaCitas.DesplegarPacienteINF(jTablaPaciente);
        setSizePaciente();
    }
    
    private void buscarPaciente(String valor) throws SQLException{
        tablaCitas.BuscarPacienteINF(jTablaPaciente, valor);
        setSizePaciente();
    }   

    private void resetBuscar(){
        if(this.jTFBuscar.getText().isEmpty()){
            this.jTFBuscar.setText("Cédula paciente");
            this.jTFBuscar.setForeground(Color.GRAY);
        }
    }
    
    private void resetFecha(){
        if(this.jTFFechaCita.getText().isEmpty()){
            this.jTFFechaCita.setText("AAAA-MM-DD");
            this.jTFFechaCita.setForeground(Color.GRAY);
        }
    }
    
    private void resetMedico(){
        if(this.jTFBuscarMedico.getText().isEmpty()){
            this.jTFBuscarMedico.setText("Especialidad");
            this.jTFBuscarMedico.setForeground(Color.GRAY);
        }
    }
    
    private void resetPaciente(){
        if(this.jTFBuscarPaciente.getText().isEmpty()){
            this.jTFBuscarPaciente.setText("Cédula");
            this.jTFBuscarPaciente.setForeground(Color.GRAY);
        }
    }
    
    private void fecha(){
        try{
            String fechaCita = this.jTFFechaCita.getText();
            String fechaHoy = this.jTFFechaActual.getText();
            LocalDate aux = LocalDate.parse(fechaCita);
            LocalDate hoy = LocalDate.parse(fechaHoy);
            
            if(aux.compareTo(hoy)<0){
                JOptionPane.showMessageDialog(null, "Fecha pasada");
                this.jTFFechaCita.setText("");
                this.jTFFechaCita.requestFocus();
            }
            if(aux.getDayOfWeek().equals(DayOfWeek.SUNDAY)||aux.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                JOptionPane.showMessageDialog(null, "No existe atención los sábados y domingos");
                this.jTFFechaCita.setText("");
                this.jTFFechaCita.requestFocus();
            }
            
        }catch(DateTimeParseException e){
            JOptionPane.showMessageDialog(null, "Formato incorrecto\nAAAA-MM-DD");
        }
    }
    
    private void cargarHorarios(){
        this.jCBHorarioCitas.removeAllItems();
        String aux = this.jTFIDMedico.getText();
        String aux1 = this.jTFFechaCita.getText();
            try {
                PreparedStatement pscombo = null;
                ResultSet rscombo = null;
                Connection con = Conexion.getConexion();

                String sqlcombo = "SELECT HORARIO FROM Horarios WHERE IDmedico = '"+aux+"' AND FechaC = '"+aux1+"' AND Estado = 'Disponible'" ;
                pscombo = con.prepareStatement(sqlcombo);
                rscombo = pscombo.executeQuery();
                jCBHorarioCitas.addItem("Seleccionar");
                while(rscombo.next()){
                    jCBHorarioCitas.addItem(rscombo.getString("HORARIO"));
                }
                Conexion.Cerrar(rscombo);
                con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }    
 }
    
    private void ActualizarDisponibilidad(){
      //CASO BOTÓN GUARDAR
        PreparedStatement ps = null;
        String id = this.jTFIDMedico.getText();
        String fechac = this.jTFFechaCita.getText();
        String hora = this.jCBHorarioCitas.getSelectedItem().toString();
        String estado = this.jCBEstadoCita.getSelectedItem().toString();
        try {
            //ACTUALIZA LA TABLA HORARIOS, EXTRAYENDO LOS VALORES STRING ASIGNADOS A LOS JTFs
            //Y USANDOLOS EN LA SENTENCIA DE UPDATE PARA LA TABLA HORARIOS
            try (Connection conn = Conexion.getConexion()) {
                //ACTUALIZA LA TABLA HORARIOS, EXTRAYENDO LOS VALORES STRING ASIGNADOS A LOS JTFs
                //Y USANDOLOS EN LA SENTENCIA DE UPDATE PARA LA TABLA HORARIOS
                ps = conn.prepareStatement("UPDATE Horarios SET Estado = '"+estado+"' WHERE IDMedico = '"+id+"' AND FechaC = '"+fechac+"' AND HORARIO = '"+hora+"'");
                ps.execute();
            }
        }catch(SQLException a){
            System.out.print(a);
        }
    }
    private void ActualizarDisponibilidadBORRAR(){
      //BOTON BORRAR
        PreparedStatement ps, ps1 = null;
        ResultSet rs = null;
        String id = this.jTFIDMedico.getText();
        String fechac = this.jTFFechaCita.getText();
        String id1 = this.jTFIdCita.getText();
        String aux = "";
       //EXTRAER LA FECHA DE LA CITA, DEBIDO A QUE POR EL FILTRO YA NO APARECE EN EL COMBOBOX DE HORARIOS
        try {
            Connection conn = Conexion.getConexion();
            ps1 = conn.prepareStatement("SELECT Hora FROM citamedica WHERE idcita = '"+id1+"'");
            rs = ps1.executeQuery();
            while (rs.next()){
                aux = (rs.getString("Hora"));
            }
        }catch(SQLException a){
            System.out.print(a);
        }
      //CON LA FECHA EXTRAIDA, SE ACTUALIZA LA TABLA HORARIOS
        String hora = aux;
        try {
            try (Connection conn = Conexion.getConexion()) {
                ps = conn.prepareStatement("UPDATE Horarios SET Estado = 'Disponible' WHERE IDMedico = '"+id+"' AND FechaC = '"+fechac+"' AND HORARIO = '"+hora+"'");
                ps.execute();
            }
            } catch (SQLException e) {
                System.out.print(e);
        }
    }
    private void ActualizarDisponibilidad2(){
       //CASO BOTÓN ACTUALIZAR
        if(jCBEstadoCita.getSelectedItem().toString().equals("Disponible")){
            ActualizarDisponibilidad();
        }else{
            PreparedStatement ps, ps1 = null;
            ResultSet rs = null;
            String id = this.jTFIDMedico.getText();
            String id1 = this.jTFIdCita.getText();
            String fechac = this.jTFFechaCita.getText();
            String aux = "";
          //EXTRAER LA FECHA DE LA CITA, DEBIDO A QUE POR EL FILTRO YA NO APARECE EN EL COMBOBOX DE HORARIOS
            try {
                try (Connection conn = Conexion.getConexion()) {
                    ps1 = conn.prepareStatement("SELECT Hora FROM citamedica WHERE idcita = '"+id1+"'");
                    rs = ps1.executeQuery();
                    while (rs.next()){
                        aux = (rs.getString("Hora"));
                    }
                }
            }catch(SQLException a){
                System.out.print(a);
            }
          //CON LA FECHA EXTRAIDA, SE ACTUALIZA LA TABLA HORARIOS CON LA FINALIDAD DE LIBERAR EL HORARIO DE LA CITA QUE SE ACTUALIZO
            String hora = aux;
            try{
                Connection conn = Conexion.getConexion();
                ps = conn.prepareStatement("UPDATE Horarios SET Estado = 'Disponible' WHERE IDMedico = '"+id+"' AND FechaC = '"+fechac+"' AND HORARIO = '"+hora+"'");
                ps.execute();
                conn.close();
                ActualizarDisponibilidad();
            }catch(SQLException e){
                System.out.print(e);
           //RESERVAR EL NUEVO HORARIO SELECCIONADO
            
        }
    }
}
    private void setSizeCitas(){
        jTableCita.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTableCita.getColumnModel().getColumn(1).setPreferredWidth(25);
        jTableCita.getColumnModel().getColumn(2).setPreferredWidth(5);
        jTableCita.getColumnModel().getColumn(3).setPreferredWidth(25);
        jTableCita.getColumnModel().getColumn(4).setPreferredWidth(8);
        jTableCita.getColumnModel().getColumn(5).setPreferredWidth(25);
        jTableCita.getColumnModel().getColumn(6).setPreferredWidth(32);
        jTableCita.getColumnModel().getColumn(7).setPreferredWidth(25);
    }
    
    private void setSizeMedico(){
        jTablaMedicos.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTablaMedicos.getColumnModel().getColumn(1).setPreferredWidth(9);
        jTablaMedicos.getColumnModel().getColumn(2).setPreferredWidth(9);
        jTablaMedicos.getColumnModel().getColumn(3).setPreferredWidth(20);
    }
    
    private void setSizePaciente(){
        jTablaPaciente.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTablaPaciente.getColumnModel().getColumn(1).setPreferredWidth(10);
        jTablaPaciente.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTablaPaciente.getColumnModel().getColumn(3).setPreferredWidth(10);
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
            java.util.logging.Logger.getLogger(JFCitaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCitaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCitaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCitaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFCitaMedica().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFCitaMedica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBBuscarMedico;
    private javax.swing.JButton jBBuscarPaciente;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JComboBox<String> jCBEstadoCita;
    private javax.swing.JComboBox<String> jCBHorarioCitas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelReserva;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTFBuscar;
    private javax.swing.JTextField jTFBuscarMedico;
    private javax.swing.JTextField jTFBuscarPaciente;
    private javax.swing.JTextField jTFCedulaPaciente;
    private javax.swing.JTextField jTFConsultorio;
    private javax.swing.JTextField jTFEspecialidad;
    private javax.swing.JTextField jTFFechaActual;
    private javax.swing.JTextField jTFFechaCita;
    private javax.swing.JTextField jTFIDMedico;
    private javax.swing.JTextField jTFIdCita;
    private javax.swing.JTextField jTFaux;
    private javax.swing.JTable jTablaMedicos;
    private javax.swing.JTable jTablaPaciente;
    private javax.swing.JTable jTableCita;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
