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
public class CriaOperador implements Comando{
    
    int id_modulo;
    Opcao op;
    Operador operador_criado;
    
    public CriaOperador(int id_mod, Opcao operador_opcao){
        this.id_modulo=id_mod;
        this.op=operador_opcao;
    }
    
    public void make(DadosJogo d){
        this.insereOperadorModulo(d);
    }
    
    public void undo(DadosJogo d){
        this.retiraOperadorModulo(d);
    }
    
    public int insereOperadorModulo(DadosJogo d){
        
        try{
            
            operador_criado=new Operador(op);
            d.getModulo(id_modulo).getOperador().add(operador_criado);
            return operador_criado.getId_operador();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
        
    }
    
    /*OPERACAO UNDO RELATIVA AO INSERE OPERADOR NUM DETERMINADO MODULO*/
    public boolean retiraOperadorModulo(DadosJogo d){ /*É PASSADA UMA REFERENCIA PARA O OPERADOR QUE FOI ADICIONADO AO MODULO*/
        
        try{
            
            Modulo m=d.getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            m.getOperador().remove(operador_criado);

            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
}
