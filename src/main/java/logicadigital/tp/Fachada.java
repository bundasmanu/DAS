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
    
    private Session sessao=null;
    
    public Fachada(){
        
    }
    
    public Fachada getFachada(){
        
        if(this==null){
            return new Fachada();
        }
        
        return this;
    }
    
    public Session getSessao(){
        
        if(sessao==null){
            return new Session();
        }
        
        return sessao;
    }
    
}
