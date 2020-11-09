/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.cj.jdbc.JdbcConnection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ame_coronado
 */
public class Conexion {
    private String driver;
    private String cadena;
    private String user;
    private String password;
    
    public Conexion(){
        driver="com.mysql.cj.jdbc.Driver";
        cadena="jdbc:mysql://127.0.0.1:3306/usuarios";
        user="yo";
        password="3141AmeBD";
    }
    
    public JdbcConnection getConexion() throws ClassNotFoundException{
        JdbcConnection cn;
        try{
            Class.forName(driver);
            cn = (JdbcConnection) DriverManager.getConnection(cadena, user, password);
            return cn;
        } catch (SQLException ex){
            System.out.println("error"+ ex);
            return null;
        }
    }
    
    public void cierraConexion(JdbcConnection cn){
        try{
            if(cn != null && !cn.isClosed()){
                cn.close();
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
