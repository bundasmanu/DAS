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
public class CriaModulo implements Comando{
    
    private int id_modulo;
    
    @Override
    public void make(DadosJogo d){
        this.criaModulo(d);
    }
    
    @Override
    public void undo(DadosJogo d){
        this.removeModulo(id_modulo, d);
    }
    
    public int criaModulo(DadosJogo d){
        
        try{            
            return d.criaModulo();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        } 
        
        return 1;
    }
    
    /*UNDO DO CRIA MODULO*/
    public void removeModulo(int id_modulo, DadosJogo d){
        
        try{
            d.removeModulo(id_modulo);/*ATENCAO QUE CASO FACO UM REMOVE DO MODULO, */
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
