
package Table;

import Negocio.CitaMedica;
import Negocio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableCitaMedica {
    static Connection connect;
    static Statement statement;
    static ResultSet resultset;
    static PreparedStatement preparedS;
    
    public void DesplegarCitas(JTable tabla) throws SQLException{ //Despliega las citas medicas 
        DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Cita");
            modelo.addColumn("Cédula Paciente");
            modelo.addColumn("ID Medico");
            modelo.addColumn("Especialidad");
            modelo.addColumn("Consultorio");
            modelo.addColumn("Fecha Cita");
            modelo.addColumn("Hora");
            modelo.addColumn("Estado Cita");     
        try {
            String sql = "SELECT IDCita, NumCedulaP, IDMedico, especialidades, Consultorio, FechaCita, Hora, EstadoCita FROM citamedica ORDER BY idcita";
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);
            String filas[] = new String[8];
            while(resultset.next()){
                filas[0] = resultset.getString(1);
                filas[1] = resultset.getString(2);
                filas[2] = resultset.getString(3);
                filas[3] = resultset.getString(4);
                filas[4] = resultset.getString(5);
                filas[5] = resultset.getString(6);
                filas[6] = resultset.getString(7);
                filas[7] = resultset.getString(8);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
            Conexion.Cerrar(connect);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public void GuardarCita(CitaMedica citamedica) throws SQLException{ //Este Metodo guarda las citas medicas 
        String sql = "INSERT INTO citamedica (IDCita, NumCedulaP, IDMedico, especialidades,"
                + " Consultorio, FechaCita, Hora, EstadoCita) VALUES (?,?,?,?,?,?,?,?)";
        try{
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            preparedS = Conexion.getPreparedStatement(sql);
            preparedS.setString(1, citamedica.getIdcita());
            preparedS.setInt(2, citamedica.getCedulapaciente());
            preparedS.setString(3, citamedica.getIdmedico());
            preparedS.setString(4, citamedica.getEsp().getEspecialidades());
            preparedS.setInt(5, citamedica.getConsultorio());
            preparedS.setString(6, citamedica.getHorario().getFechacita());
            preparedS.setString(7, citamedica.getHorario().getHorario());
            preparedS.setString(8, citamedica.getEstado());  
            preparedS.executeUpdate();
            JOptionPane.showMessageDialog(null,"Los datos se han guardado con éxito",
                    "Citas Médicas",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al guardar cita médica",
                    "Citas Médicas",JOptionPane.ERROR_MESSAGE);
        }finally {
            if(preparedS != null){
                Conexion.Cerrar(preparedS);
            }if(connect != null){
                Conexion.Cerrar(connect);
            }
        }
    }
    
    public Integer ActualizarCita(CitaMedica citamedica) throws SQLException{ //Este método actualiza los datos  en la ventana de citas medicas
        Integer aux = null;
        try {
            String sql = "UPDATE CitaMedica SET NumCedulaP=?, IDMedico=?, especialidades=?, consultorio=?, FechaCita=?, Hora=?, EstadoCita=? WHERE IDCita=?";
            connect = Conexion.getConexion();
            preparedS = Conexion.getPreparedStatement(sql);
            preparedS.setInt(1, citamedica.getCedulapaciente());
            preparedS.setString(2, citamedica.getIdmedico());
            preparedS.setString(3, citamedica.getEsp().getEspecialidades());
            preparedS.setInt(4, citamedica.getConsultorio());
            preparedS.setString(5, citamedica.getHorario().getFechacita());
            preparedS.setString(6, citamedica.getHorario().getHorario());
            preparedS.setString(7, citamedica.getEstado()); 
            preparedS.setString(8, citamedica.getIdcita());
            preparedS.executeUpdate();
            aux = preparedS.executeUpdate();
            
            if(aux >= 1){
                JOptionPane.showMessageDialog(null, "Los datos de la cita médica han sido actualizados", "Citas Médicas", JOptionPane.INFORMATION_MESSAGE); 
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos de la cita médica", "Citas Médicas", JOptionPane.ERROR_MESSAGE);  
            }   
        }finally{
            if(preparedS != null){
                Conexion.Cerrar(preparedS);
            }if(connect != null){
                Conexion.Cerrar(connect);
            }
        }
        return aux;
    }
        
    public int EliminarCita(CitaMedica citamedica) throws SQLException{//Elimina una cita medica
        int aux;
        String sql = "DELETE FROM CitaMedica WHERE IDCita=?";
        try{
            connect = Conexion.getConexion();
            preparedS = Conexion.getPreparedStatement(sql);
            preparedS.setString(1, citamedica.getIdcita());
            aux = preparedS.executeUpdate();
            if(aux > 0){
                JOptionPane.showMessageDialog(null, "Registro eliminado", "Citas Médicas", JOptionPane.INFORMATION_MESSAGE); 
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar registro", "Citas Médicas", JOptionPane.ERROR_MESSAGE); 
            }
        }finally{
            if(preparedS != null){
                Conexion.Cerrar(preparedS);
            }if(connect != null){
                Conexion.Cerrar(connect);
            }    
        }
        return aux;
    }
    public void BuscarCita(JTable tabla, String aux) throws SQLException{ //Busca una cita a través de un número de cedula 
        DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Cita");
            modelo.addColumn("Cédula Paciente");
            modelo.addColumn("ID Medico");
            modelo.addColumn("Especialidad");
            modelo.addColumn("Consultorio");
            modelo.addColumn("Fecha Cita");
            modelo.addColumn("Hora");
            modelo.addColumn("Estado Cita");  
        try {
            String sql = "SELECT IDCita, NumCedulaP, IDMedico, especialidades, Consultorio, "+
                    "FechaCita, Hora, EstadoCita FROM citamedica WHERE NumCedulaP LIKE '%"+aux+"%' ORDER BY FechaCita DESC";
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);
            String filas[] = new String[8];
            while(resultset.next()){
                filas[0] = resultset.getString(1);
                filas[1] = resultset.getString(2);
                filas[2] = resultset.getString(3);
                filas[3] = resultset.getString(4);
                filas[4] = resultset.getString(5);
                filas[5] = resultset.getString(6);
                filas[6] = resultset.getString(7);
                filas[7] = resultset.getString(8);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
            Conexion.Cerrar(connect);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
    
    public void BuscarMedicoINF(JTable tabla, String aux) throws SQLException{ //Busca la información de un medico 
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Médico");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especidalidad");
        try {
            String sql = "SELECT idmedico, apellido, nombre, especialidad FROM medico WHERE especialidad LIKE '%"+aux+"%'";
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);
            String filas[] = new String[4];
            while(resultset.next()){
                filas[0] = resultset.getString(1);
                filas[1] = resultset.getString(2);
                filas[2] = resultset.getString(3);
                filas[3] = resultset.getString(4);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
            Conexion.Cerrar(connect);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
    
    public void DesplegarMedicoINF(JTable tabla) throws SQLException{ //Este metodo Despliega la información del médico en una tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Médico");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especidalidad");
        try {
            String sql = "SELECT idmedico, apellido, nombre, especialidad FROM medico";
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);
            String filas[] = new String[4];
            while(resultset.next()){
                filas[0] = resultset.getString(1);
                filas[1] = resultset.getString(2);
                filas[2] = resultset.getString(3);
                filas[3] = resultset.getString(4);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
            Conexion.Cerrar(connect);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
    
    public void BuscarPacienteINF(JTable tabla, String aux) throws SQLException{ // Este método busca un paciente 
        DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("No.Cédula");
            modelo.addColumn("Apellido");
            modelo.addColumn("Nombre");
            modelo.addColumn("Teléfono");
        try {
            String sql = "SELECT NumCedulaP, apellido, nombre, telefono FROM paciente WHERE NumCedulaP LIKE '%"+aux+"%'";
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            String filas[] = new String[4];
            while(resultset.next()){
                filas[0] = resultset.getString(1);
                filas[1] = resultset.getString(2);
                filas[2] = resultset.getString(3);
                filas[3] = resultset.getString(4);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
            Conexion.Cerrar(connect);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
    
        public void DesplegarPacienteINF(JTable tabla) throws SQLException{ //Este método despliega la información del paciente en una tabla.
        DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("No.Cédula");
            modelo.addColumn("Apellido");
            modelo.addColumn("Nombre");
            modelo.addColumn("Teléfono");
        try {
            String sql = "SELECT NumCedulaP, apellido, nombre, telefono FROM paciente";
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            String filas[] = new String[4];
            while(resultset.next()){
                filas[0] = resultset.getString(1);
                filas[1] = resultset.getString(2);
                filas[2] = resultset.getString(3);
                filas[3] = resultset.getString(4);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
            Conexion.Cerrar(connect);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public static ArrayList<String> ComboBoxIDMedico(){
        ArrayList<String> id = new ArrayList<String>();
        String sql = "SELECT idmedico FROM medico ORDER BY idmedico";
        try {
            resultset = Conexion.getResultSet(sql);
            id.add("Seleccionar");
            while (resultset.next()) {
                id.add(resultset.getString("idmedico"));
            }
            resultset.close();
            Conexion.Cerrar(connect);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return id;
    }
}
