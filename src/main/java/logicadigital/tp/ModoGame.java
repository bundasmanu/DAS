/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.util.List;
import static logicadigital.tp.Opcao.AND;

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
    
    @Override
    public int insereInputModulo(int id, int bin){/*SELECCIONAR PRIMEIRO QUAL O MODULO (ID), DEPOIS VER ISSO*/
        
        try{
            Input in=new Input(bin);
            super.getDadosJogo().getModulo(id).getInputs().add(in);
            return in.getId_input();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
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
    
    @Override
    public boolean adicionaOutputAoModuloEOperador(int id_modulo, int id_operador){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=super.getDadosJogo().getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*VERIFICAR SE EXISTE O OPERADOR-->SE EXISTIR ADICIONAR O OUTPUT AO OPERADOR*/
            List<Operador> lista_de_todos_operadores_modulo=m.getOperador();
            
            if(lista_de_todos_operadores_modulo.isEmpty()==true){
                return false;
            }
            
            for(Operador x : m.getOperador()){
                if(x.getId_operador()==id_operador){
                    /*CRIO OUTPUT E ASSOCIO AO OPERADOR E AO MODULO*/
                    Output out=new Output(); 
                    m.getOutputs().add(out);
                    x.getOutputs().add(out);
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
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
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
