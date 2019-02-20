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
public class Input {
    
    int id_input;
    private static int nextInputID = 0;
    private int binario;
    
    public Input(int bin){
        this.id_input=nextInputID;
        nextInputID++;
        this.binario=bin;
    }

    public int getBinario() {
        return binario;
    }

    public void setBinario(int binario) {
        this.binario = binario;
    }

    public int getId_input() {
        return id_input;
    }

    public void setId_input(int id_input) {
        this.id_input = id_input;
    }
    
    @Override
    public int hashCode(){
        
        int hash=17;
        
        hash+=this.id_input;
        
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        
        if(obj==null){
            return false;
        }
        
        if(obj instanceof Input ==false){
            return false;
        }
        
        if(this==obj){
            return true;
        }
        
        Input inp= (Input) obj;
        
        if(this.id_input!=inp.getId_input()){
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString(){
        
        return this.getBinario()+"\n";
        
    }
    
}
