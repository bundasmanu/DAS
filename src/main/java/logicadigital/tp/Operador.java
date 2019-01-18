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
public class Operador {
    
    List<Input> inputs;
    List<Output> outputs;
    List<Operador> operadores;
    
    public Operador(){
        this.inputs=new ArrayList<Input>();
        this.outputs=new ArrayList<Output>();
        this.operadores=new ArrayList<Operador>();
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public List<Operador> getOperadores() {
        return operadores;
    }

    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public void setOperadores(List<Operador> operadores) {
        this.operadores = operadores;
    }
    
    @Override
    public String toString(){

        return "\noperador\n";
    }
    
}
