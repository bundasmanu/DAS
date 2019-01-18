/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public class Modulo {
 
    List<Input> inputs;
    List<Output> outputs;
    List<Operador> operador;
    
    public Modulo(){
        this.inputs=new ArrayList<Input>();
        this.operador=new ArrayList<Operador>();
        this.outputs=new ArrayList<Output>();
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public List<Operador> getOperador() {
        return operador;
    }

    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public void setOperador(List<Operador> operador) {
        this.operador = operador;
    }
    
    @Override
    public String toString(){
        
        String info_Modulo="";
        
        for(Input x : this.inputs){
            info_Modulo+=x.toString();
        }
        
        for(Output y : this.outputs){
            info_Modulo+=y.toString();
        }
        
        for(Operador z : this.operador){
            info_Modulo+=z.toString();
        }
        
        return info_Modulo;
    }
    
}
