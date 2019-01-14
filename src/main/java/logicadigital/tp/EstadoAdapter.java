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
public abstract class EstadoAdapter implements IEstados {
 
    private DadosJogo d;
    
    public EstadoAdapter(DadosJogo dj){
        this.d=dj;
    }

    public DadosJogo getDadosJogo() {
        return d;
    }

    public void setDadosJogo(DadosJogo d) {
        this.d = d;
    }
    
    @Override
    public IEstados registo(String n, String p){
        return this;
    }
    
    @Override
    public IEstados login(String n, String p){
        return this;
    }
    
    @Override
    public IEstados aplica_registo(){
        return this;
    }
    
    @Override
    public IEstados aplica_login(){
        return this;
    }
    
    @Override
    public IEstados voltar(){
        return this;
    }
}
