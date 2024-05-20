
package Vista;

import Negocio.Conexion;
import Negocio.Medico;
import Table.TableCitaMedica;
import Table.TableMedico;
import java.awt.Toolkit;
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
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class JFHorarios extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    TableCitaMedica tabla = new TableCitaMedica();
    ArrayList<String> comboIDMedico;
    TableMedico tabla2 = new TableMedico();
    Medico medico;

    public JFHorarios() {
        initComponents();
        //PARA QUE NO SE FINALICE LA EJECUCIÓN AL CERRAR EL JF
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        comboIDMedico = new ArrayList<>();
        medico = new Medico();
        Toolkit im = Toolkit.getDefaultToolkit();
        setIconImage(im.getImage(getClass().getResource("/ImagenesLogin/ICONOPRINCIPAL.png")));
        this.setTitle("Selección de horarios");
        this.setLocationRelativeTo(null);
        //FORMATO DE LA FECHA
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        jTFFechaActual.setText(dtf.format(LocalDateTime.now()));
        //ACCIONES INICIALES
        this.jCBIdMedico.setEnabled(false);
        this.jTFFechaCita.setEnabled(false);
        this.jTFDisponible.setVisible(false);
        cargarMedicos();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCHB1 = new javax.swing.JCheckBox();
        jCHB2 = new javax.swing.JCheckBox();
        jCHB3 = new javax.swing.JCheckBox();
        jCHB5 = new javax.swing.JCheckBox();
        jCHB6 = new javax.swing.JCheckBox();
        jCHB4 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCBIdMedico = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTFFechaCita = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHorarios = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jCHB10 = new javax.swing.JCheckBox();
        jCHB8 = new javax.swing.JCheckBox();
        jCHB7 = new javax.swing.JCheckBox();
        jCHB11 = new javax.swing.JCheckBox();
        jCHB9 = new javax.swing.JCheckBox();
        jCHB12 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jTFDisponible = new javax.swing.JTextField();
        jTFFechaActual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jToggleHabilitar = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        jBRegresar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuBorrar = new javax.swing.JMenuItem();
        jMenuCerrar = new javax.swing.JMenuItem();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horario en la mañana", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jCHB1.setBackground(new java.awt.Color(245, 245, 245));
        jCHB1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB1.setText("09:00 a 09:30");

        jCHB2.setBackground(new java.awt.Color(245, 245, 245));
        jCHB2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB2.setText("09:30 a 10:00");

        jCHB3.setBackground(new java.awt.Color(245, 245, 245));
        jCHB3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB3.setText("10:00 a 10:30");

        jCHB5.setBackground(new java.awt.Color(245, 245, 245));
        jCHB5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB5.setText("11:00 a 11:30");

        jCHB6.setBackground(new java.awt.Color(245, 245, 245));
        jCHB6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB6.setText("11:30 a 12:00");

        jCHB4.setBackground(new java.awt.Color(245, 245, 245));
        jCHB4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB4.setText("10:30 a 11:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCHB4)
                    .addComponent(jCHB6)
                    .addComponent(jCHB5)
                    .addComponent(jCHB3)
                    .addComponent(jCHB2)
                    .addComponent(jCHB1))
                .addGap(76, 76, 76))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jCHB1)
                .addGap(18, 18, 18)
                .addComponent(jCHB2)
                .addGap(18, 18, 18)
                .addComponent(jCHB3)
                .addGap(18, 18, 18)
                .addComponent(jCHB4)
                .addGap(18, 18, 18)
                .addComponent(jCHB5)
                .addGap(18, 18, 18)
                .addComponent(jCHB6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(69, 199, 197));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HORARIOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(260, 260, 260))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("ID MÉDICO:");

        jCBIdMedico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCBIdMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        jCBIdMedico.setEnabled(false);
        jCBIdMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCBIdMedicoMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBIdMedicoMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("FECHA ASIGNADA:");

        jTFFechaCita.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFFechaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFFechaCitaActionPerformed(evt);
            }
        });

        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Buscar.png"))); // NOI18N
        jBBuscar.setBorderPainted(false);
        jBBuscar.setContentAreaFilled(false);
        jBBuscar.setFocusPainted(false);
        jBBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/BuscarPress.png"))); // NOI18N
        jBBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/BuscarRoll.png"))); // NOI18N
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel5.setText("AAAA-MM-DD");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFFechaCita)
                            .addComponent(jCBIdMedico, 0, 98, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTFFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(53, 53, 53))
        );

        jTableHorarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableHorarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableHorarios.setOpaque(false);
        jTableHorarios.setRowHeight(19);
        jScrollPane1.setViewportView(jTableHorarios);

        jPanel5.setBackground(new java.awt.Color(245, 245, 245));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horario en la tarde", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jCHB10.setBackground(new java.awt.Color(245, 245, 245));
        jCHB10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB10.setText("16:30 a 17:00");

        jCHB8.setBackground(new java.awt.Color(245, 245, 245));
        jCHB8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB8.setText("15:30 a 16:00");

        jCHB7.setBackground(new java.awt.Color(245, 245, 245));
        jCHB7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB7.setText("15:00 a 15:30");

        jCHB11.setBackground(new java.awt.Color(245, 245, 245));
        jCHB11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB11.setText("17:00 a 17:30");

        jCHB9.setBackground(new java.awt.Color(245, 245, 245));
        jCHB9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB9.setText("16:00 a 16:30");

        jCHB12.setBackground(new java.awt.Color(245, 245, 245));
        jCHB12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCHB12.setText("17:30 a 18:00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCHB12)
                    .addComponent(jCHB11)
                    .addComponent(jCHB10)
                    .addComponent(jCHB9)
                    .addComponent(jCHB8)
                    .addComponent(jCHB7))
                .addGap(78, 78, 78))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jCHB7)
                .addGap(18, 18, 18)
                .addComponent(jCHB8)
                .addGap(18, 18, 18)
                .addComponent(jCHB9)
                .addGap(18, 18, 18)
                .addComponent(jCHB10)
                .addGap(18, 18, 18)
                .addComponent(jCHB11)
                .addGap(18, 18, 18)
                .addComponent(jCHB12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTFDisponible.setForeground(new java.awt.Color(255, 255, 255));
        jTFDisponible.setText("Disponible");
        jTFDisponible.setBorder(null);

        jTFFechaActual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFFechaActual.setText("AAAA-MM-DD");
        jTFFechaActual.setBorder(null);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTFDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTFFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTFDisponible)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTFFechaActual)
                .addContainerGap())
        );

        jToggleHabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Desahabilitado.png"))); // NOI18N
        jToggleHabilitar.setBorderPainted(false);
        jToggleHabilitar.setContentAreaFilled(false);
        jToggleHabilitar.setFocusPainted(false);
        jToggleHabilitar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Habilitado.png"))); // NOI18N
        jToggleHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleHabilitarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Habilitar\n");

        jBRegresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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

        jBEliminar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Eliminar.png"))); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.setBorderPainted(false);
        jBEliminar.setContentAreaFilled(false);
        jBEliminar.setFocusPainted(false);
        jBEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/EliminarPress.png"))); // NOI18N
        jBEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/EliminarRoll.png"))); // NOI18N
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBGuardar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesVarias/Guardar.png"))); // NOI18N
        jBGuardar.setText("Guardar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToggleHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBRegresar)
                                    .addComponent(jBEliminar)
                                    .addComponent(jBGuardar)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleHabilitar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRegresar))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu.setText("File");

        jMenuBorrar.setText("Borrado completo   ");
        jMenuBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBorrarActionPerformed(evt);
            }
        });
        jMenu.add(jMenuBorrar);

        jMenuCerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuCerrar.setText("Cerrar");
        jMenuCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCerrarActionPerformed(evt);
            }
        });
        jMenu.add(jMenuCerrar);

        jMenuBar.add(jMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        PreparedStatement ps,p1 = null;
        ResultSet rs = null;
        String aux= "" , aux2 = "";
        fecha();
      //CONDICIONAL PARA CONFIRMAR QUE SELECCIONE CORRECTAMENTE LOS FECHA Y EL MÉDICO
        if(jTFFechaCita.getText().isEmpty()||jCBIdMedico.getSelectedItem().toString().equals("Seleccionar")){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos correctamente");
            desmarcar();
        }else{
            try {
                Connection conx = Conexion.getConexion();
                Connection conx2 = Conexion.getConexion();
                ps = conx.prepareStatement("SELECT IDMedico, FechaC FROM HORARIOS WHERE IDMedico = '"+
                        this.jCBIdMedico.getSelectedItem().toString()+"' AND FechaC = '"+this.jTFFechaCita.getText()+"'");
                rs = ps.executeQuery();
                while (rs.next()){
                    aux = rs.getString("IDMedico");
                    aux2 = rs.getString("FechaC");
                }
                if(aux.equals(this.jCBIdMedico.getSelectedItem().toString()) && aux2.equals(this.jTFFechaCita.getText())){
                JOptionPane.showMessageDialog(null, "Ya existen horarios definidos para "+jCBIdMedico.getSelectedItem().toString()
                        +" el "+jTFFechaCita.getText(),
                        "Citas Médicas", JOptionPane.ERROR_MESSAGE);
                }else{
                  //MEDIANTE EL CONDICIONAL, SI ESTÁ SELECCIONADO EL CHECKBOX EXTRAE LA SELECCIÓN Y MEDIANTE LENGUAJE SQL
                  //SE INTRODUCEN EN HORARIOS, EL MÉDICO SELECCIONADO JUNTO CON LA FECHA Y LOS HORARIOS
                    if(jCHB1.isSelected()){
                        ps = conx2.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB1.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB1.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB2.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB2.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB2.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB3.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB3.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB3.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB4.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB4.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB4.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB5.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB5.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB5.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB6.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB6.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());                
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB6.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB7.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB7.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB7.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB8.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB8.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB8.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB9.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB9.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB9.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB10.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB10.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB10.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB11.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB11.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB11.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    if(jCHB12.isSelected()){
                        ps = conx.prepareStatement("INSERT INTO HORARIOS (IDMedico, HORARIO, FechaC, Estado) VALUES (?,?,?,?)");
                        ps.setString(1, jCBIdMedico.getSelectedItem().toString());
                        ps.setString(2, jCHB12.getText());
                        ps.setString(3, jTFFechaCita.getText());
                        ps.setString(4, jTFDisponible.getText());
                        ps.execute();
                        Object[] fila = new Object[4];
                        fila[0] = jCBIdMedico.getSelectedItem().toString();
                        fila[1] = jCHB12.getText();
                        fila[2] = jTFFechaCita.getText();
                        fila[3] = jTFDisponible.getText();
                        modelo.addRow(fila);
                    }
                    JOptionPane.showMessageDialog(null, "Los horarios se han guardado con éxito");
                }
                conx.close();
                conx2.close();
            } catch (SQLException e) {
                getToolkit().beep();
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al guardar los horarios");
            }
        }

        
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        desmarcar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if(jTFFechaCita.getText().isEmpty()||jCBIdMedico.getSelectedItem().toString().equals("Seleccionar")){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos correctamente");
        }else{
            try {
                Connection conn = Conexion.getConexion();
                String codigo = jCBIdMedico.getSelectedItem().toString();
                String codigo2 = jTFFechaCita.getText();
              //MEDIANTE codigo Y codigo2 SE REALIZA LA CONSULTA CON LENGUAJE SQL PARA SELECCIONAR EL IDMEDICO Y LA FECHA
                ps = conn.prepareStatement("SELECT IDMedico, HORARIO FROM horarios WHERE IDMedico = '"+codigo+"' AND FechaC = '"+codigo2+"'");            
                rs = ps.executeQuery();
                while (rs.next()) {
                  //CONDICIONAL PARA VERIFICAR Y SELECCIONAR LOS CHECKBOX CORRESPONDIENTES AL IDMEDICO Y LA FECHA INGRESADA
                    if(jCHB1.getText().equals(rs.getString("HORARIO"))){
                        jCHB1.setSelected(true);
                    }
                    if(jCHB2.getText().equals(rs.getString("HORARIO"))){
                        jCHB2.setSelected(true);
                    }
                    if(jCHB3.getText().equals(rs.getString("HORARIO"))){
                        jCHB3.setSelected(true);
                    }
                    if(jCHB4.getText().equals(rs.getString("HORARIO"))){
                        jCHB4.setSelected(true);
                    }
                    if(jCHB5.getText().equals(rs.getString("HORARIO"))){
                        jCHB5.setSelected(true);
                    }
                    if(jCHB6.getText().equals(rs.getString("HORARIO"))){
                        jCHB6.setSelected(true);
                    }
                    if(jCHB7.getText().equals(rs.getString("HORARIO"))){
                        jCHB7.setSelected(true);
                    }
                    if(jCHB8.getText().equals(rs.getString("HORARIO"))){
                        jCHB8.setSelected(true);
                    }
                    if(jCHB9.getText().equals(rs.getString("HORARIO"))){
                        jCHB9.setSelected(true);
                    }
                    if(jCHB10.getText().equals(rs.getString("HORARIO"))){
                        jCHB10.setSelected(true);
                    }
                    if(jCHB11.getText().equals(rs.getString("HORARIO"))){
                        jCHB11.setSelected(true);
                    }
                    if(jCHB12.getText().equals(rs.getString("HORARIO"))){
                        jCHB12.setSelected(true);
                    }
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        if(jCBIdMedico.getSelectedItem().toString().equals("Seleccionar")|| jTFFechaCita.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Seleccione un ID Médico y una fecha");
            }else{
                String botones[] = {"  Borrar  ", " Cancelar "};
                int op = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar el registro?", "Sistema de citas médicas", 0, 0, null, botones, this);
                if(op == JOptionPane.YES_OPTION){
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    try{ 
                        Connection conn = Conexion.getConexion();
                        String codigo = this.jCBIdMedico.getSelectedItem().toString();
                        String codigo2 = this.jTFFechaCita.getText();
                      //MEDIANTE LENGUAJE SQL SE ELIMINA LOS HORARIOS CORRESPONDIENTES AL IDMEDICO Y FECHA SELECCIONADOS
                        ps = conn.prepareStatement("DELETE FROM horarios WHERE IDMedico = '"+codigo+"' AND FechaC = '"+codigo2+"'");
                        ps.execute();
                        JOptionPane.showMessageDialog(null, "Registro de horario eliminado para "+codigo);
                        setContenidoTabla();
                        desmarcar();
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, "Error al eliminar horario");
                        System.out.println(ex.toString());
                }
                }else if (op == JOptionPane.NO_OPTION){ 
            }       
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jCBIdMedicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBIdMedicoMousePressed
        cargarMedicos();
    }//GEN-LAST:event_jCBIdMedicoMousePressed

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        cerrar();
    }//GEN-LAST:event_jBRegresarActionPerformed

    private void jTFFechaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFFechaCitaActionPerformed
        fecha();
    }//GEN-LAST:event_jTFFechaCitaActionPerformed

    private void jMenuBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBorrarActionPerformed
        try{
        String id = JOptionPane.showInputDialog("Borra todas las fechas y horarios asignados a un médico\nINGRESE UN ID MÉDICO:");
        if(id.isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese un ID Médico");
            }else{
                String botones[] = {"  Borrar  ", " Cancelar "};
                int op = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar el registro?", "Sistema de citas médicas", 0, 0, null, botones, this);
                if(op == JOptionPane.YES_OPTION){
                    medico.setIdmedico(id);
                    try {
                        tabla2.EliminarMedicoHorarios(medico);
                    } catch (SQLException e) {
                    } 
                }else if (op == JOptionPane.NO_OPTION){
            }       
        }
        }catch(NullPointerException e){
        System.out.println("Se cierra el borrado completo");
        }
    }//GEN-LAST:event_jMenuBorrarActionPerformed

    private void jMenuCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCerrarActionPerformed
        cerrar();
    }//GEN-LAST:event_jMenuCerrarActionPerformed

    private void jToggleHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleHabilitarActionPerformed
        if(jToggleHabilitar.isSelected()){
            this.jCBIdMedico.setEnabled(true);
            this.jTFFechaCita.setEnabled(true);
            cargarMedicos();
        }else{
            desmarcar();
            this.jTFFechaCita.setEnabled(false);
            this.jCBIdMedico.setEnabled(false);
        }
    }//GEN-LAST:event_jToggleHabilitarActionPerformed

    private void jCBIdMedicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBIdMedicoMouseEntered
        if(jCBIdMedico.getSelectedItem().toString().equals("Seleccionar")){
            cargarMedicos();
        }
    }//GEN-LAST:event_jCBIdMedicoMouseEntered
    
    public void cerrar(){
        this.setVisible(false);
        this.jTFFechaCita.setEnabled(false);
        this.jCBIdMedico.setEnabled(false);
        this.jTFFechaCita.setText("");
        this.jCBIdMedico.setSelectedIndex(0);
        this.jToggleHabilitar.setSelected(false);
        desmarcar();
    }
    
    public void desmarcar(){
        this.jCHB1.setSelected(false);
        this.jCHB2.setSelected(false);
        this.jCHB3.setSelected(false);
        this.jCHB4.setSelected(false);
        this.jCHB5.setSelected(false);
        this.jCHB6.setSelected(false);
        this.jCHB7.setSelected(false);
        this.jCHB8.setSelected(false);
        this.jCHB9.setSelected(false);
        this.jCHB10.setSelected(false);
        this.jCHB11.setSelected(false);
        this.jCHB12.setSelected(false);
    }
    
    private void fecha(){
      //EN ESTE MÉTODO VALIDA LAS FECHAS PARA LAS CITAS MÉDICAS QUE NO SEAN SÁBADOS NI DOMINGOS
      //NI FECHAS PASADAS AL DÍA ACTUAL DEL SISTEMA
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
        //CONDICIONAL QUE VERIFICA QUE NO SEA SÁBADO NI DOMINGO
            if(aux.getDayOfWeek().equals(DayOfWeek.SUNDAY)||aux.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                JOptionPane.showMessageDialog(null, "No existe atención los sábados y domingos");
                this.jTFFechaCita.setText("");
                this.jTFFechaCita.requestFocus();
            }
            
        }catch(DateTimeParseException e){
            //EN CASO DE QUE EL FORMATO SEA INCORRECTO
            JOptionPane.showMessageDialog(null, "Formato incorrecto\nAAAA-MM-DD");
                this.jTFFechaCita.setText("");
                this.jTFFechaCita.requestFocus();
        }
    }
    
    public void setContenidoTabla(){
        Connection con = Conexion.getConexion();
        try{
            String cons="SELECT Idmedico, horario, FechaC, Estado FROM horarios";
            String [] registros= new String[4];
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while(rs.next()){
                registros[0]=rs.getString(1);
                registros[1]=rs.getString(2);
                registros[2]=rs.getString(3);
                registros[3]=rs.getString(4);
                modelo.addRow(registros);
            }
            jTableHorarios.setModel(modelo);
            con.close();
        }catch(SQLException e){
            System.err.println(e);
        }
    }

        private void cargarMedicos(){
        this.jCBIdMedico.removeAllItems();
        comboIDMedico = tabla.ComboBoxIDMedico();
        for(int i=0 ; i<comboIDMedico.size() ;i++){
            jCBIdMedico.addItem(comboIDMedico.get(i));
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
            java.util.logging.Logger.getLogger(JFHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFHorarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JComboBox<String> jCBIdMedico;
    private javax.swing.JCheckBox jCHB1;
    private javax.swing.JCheckBox jCHB10;
    private javax.swing.JCheckBox jCHB11;
    private javax.swing.JCheckBox jCHB12;
    private javax.swing.JCheckBox jCHB2;
    private javax.swing.JCheckBox jCHB3;
    private javax.swing.JCheckBox jCHB4;
    private javax.swing.JCheckBox jCHB5;
    private javax.swing.JCheckBox jCHB6;
    private javax.swing.JCheckBox jCHB7;
    private javax.swing.JCheckBox jCHB8;
    private javax.swing.JCheckBox jCHB9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuBorrar;
    private javax.swing.JMenuItem jMenuCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDisponible;
    private javax.swing.JTextField jTFFechaActual;
    private javax.swing.JTextField jTFFechaCita;
    private javax.swing.JTable jTableHorarios;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleHabilitar;
    // End of variables declaration//GEN-END:variables
}
