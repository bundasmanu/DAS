/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Armando
 */
public class Fachada {
    
    private Jogo j;
    private static Fachada f=null;
    public  Fachada(){
        this.j=new Jogo();
    }
    
    public static Fachada getFachada(){
        
        if(f==null){
            return f= new Fachada();
        }
        
        return f;
    }
  
    public Jogo getJogo(){
        return this.j;
    }
    
}
