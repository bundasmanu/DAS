/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.util.List;
import static logicadigital.tp.Opcao.AND;
import static logicadigital.tp.Opcao.OR;

/**
 *
 * @author Armando
 */
public class ExecutaSimulacao { 
    
    private int id_modulo;
    
    public ExecutaSimulacao(int id_mod){
        this.id_modulo=id_mod;
    }
    
    public void make(DadosJogo d){
        this.realizaOperacaoModulo(d);
    }
    
    public void undo(DadosJogo d){
        this.retiraOperacaoModulo(d);
    }
    
    public void realizaOperacaoModulo(DadosJogo d){
        
        try{
            
            /*OBTENCAO DOS OPERADORES-->E REALIZACAO DAS RESPETIVAS OPERACOES*/
            List<Operador> operadores=d.getModulo(id_modulo).getOperador();
            
            if(operadores.isEmpty()==true){/*NAO PRECISAVA JA ESTOU A VERIFICAR DENTRO DAS FUNCOES INVOCADAS, MAS PRONTO*/
                return;
            }
            
            for(Operador x : operadores){
                if(x.getQual()==AND){
                    boolean correu_bem=x.realizaAND();//-->MUDAR O NOME DO METODO PARA REALIZAR MODULO DE SIMULACAO
                }
                if(x.getQual()==OR){
                    boolean correu=x.realizaAND();//-->MUDAR O NOME DO METODO PARA REALIZAR MODULO DE SIMULACAO
                }
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public void retiraOperacaoModulo(DadosJogo d){
        
        try{
            
            /**/
            Modulo m= d.getModulo(id_modulo);
            
            if(m==null){
                return;
            }
            
            /*RETIRAR VALORES BINARIOS DOS OUTPUTS*/
            for(Output x : m.getOutputs()){
                x.setBinario(-1);/*COLOCA VALOR A -1--> DEPOIS QUANDO SE FAZ O LISTA DOS MODULOS DEPOIS DE FAZER O UNDO, TER EM CONTA QUE -1 SIGNIFICA QUE NAO ESTA ATRIBUIDO*/
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
