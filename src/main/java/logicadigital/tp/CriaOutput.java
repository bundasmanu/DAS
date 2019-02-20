/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.util.List;

/**
 *
 * @author Armando
 */
public class CriaOutput implements Comando{
    
    private int id_modulo;
    Output outp;
    
    public CriaOutput(int id_mod){
        this.id_modulo=id_mod;
    }
    
    @Override
    public void make(DadosJogo d){
        this.adicionaOutputAoModuloEOperador(d);
    }
    
    @Override
    public void undo(DadosJogo d){
        this.retiraOutputAoModuloEOperador(d);
    }
    
    public int adicionaOutputAoModuloEOperador(DadosJogo d){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=d.getModulo(id_modulo);
            
            if(m==null){
                return -1;
            }

            Output out=new Output(); 
            outp=out;
            m.getOutputs().add(out);
            return out.getId_input();
                   
        }    
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        
    }
    
    /*OPERACAO UNDO DO ADICIONA OUTPUT AO MODULO E OPERADOR*/
    public boolean retiraOutputAoModuloEOperador(DadosJogo d){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=d.getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            m.getOutputs().remove(outp);//-->BASTA REMOVER DE UM DOS LADOS, POIS A REFERENCIA É A MESMA. MAS DPS CONFIRMAR

            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
}
