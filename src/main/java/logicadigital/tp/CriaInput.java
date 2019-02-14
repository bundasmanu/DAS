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
public class CriaInput implements Comando{

    Input in;
    int id_modulo;
    int valor_bin_passar;
    
    public CriaInput(int id_mod, int bin){
        this.id_modulo=id_mod;
        this.valor_bin_passar=bin;
    }
    
    public void make(DadosJogo d){
        this.insereInputModulo(d);
    }
    
    public void undo(DadosJogo d){
        this.removeInputModulo(d);
    }

    public int insereInputModulo(DadosJogo d){/*SELECCIONAR PRIMEIRO QUAL O MODULO (ID), DEPOIS VER ISSO*/
        
        try{
            in=new Input(valor_bin_passar);
            d.getModulo(id_modulo).getInputs().add(in);
            return in.getId_input();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
        
    }
    
    /*UNDO DA OPERACAO INSERE OUTPUT NO MODULO*/
    public boolean removeInputModulo(DadosJogo d){/*QUANDO INSIRO O INPUT NO MODULO, UMA VARIAVEL INPUT IRA TER A REFERENCIA DA VARIAVEL INPUT INSTANCIADA NO MODULO*/
        
        try{
          
            Modulo m=d.getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            boolean retorno_input=m.getInputs().contains(in);
            if(retorno_input==true){
                m.getInputs().remove(in); /*ID IGUAL A POSICAO -1*/
            }
            else{
                return false;
            }
            
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
}
