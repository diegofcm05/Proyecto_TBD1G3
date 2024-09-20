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
    //Variables globales de la clase administradora de la conexion Java-PgAdmin-AWS
    Connection conexion = null;
    String pass = "DiegoDanielHectorJunnior";
    String user = "postgres";
    String url = "jdbc:postgresql://databasetbd1.cekxuyqsjfnw.us-east-1.rds.amazonaws.com:5432/pruebaG3";
    
    //Metodo para conectarse a la base de datos
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
    
    //Metodo para ingresar una consulta dentro de la base de datos
    public void Ingreso(String script){
        PreparedStatement p = null;
        Conectarme();
        try {
            p = conexion.prepareStatement(script);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Accion completada.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en la consulta.\n"+ex.getMessage());
            
            //ex.printStackTrace();
        }
    }
    
    
    //Metodo que retorna un set de resultados en base a una consulta
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
