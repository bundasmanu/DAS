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
public class LigaOutputInput implements Comando{
    
    private int id_modulo_Output;
    private int id_modulo_Input;
    private int id_output;
    private int id_input;
    
    public LigaOutputInput(int id_moduloOuput, int id_moduloInput, int id_out, int id_in){
        this.id_modulo_Output=id_moduloOuput;
        this.id_modulo_Input=id_moduloInput;
        this.id_output=id_out;
        this.id_input=id_in;
    }
    
    @Override
    public void make(DadosJogo d){
        this.setLigacaoOutputInput(d);
    }
    
    @Override
    public void undo(DadosJogo d){
        
    }
    
    public void setLigacaoOutputInput(DadosJogo d){
        
        try{
            
            /*VERIFICAR SE AMBOS OS MODULOS EXISTEM*/
            Modulo m_output=d.getModulo(id_modulo_Output);
            Modulo m_input=d.getModulo(id_modulo_Input);
            
            if(m_output!=null && m_input!=null){
                
                /*ESTABELECER A LIGACAO DO OUTPUT NO INPUT*/
                Output out=null;
                for(Output x : m_output.getOutputs()){
                    if(x.getId_input()==id_output){/*O NOME DA VARIAVEL ESTA TROCADO, NAO É NENHUM ENGANO*/
                        out=x;
                    }
                }
                
                if(out!=null){
                    
                    Input in=null;
                    for(Input x : m_input.getInputs()){
                        if(x.getId_input()==id_input){
                            in=x;
                        }
                    }
                    
                    if(in!=null){
                        
                        in.setOut(out);/*ESTABELECE A LIGACAO DO INPUT AO OPERADOR QUE ESTA NOUTRO MODULO*/
                        
                    }
                    
                }
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public void retiraLigacaoOutputInput(DadosJogo d){
        
        try{
            
            /*VERIFICAR SE AMBOS OS MODULOS EXISTEM*/
            Modulo m_output=d.getModulo(id_modulo_Output);
            Modulo m_input=d.getModulo(id_modulo_Input);
            
            if(m_output!=null && m_input!=null){
                
                /*ESTABELECER A LIGACAO DO OUTPUT NO INPUT*/
                Output out=null;
                for(Output x : m_output.getOutputs()){
                    if(x.getId_input()==id_output){/*O NOME DA VARIAVEL ESTA TROCADO, NAO É NENHUM ENGANO*/
                        out=x;
                    }
                }
                
                if(out!=null){
                    
                    Input in=null;
                    for(Input x : m_input.getInputs()){
                        if(x.getId_input()==id_input){
                            in=x;
                        }
                    }
                    
                    if(in!=null){
                        
                        in.setOut(null);/*COLOCA A LIGACAO A NULL, DPS CASO SEJA NECESSARIO COLOCAR UM VALOR NO OUTPUT, UTILIZAR A FUNCAO SETVAL DEFINIDA NA CLASSE MODOGAME*/
                        
                    }
                    
                }
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
