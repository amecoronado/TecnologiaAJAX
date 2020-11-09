/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author ame_coronado
 */
public class Bean {

    String nombre;
    String password;
    
    public void bean(){
     
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getContrasenia(){
        return this.password;
    }
    
    public void setContrasenia(String contrasenia){
        this.password=contrasenia;
    }
}