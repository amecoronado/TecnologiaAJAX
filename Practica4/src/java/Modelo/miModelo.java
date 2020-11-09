/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ame_coronado
 */
public class miModelo {
    Conexion cn;
    
    public miModelo(){
        cn = new Conexion();
    }
    
    public boolean valida(String password, String user){
        boolean estado= false;
        try{
            Connection cnt = cn.getConexion();
            String query= "select * from usuarios where password='"+password+"' and user='"+user+"'" ;
            System.out.println(query);
            Statement st = cnt.createStatement();
            ResultSet rs = st.executeQuery(query);
            estado = rs.next();
            cn.cierraConexion((com.mysql.cj.jdbc.JdbcConnection) cnt);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            return estado;
        }
    }
}
