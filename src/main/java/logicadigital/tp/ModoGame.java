/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.util.ArrayList;
import java.util.List;
import static logicadigital.tp.Opcao.AND;
import static logicadigital.tp.Opcao.OR;

/**
 *
 * @author Armando
 */
public class ModoGame extends EstadoAdapter{
    
    public ModoGame(DadosJogo d){
        super(d);
    }
    
    @Override
    public int criaModulo(){
        
        try{            
            return super.getDadosJogo().criaModulo();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        } 
        
        return 1;
    }
    
    /*UNDO DO CRIA MODULO*/
    public void removeModulo(int id_modulo){
        
        try{
            super.getDadosJogo().removeModulo(id_modulo);/*ATENCAO QUE CASO FACO UM REMOVE DO MODULO, */
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    @Override
    public int insereInputModulo(int id_modulo, int bin){/*SELECCIONAR PRIMEIRO QUAL O MODULO (ID), DEPOIS VER ISSO*/
        
        try{
            Input in=new Input(bin);
            super.getDadosJogo().getModulo(id_modulo).getInputs().add(in);
            return in.getId_input();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
        
    }
    
    /*UNDO DA OPERACAO INSERE OUTPUT NO MODULO*/
    public boolean removeInputModulo(int id_modulo, Input passar_input){/*QUANDO INSIRO O INPUT NO MODULO, UMA VARIAVEL INPUT IRA TER A REFERENCIA DA VARIAVEL INPUT INSTANCIADA NO MODULO*/
        
        try{
          
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            boolean retorno_input=m.getInputs().contains(passar_input);
            if(retorno_input==true){
                m.getInputs().remove(passar_input); /*ID IGUAL A POSICAO -1*/
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
    
    
    @Override
    public int insereOperadorModulo(int id, Opcao op){
        
        try{
            
            Operador op1=new Operador(op);
            super.getDadosJogo().getModulo(id).getOperador().add(op1);
            return op1.getId_operador();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
        
    }
    
    /*OPERACAO UNDO RELATIVA AO INSERE OPERADOR NUM DETERMINADO MODULO*/
    public boolean retiraOperadorModulo(int id_modulo, Operador op){ /*É PASSADA UMA REFERENCIA PARA O OPERADOR QUE FOI ADICIONADO AO MODULO*/
        
        try{
            
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            m.getOperador().remove(op);

            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    @Override
    public boolean colocaInputOperador(int id_input, int id_modulo, int id_operador){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            
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
                if(x.getId_input()==id_input){
                    encontrou=x;
                }
            }
            
            if(encontrou==null){
                return false;
            }
            
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
    public boolean retiraInputOperador(int id_modulo, int id_operador, Input in){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            
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
    
    @Override
    public int adicionaOutputAoModuloEOperador(int id_modulo, int id_operador){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            
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
    public boolean retiraOutputAoModuloEOperador(int id_modulo, int id_operador, Output out){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*VERIFICAR SE EXISTE O OPERADOR*/
            for(Operador x : m.getOperador()){
                if(x.getId_operador()==id_operador){
                    m.getOutputs().remove(out);//-->BASTA REMOVER DE UM DOS LADOS, POIS A REFERENCIA É A MESMA. MAS DPS CONFIRMAR
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
    
    @Override
    public boolean adicionaOperadorOutroOperador(int id_modulo,int id_Operador_Adicionar,int id_Operador_Receber){
        
        try{
            
            /*NECESSÁRIO VERIFICAR SE AMBOS OS OPERADORES JÁ SE ENCONTRAM NO MODULO*/
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*VERIFICAR AGORA SE AMBOS OS OPERADORES EXISTEM, CASO EXISTAM, E POSSIVEL EFETUAR O PEDIDO*/
            List<Operador> operadores_no_modulo=m.getOperador();
            
            if(operadores_no_modulo.isEmpty()==true){
                return false;
            }
            
            int existe=0;
            Operador op_rec=null;
            Operador op_ad=null;
            for(Operador x : operadores_no_modulo){
                if(x.getId_operador()==id_Operador_Receber){
                    existe++;
                    op_rec=x;
                }
                if(x.getId_operador()==id_Operador_Adicionar){
                    existe++;
                    op_ad=x;
                }
            }
            
            /*VERIFICAR SE AMBOS EXISTEM*/
            if(existe==2 && op_rec!=null && op_ad!=null){
                op_rec.getOperadores().add(op_ad);
            }
            
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    /*REALIZA UNDO ADICIONA OPERADOR A OUTRO OPERADOR*/
    public boolean retiraOperadorOutroOperador(int id_modulo,int id_operador_recebeu,Operador retirar){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*VERIFICAR SE AMBOS OS OPERADORES EXISTEM NO MODULO*/
            Operador recebeu=null;
            Operador adicionado=null;
            for(Operador x : m.getOperador()){
                if(x.getId_operador()==id_operador_recebeu){
                    recebeu=x;
                }
                if(x.getId_operador()==retirar.getId_operador()){
                    adicionado=x;
                }
            }
            
            if(recebeu!=null && adicionado!=null){
                recebeu.getOperadores().remove(adicionado);
                return true;
            }
            
            return false;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    @Override
    public void realizaOperacaoModulo(int id){
        
        try{
            
            /*OBTENCAO DOS OPERADORES-->E REALIZACAO DAS RESPETIVAS OPERACOES*/
            List<Operador> operadores=super.getDadosJogo().getModulo(id).getOperador();
            
            if(operadores.isEmpty()==true){/*NAO PRECISAVA JA ESTOU A VERIFICAR DENTRO DAS FUNCOES INVOCADAS, MAS PRONTO*/
                return;
            }
            
            for(Operador x : operadores){
                if(x.getQual()==AND){
                    boolean correu_bem=x.realizaAND();
                }
                if(x.getQual()==OR){
                    boolean correu=x.realizaAND();
                }
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    @Override
    public boolean setValOutput(int id_modulo, int id_output, int bin){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*VERIFICAR SE EXISTE AQUELE OUTPUT NO MODULO*/
            int existe=0;
            for(Output x : m.getOutputs()){
                if(x.getId_input()==id_output){
                    existe++;
                    x.setBinario(bin);
                    break;
                }
            }
            
            if(existe==0){ /*SE NAO ENCONTROU O ID DO OUTPUT*/
                return false;
            }
            
            
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    @Override
    public String confirmaValoresOutput(int id_modulo){
        
        try{
            
            /*VERIFICA SE O MODULO EXISTE*/
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            if(m==null){
                return "\nProblema, nao existe o modulo\n";
            }
            
            if(m.getOutputs().isEmpty()==true){
                return "\nNao existem outputs associados ao Modulo\n";
            }
            
            /*INICIALIZAR A LISTA DE OUTPUTS TEMPORARIA, DE MODO A COMPARAR COM OS NOVOS DADOS DA SIMULACAO*/
            List<Output> lista_temporaria_outputs=new ArrayList<Output>();
            for(Output x : m.getOutputs()){
                lista_temporaria_outputs.add(new Output(x.getBinario()));
            }
            
            /*CHAMA OPERADOR DE REALIZAR DE TODA A SIIMULACAO DO MODULO*/
            this.realizaOperacaoModulo(m.getId_modulo());

            String info_bateu_certo="";
            for(int i=0;i<m.getOutputs().size();++i){
                if(m.getOutputs().get(i).getBinario()==lista_temporaria_outputs.get(i).getBinario()){
                    info_bateu_certo+="\nResultado igual ao indicado\n";
                }
                else{
                    info_bateu_certo+="\nResultado diferente ao indicado\n";
                }
            }
            
            return info_bateu_certo;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
        
    }
    
    @Override
    public String listaModulo(int id){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo x=super.getDadosJogo().getModulo(id);
            
            if(x==null){
                return "";
            }
            
            return x.toString();
            
        }
        catch(Exception e){
            return "";
        }
        
        
    }
    
}
