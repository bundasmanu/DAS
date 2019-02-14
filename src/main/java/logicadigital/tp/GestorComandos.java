/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Armando
 */
public class GestorComandos {
    
    public List<Comando> redoList=new ArrayList<Comando>();
    public List<Comando> undoList=new ArrayList<Comando>();
    private DadosJogo dados;
    
    public GestorComandos(DadosJogo d){
        dados=d;
    }
    
    public void apply(Comando c){
        
        try{
            
            c.make(dados);
            redoList.clear();
            undoList.add(c);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public void undo(){
        
        try{
            
            if(undoList.isEmpty()) return;
            Comando ultimo=undoList.remove(undoList.size()-1);
            ultimo.undo(dados);
            redoList.add(ultimo);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
