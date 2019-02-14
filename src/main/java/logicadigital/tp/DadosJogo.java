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
    
    private List<Modulo> m;
    
    /*COLOCAR AQUI UM GESTOR DE COMANDOS*/
    GestorComandos com= new GestorComandos(this);

    
    public DadosJogo(){
        this.m=new ArrayList<Modulo>();
    }

    public GestorComandos getCom() {
        return com;
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
    
}
