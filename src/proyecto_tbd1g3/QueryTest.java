/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_tbd1g3;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


/**
 *
 * @author dfcm9
 */
public class QueryTest {
    
    public void TestaQuery(){
        AdminDB bd = new AdminDB();
        //bd.Conectarme();
        //Prueba de Conexion Java-PgAdmin-AWS
        bd.Ingreso("create table classroom(\n" +
                    "building varchar(15),\n" +
                    "room_number int,\n" +
                    "capacity int,\n" +
                    "primary key (building, room_number));");
    }
    
    
    
    
}
