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
public class ColocaInputOperador implements Comando{
    
    int id_modulo;
    int id_operador;
    int id_in;
    Input in;
    
    public ColocaInputOperador(int id_mod, int id_operador, int id_input){
        this.id_modulo=id_mod;
        this.id_operador=id_operador;
        this.id_in=id_input;
    }
    
    public void make(DadosJogo d){
        this.colocaInputOperador(d);
    }
    
    public void undo(DadosJogo d){
        this.retiraInputOperador(d);
    }
    
     public boolean colocaInputOperador(DadosJogo d){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=d.getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*CASO HAJA MODULO VERIFICAR, SE EXISTE O INPUT NO MODULO*/
            if(m.operador.isEmpty()==true){
                return false;
            }
            
            /*VERIFICA SE EXISTE AQUELE INPUT*/
            if(m.getInputs().isEmpty()==true){
                return false;
            }
            
            Input encontrou=null;
            for(Input x : m.getInputs()){
                if(x.getId_input()==id_in){
                    encontrou=x;
                }
            }
            
            if(encontrou==null){
                return false;
            }
            
            in=encontrou;/*REFERENCIA PARA O OBJETO IN*/
            /*CASO HAJAM DADOS INSERE VERIFICA SE EXISTE AQUELE OPERADOR DENTRO DO MODULO*/
            for(Operador x : m.getOperador()){
                if(x.getId_operador()==id_operador){
                    x.getInputs().add(encontrou);
                    return true;
                }
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
        return false;
    }
    
    /*OPERACAO UNDO DO INSERE INPUT OPERADOR*/
    public boolean retiraInputOperador(DadosJogo d){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=d.getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*VERIFICAR AGORA SE O OPERADOR AINDA EXISTE*/
            Operador op=null;
            for(Operador x : m.getOperador()){
                if(x.getId_operador()==id_operador){
                    op=x;
                }
            }
            
            if(op==null){
                return false;
            }
            
            /*RETIRAR O INPUT DO OPERADOR*/
            return op.getInputs().remove(in);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
}
