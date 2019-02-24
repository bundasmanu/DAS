/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

/**
 *
 * @author Armando
 */
public class LerBIN implements EstrategiaLerFicheiro{
    
   
    @Override
    public boolean lerFicheiro(DadosJogo d, String name){
        
        try{
            
            return true;
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    
}
