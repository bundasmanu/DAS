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
public class LigaOperadorOutput implements Comando{
    
    private int id_modulo;
    private int id_operador;
    private int id_output;
    private Output out=null;
    
    public LigaOperadorOutput(int id_mod, int id_op, int id_out){
        this.id_modulo=id_mod;
        this.id_operador=id_op;
        this.id_output=id_out;
    }
    
    @Override
    public void make(DadosJogo d){
        this.adicionaOutputAoOperador(d);
    }
    
    @Override
    public void undo(DadosJogo d){
        this.retiraOutputAoOperador(d);
    }
    
    public boolean adicionaOutputAoOperador(DadosJogo d){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=d.getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*VERIFICAR SE EXISTE O OPERADOR-->SE EXISTIR ADICIONAR O OUTPUT AO OPERADOR*/
            List<Operador> lista_de_todos_operadores_modulo=m.getOperador();
            
            if(lista_de_todos_operadores_modulo.isEmpty()==true){
                return false;
            }
            
            Operador op=null;
            for(Operador x : m.getOperador()){
                if(x.getId_operador()==id_operador){
                    op=x;
                }
            }
            
            if(op==null){
                return false;
            }
            
            Output outx=null;
            for(Output x : m.getOutputs()){
                if(x.getId_input()==id_output){
                    outx=x;
                }
            }
            
            if(outx==null){
                return false;
            }
            
            op.getOutputs().add(outx);
            this.out=outx;
            return true;
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean retiraOutputAoOperador(DadosJogo d){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=d.getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*VERIFICAR SE EXISTE O OPERADOR-->SE EXISTIR ADICIONAR O OUTPUT AO OPERADOR*/
            List<Operador> lista_de_todos_operadores_modulo=m.getOperador();
            
            if(lista_de_todos_operadores_modulo.isEmpty()==true){
                return false;
            }
            
            Operador op=null;
            for(Operador x : m.getOperador()){
                if(x.getId_operador()==id_operador){
                    op=x;
                }
            }
            
            if(op==null){
                return false;
            }
            
            op.getOutputs().remove(this.out);
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
}
