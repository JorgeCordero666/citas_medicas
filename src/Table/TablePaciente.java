
package Table;

import Negocio.Conexion;
import Negocio.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablePaciente {
    static Connection connect;
    static Statement statement;
    static ResultSet resultset;
    static PreparedStatement preparedS;
    
    public void DesplegarPaciente(JTable tabla) throws SQLException{
        DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("No.Cédula");
            modelo.addColumn("Apellido");
            modelo.addColumn("Nombre");
            modelo.addColumn("Edad");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Síntomas");
        try {
            String sql = "SELECT NumCedulaP, apellido, nombre, edad, telefono, sintomas FROM paciente";
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);
            String filas[] = new String[6];
            while(resultset.next()){
                filas[0] = resultset.getString(1);
                filas[1] = resultset.getString(2);
                filas[2] = resultset.getString(3);
                filas[3] = resultset.getString(4);
                filas[4] = resultset.getString(5);
                filas[5] = resultset.getString(6);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public void GuardarPaciente(Paciente paciente) throws SQLException{
        String sql = "INSERT INTO Paciente (NumCedulaP, Apellido, Nombre, Edad, Telefono, sintomas) VALUES (?,?,?,?,?,?)";
        try{
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            preparedS = Conexion.getPreparedStatement(sql);
            preparedS.setInt(1, paciente.getCedula());
            preparedS.setString(2, paciente.getApellidoPte());
            preparedS.setString(3, paciente.getNombrePte());
            preparedS.setInt(4, paciente.getEdad());
            preparedS.setString(5, paciente.getNumeroTelefonicoPte());
            preparedS.setString(6, paciente.getSintomas());
            preparedS.executeUpdate();
            JOptionPane.showMessageDialog(null,"Los datos se han guardado con éxito","Citas Médicas",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al guardar paciente", 
                "Citas Médicas", JOptionPane.ERROR_MESSAGE);     
            System.err.println(e);
        }finally {
            if(preparedS != null){
                Conexion.Cerrar(preparedS);
            }if(connect != null){
                Conexion.Cerrar(connect);
            }
        }
    }
    
    public Integer ActualizarPaciente(Paciente paciente) throws SQLException{
        Integer aux = null;
        try {
            String sql = "UPDATE paciente SET Apellido=?, Nombre=?, Edad=?, Telefono=?, Sintomas=? WHERE numcedulap=?";
            connect = Conexion.getConexion();
            preparedS = Conexion.getPreparedStatement(sql);
            preparedS.setString(1, paciente.getApellidoPte());
            preparedS.setString(2, paciente.getNombrePte());
            preparedS.setInt(3, paciente.getEdad());
            preparedS.setString(4, paciente.getNumeroTelefonicoPte());
            preparedS.setString(5, paciente.getSintomas());
            preparedS.setInt(6, paciente.getCedula());
            aux = preparedS.executeUpdate();
            
            if(aux >= 1){
                JOptionPane.showMessageDialog(null, "Los datos del paciente han sido actualizados", "Citas Médicas", JOptionPane.INFORMATION_MESSAGE); 
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos del paciente", "Citas Médicas", JOptionPane.ERROR_MESSAGE);  
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
        
    public int EliminarPaciente(Paciente paciente) throws SQLException{
        int aux;
        String sql = "DELETE FROM paciente WHERE numcedulap=?";
        try{
            connect = Conexion.getConexion();
            preparedS = Conexion.getPreparedStatement(sql);
            preparedS.setInt(1, paciente.getCedula());
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
    public void BuscarPaciente(JTable tabla, String aux) throws SQLException{
        DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("No.Cédula");
            modelo.addColumn("Apellido");
            modelo.addColumn("Nombre");
            modelo.addColumn("Edad");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Síntomas");
        try {
            String sql = "SELECT NumCedulaP, apellido, nombre, edad, telefono, sintomas FROM paciente WHERE NumCedulaP LIKE '%"+aux+"%'";
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            String filas[] = new String[6];
            while(resultset.next()){
                filas[0] = resultset.getString(1);
                filas[1] = resultset.getString(2);
                filas[2] = resultset.getString(3);
                filas[3] = resultset.getString(4);
                filas[4] = resultset.getString(5);
                filas[5] = resultset.getString(6);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
}
