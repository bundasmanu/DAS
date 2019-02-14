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
public class CriaOutput {
    
    private int id_modulo;
    private int id_operador;
    Output outp;
    
    public CriaOutput(int id_mod, int id_op){
        this.id_modulo=id_mod;
        this.id_operador=id_op;
    }
    
    public void make(DadosJogo d){
        this.adicionaOutputAoModuloEOperador(d);
    }
    
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
            
            /*VERIFICAR SE EXISTE O OPERADOR-->SE EXISTIR ADICIONAR O OUTPUT AO OPERADOR*/
            List<Operador> lista_de_todos_operadores_modulo=m.getOperador();
            
            if(lista_de_todos_operadores_modulo.isEmpty()==true){
                return -1;
            }
            
            for(Operador x : m.getOperador()){
                if(x.getId_operador()==id_operador){
                    /*CRIO OUTPUT E ASSOCIO AO OPERADOR E AO MODULO*/
                    Output out=new Output(); 
                    outp=out;
                    m.getOutputs().add(out);
                    x.getOutputs().add(out);
                    return out.getId_input();
                }
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        
        return -1;
    }
    
    /*OPERACAO UNDO DO ADICIONA OUTPUT AO MODULO E OPERADOR*/
    public boolean retiraOutputAoModuloEOperador(DadosJogo d){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=d.getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*VERIFICAR SE EXISTE O OPERADOR*/
            for(Operador x : m.getOperador()){
                if(x.getId_operador()==id_operador){
                    m.getOutputs().remove(outp);//-->BASTA REMOVER DE UM DOS LADOS, POIS A REFERENCIA É A MESMA. MAS DPS CONFIRMAR
                    //x.getOutputs().remove(out);
                }
            }
            
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
}
