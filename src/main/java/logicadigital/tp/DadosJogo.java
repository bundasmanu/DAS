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
public class DadosJogo {
    
    private Session sessao=null;
    /*LOGICA DO JOGO CHAMADA AQUI*/
    private CRUDUtilizador crudUtil;
    
    public DadosJogo(){
        
    }
    
    public Session getSessao(){
        
        if(sessao==null){
            return sessao=new Session();
        }
        
        return sessao;
    }
    
    public CRUDUtilizador getCRUDUtil(){
        if(this.crudUtil==null){
            return crudUtil=new CRUDUtilizador();
        }
        
        return crudUtil;
    }
    
}