
package Negocio;

import Vista.JFLogin;
import com.formdev.flatlaf.FlatLightLaf;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal {
    
    public static void main(String[] args) throws SQLException, UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new WindowsLookAndFeel()); 
        JFLogin jflogin = new JFLogin();
        jflogin.setVisible(true);
        try{
            FlatLightLaf.setup();
        }catch(Exception e){
            System.err.print(e);
        }
    }
}
