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
    
    public Fachada(){
        this.j=new Jogo();
    }
    
    public Fachada getFachada(){
        
        if(this==null){
            return new Fachada();
        }
        
        return this;
    }
  
    public Jogo getJogo(){
        return this.j;
    }
    
}
