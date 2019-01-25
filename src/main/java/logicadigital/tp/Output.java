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
public class Output {
    
    private int binario;
    
    public Output(int bin){/*CONSTRUTOR CRIADO PARA EFETUAR A VERIFICACAO NOS TESTES*/
        this.binario=bin;
    }

    public Output(){
        
    }
    
    public int getBinario() {
        return binario;
    }

    public void setBinario(int binario) {
        this.binario = binario;
    }
    
    @Override
    public String toString(){
        
        return "\nOutput: "+this.binario+"\n";
        
    }
    
}
