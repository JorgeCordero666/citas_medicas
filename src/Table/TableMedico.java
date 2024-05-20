
package Table;

import Negocio.Conexion;
import Negocio.Medico;
import static Table.TableCitaMedica.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableMedico {
    static Connection connect;
    static Statement statement;
    static ResultSet resultset;
    static PreparedStatement preparedS;
    
    public void DesplegarMedico(JTable tabla) throws SQLException{
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Médico");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especidalidad");
        modelo.addColumn("Teléfono");
        try {
            String sql = "SELECT idmedico, apellido, nombre, especialidad, telefono FROM medico";
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);
            String filas[] = new String[5];
            while(resultset.next()){
                filas[0] = resultset.getString(1);
                filas[1] = resultset.getString(2);
                filas[2] = resultset.getString(3);
                filas[3] = resultset.getString(4);
                filas[4] = resultset.getString(5);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
            resultset.close();
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public void GuardarMedico(Medico medico) throws SQLException{
        String sql = "INSERT INTO medico (idmedico, apellido, nombre, Especialidad, telefono) VALUES (?,?,?,?,?)";
        try{
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            preparedS = Conexion.getPreparedStatement(sql);
            preparedS.setString(1, medico.getIdmedico());
            preparedS.setString(2, medico.getApellidoMdco());
            preparedS.setString(3, medico.getNombreMdco());
            preparedS.setString(4, medico.getEspecialidad().getEspecialidades());
            preparedS.setString(5, medico.getNumeroTelefonicoMdco());
            preparedS.executeUpdate();
            JOptionPane.showMessageDialog(null,"Los datos se han guardado con éxito","Citas Médicas",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al guardar médico",
            "Citas Médicas",JOptionPane.ERROR_MESSAGE);
        }finally {
            if(preparedS != null){
                Conexion.Cerrar(preparedS);
            }if(connect != null){
                Conexion.Cerrar(connect);
            }
        }
    }
    public Integer ActualizarMedico(Medico medico) throws SQLException{
        Integer aux = null;
        try {
            String sql = "UPDATE medico SET apellido=?, nombre=?, especialidad=?, telefono=? WHERE idMedico=?";
            connect = Conexion.getConexion();
            preparedS = Conexion.getPreparedStatement(sql);
            preparedS.setString(1, medico.getApellidoMdco());
            preparedS.setString(2, medico.getNombreMdco());
            preparedS.setString(3, medico.getEspecialidad().getEspecialidades());
            preparedS.setString(4, medico.getNumeroTelefonicoMdco());
            preparedS.setString(5, medico.getIdmedico());
            aux = preparedS.executeUpdate();
            if(aux >= 1){
                JOptionPane.showMessageDialog(null, "Los datos del médico han sido actualizados", "Citas Médicas", JOptionPane.INFORMATION_MESSAGE); 
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos del médico", "Citas Médicas", JOptionPane.ERROR_MESSAGE);  
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
        
    public int EliminarMedico(Medico medico) throws SQLException{
        int aux;
        String sql = "DELETE FROM medico WHERE idmedico = ?";
        String sql1 = "DELETE FROM horarios WHERE idmedico = ?";
        try{
            connect = Conexion.getConexion();
            preparedS = Conexion.getPreparedStatement(sql1);
            preparedS.setString(1, medico.getIdmedico());
            aux = preparedS.executeUpdate();
            if(aux > 0){
                System.out.println("HORARIOS ASIGNADOS ELIMINADOS"); 
            }else{
                System.out.println("ERROR EN ELIMINAR HORARIOS ASIGNADOS"); 
            }
        }finally{
            if(preparedS != null){
                Conexion.Cerrar(preparedS);
                
            }if(connect != null){
                Conexion.Cerrar(connect);
            }
        try{
            connect = Conexion.getConexion();
            preparedS = Conexion.getPreparedStatement(sql);
            preparedS.setString(1, medico.getIdmedico());
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
        }
        return aux;
    }
    
        public int EliminarMedicoHorarios(Medico medico) throws SQLException{
        int aux;
        String sql1 = "DELETE FROM horarios WHERE idmedico = ?";
        try{
            connect = Conexion.getConexion();
            preparedS = Conexion.getPreparedStatement(sql1);
            preparedS.setString(1, medico.getIdmedico());
            aux = preparedS.executeUpdate();
            if(aux > 0){
                System.out.println("HORARIOS ASIGNADOS ELIMINADOS");
                JOptionPane.showMessageDialog(null, "Todos los horarios asignados se borraron con exito","Citas Médicas",
                        JOptionPane.INFORMATION_MESSAGE); 
            }else{
                JOptionPane.showMessageDialog(null, "No existe el médico o no tiene horarios asignados","Citas Médicas",
                        JOptionPane.ERROR_MESSAGE); 
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
    
    public void BuscarMedico(JTable tabla, String aux) throws SQLException{
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Médico");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especidalidad");
        modelo.addColumn("Teléfono");
        try {
            String sql = "SELECT idmedico, apellido, nombre, especialidad, telefono FROM medico WHERE nombre LIKE '%"+aux+"%'";
            connect = Conexion.getConexion();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            String filas[] = new String[5];
            while(resultset.next()){
                filas[0] = resultset.getString(1);
                filas[1] = resultset.getString(2);
                filas[2] = resultset.getString(3);
                filas[3] = resultset.getString(4);
                filas[4] = resultset.getString(5);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
            Conexion.Cerrar(connect);
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
    
    public static ArrayList<String> ComboBoxEspecialidades(){
        ArrayList<String> especialidad = new ArrayList<String>();
        String sql = "SELECT Especialidad FROM especialidades";
        try {
            resultset = Conexion.getResultSet(sql);
            while (resultset.next()) {
                especialidad.add(resultset.getString("Especialidad"));
            }
            Conexion.Cerrar(connect);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return especialidad;
    }
    
}
