/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_tbd1g3;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author dfcm9
 */
public class AdminDB {
    Connection conexion = null;
    String pass = "DiegoDanielHectorJunnior";
    String user = "postgres";
    String url = "jdbc:postgresql://databasetbd1.cekxuyqsjfnw.us-east-1.rds.amazonaws.com:5432/pruebaG3";
    
    public void Conectarme(){
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            //JOptionPane.showMessageDialog(null, "Conectado exitosamente.\n"
                    //+ "Cargando Datos...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en Conectarme");
            ex.printStackTrace();
        }
    }
    
    public void Ingreso(String script){
        PreparedStatement p = null;
        Conectarme();
        try {
            p = conexion.prepareStatement(script);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ejecucion de consulta completa.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en ingreso");
            ex.printStackTrace();
        }
    }
    
    public ResultSet ReturnResultSet(String script){
        PreparedStatement pst = null;
        ResultSet rst = null;
        Conectarme();
        
        try {
            pst = conexion.prepareStatement(script);
            rst = pst.executeQuery();
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return rst;
    }
    
}
