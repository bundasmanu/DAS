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
public class LigaOperadorOperador implements Comando{
    
    private int id_modulo;
    private int id_operador_fornecer;
    private int id_operador_receber;
    
    public LigaOperadorOperador(int id_mod, int id_operador_f, int id_operador_r){
        this.id_modulo=id_mod;
        this.id_operador_fornecer=id_operador_f;
        this.id_operador_receber=id_operador_r;
    }
    
    public void make(DadosJogo d){
        this.adicionaOperadorOutroOperador(d);
    }
    
    public void undo(DadosJogo d){
        this.retiraOperadorOutroOperador(d);
    }
    
    public boolean adicionaOperadorOutroOperador(DadosJogo d){
        
        try{
            
            /*NECESSÁRIO VERIFICAR SE AMBOS OS OPERADORES JÁ SE ENCONTRAM NO MODULO*/
            Modulo m=d.getModulo(id_modulo);
            
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
                if(x.getId_operador()== id_operador_receber){
                    existe++;
                    op_rec=x;
                }
                if(x.getId_operador()==id_operador_fornecer){
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
    public boolean retiraOperadorOutroOperador(DadosJogo d){
        
        try{
            
            /*VERIFICAR SE O MODULO EXISTE*/
            Modulo m=d.getModulo(id_modulo);
            
            if(m==null){
                return false;
            }
            
            /*VERIFICAR SE AMBOS OS OPERADORES EXISTEM NO MODULO*/
            Operador recebeu=null;
            Operador adicionado=null;
            for(Operador x : m.getOperador()){
                if(x.getId_operador()==id_operador_receber){
                    recebeu=x;
                }
                if(x.getId_operador()==id_operador_fornecer){
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
    
}
