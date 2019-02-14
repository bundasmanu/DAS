/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;



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
    
    @Override
    public int criaModulo(){
        return 0;
    }
    
    @Override
    public int insereInputModulo(int id, int bin){
        return 0;
    }
    
    @Override
    public int insereOperadorModulo(int id, Opcao op){
        return 0;
    }
    
    @Override
    public void realizaOperacaoModulo(int id){
        
    }
    
    @Override
    public boolean colocaInputOperador(int id_input, int id_modulo, int id_operador){
        return false;
    }
    
    @Override
    public int adicionaOutputAoModuloEOperador(int id_modulo, int id_operador){
        return -1;
    }
    
    @Override
    public boolean adicionaOperadorOutroOperador(int id_modulo,int id_Operador_Adicionar,int id_Operador_Receber){
        return false;
    }
    
    @Override
    public boolean setValOutput(int id_modulo, int id_output, int bin){
        return false;
    }
    
    @Override
    public String confirmaValoresOutput(int id_modulo){
        return "";
    }
    
    @Override
    public String listaModulo(int id){
        return "";
    }
    
    
    
}
