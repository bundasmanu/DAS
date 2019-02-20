/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Armando
 */

public class DadosJogo {
    
    private Session sessao=null;
    Utilizador utilizador= null;
    private static AdaptadorBIN adaptadorBIN=null;
    private static AdaptadorBLIF adaptadorBLIF=null;
    private List<Modulo> m;
    
    /*COLOCAR AQUI UM GESTOR DE COMANDOS*/
    GestorComandos com= null;
    
    public DadosJogo(){
        this.m=new ArrayList<Modulo>();
        this.com=new GestorComandos(this);
    }

    public AdaptadorBIN getAdaptadorBIN(String name_file) {
        if(adaptadorBIN==null){
            return adaptadorBIN=new AdaptadorBIN(this,name_file);
        }
        return adaptadorBIN;
    }

    public void setAdaptadorBIN(AdaptadorBIN adaptadorBIN) {
        this.adaptadorBIN = adaptadorBIN;
    }

    public AdaptadorBLIF getAdaptadorBLIF(String name_file) {
         if(adaptadorBIN==null){
            return adaptadorBLIF= new AdaptadorBLIF(this,name_file);
        }
         return adaptadorBLIF;
       
    }

    public void setAdaptadorBLIF(AdaptadorBLIF adaptadorBLIF) {
        this.adaptadorBLIF = adaptadorBLIF;
    }

    public GestorComandos getCom() {
        return com;
    }

    public Utilizador getUtilizador() {
        
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        
        this.utilizador = utilizador;
    }

    public List<Modulo> getM() {
        return m;
    }

    public void setM(List<Modulo> m) {
        this.m = m;
    }

    
    
    public void setCom(GestorComandos com) {
        this.com = com;
    }
    
    public Session getSessao(){
        
        if(sessao==null){
            return sessao=new Session();
        }
        
        return sessao;
    }

    public List<Modulo> getListaModulo() {
        return m;
    }

    public void setListaModulo(List<Modulo> m) {
        this.m = m;
    }
    
    public Modulo getModulo(int id){ /*QUANDO SELECCIONA O MODULO*/
        
        for(Modulo x : this.m){
            if(x.getId_modulo()==id){
                return x;
            }
        }
        
        return null;
    }
    
    public int criaModulo(){
        Modulo mo=new Modulo();
        int x=mo.getId_modulo();
        this.m.add(mo);
        return x;
    }
    
    public boolean removeModulo(int id){
        
        for(Modulo x : this.m){
            if(x.getId_modulo()==id){
                return this.m.remove(x);
            }
        }
        
        return false;
    }
    
    public boolean limpaTudoDadosJogo(){
        
        try{
            
            /*LIMPA TODOS OS DADOS QUE SE ENCONTRAM NO "JOGO" (DADOSJOGO)*/
            this.com=null;
            this.m=null;
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }
    
}
