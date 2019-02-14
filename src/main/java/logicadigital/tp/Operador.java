/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.util.ArrayList;
import java.util.List;
import static logicadigital.tp.Opcao.AND;
import static logicadigital.tp.Opcao.OR;

/**
 *
 * @author Armando
 */

enum Opcao 
{ 
    AND, OR, XOR, NOR; 
}

public class Operador {
    
    int id_operador;
    private static int nextOperadorID = 1;
    
    /*PODE ESTAR LIGADO A QUALQUER UM DELES*/
    List<Input> inputs;
    List<Operador> operadores;
    List<Output> outputs;
    
    private Opcao qual;/*DEFINE SE É UM AND, OR , ETC*/
    
    public Operador(Opcao op){
        this.inputs=new ArrayList<Input>();
        this.operadores=new ArrayList<Operador>();
        this.outputs=new ArrayList<Output>();
        this.qual=op;
        this.id_operador=nextOperadorID;
        nextOperadorID++;
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public List<Operador> getOperadores() {
        return operadores;
    }

    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    public void setOperadores(List<Operador> operadores) {
        this.operadores = operadores;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public Opcao getQual() {
        return qual;
    }

    public void setQual(Opcao qual) {
        this.qual = qual;
    }
    
    public int calculaSomaInputs(){
        
        try{
            
            if(this.getInputs().isEmpty()==true){
                return -1;
            }
            
            /*CASO ESTEJA ENTAO LIGADO A MAIS DO QUE UM INPUT*/
            int x=this.getInputs().get(0).getBinario();
            for(Input w : this.getInputs().subList(1, this.getInputs().size())){
                    x= (x & w.getBinario()); 
            }

            return x;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        
    }
    
    public int calculaOrInputs(){
        
        try{
            
            if(this.inputs.isEmpty()==true){
                return -1;
            }
            
            int x=this.getInputs().get(0).getBinario();
            for(Input w : this.getInputs().subList(1, this.getInputs().size())){
                x= (x | w.getBinario());
            }
            
            return x;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        
    }
    
    /*SE FOR OPERADOR SOMA*/
    public boolean realizaAND(){
        
        try {
            
            /*VERIFICAR SE UM OPERADOR ESTA LIGADO A UM OPERADOR, OU A UM OUTPUT, OU A AMBOS*/
            /*if(this.getInputs().isEmpty()==true){
                return false;
            }*/
            
            if(this.outputs.isEmpty()==true && this.operadores.isEmpty()==true){
                return false;
            }
            
            /*CASO TENHA APENAS UM INPUT*/
            if(this.getInputs().size()==1){
                if(this.operadores.isEmpty()==false){
                    for(Operador x : this.operadores){
                        x.inputs.add(this.getInputs().get(0));
                    }
                }
                if(this.outputs.isEmpty()==false){
                    for(Output x : this.outputs){
                        x.setBinario(this.getInputs().get(0).getBinario());
                    }
                }
                return true;
            }
                        
            /*CASO AGORA ESTEJA LIGADO A UM OUTRO OPERADOR ENTAO, E NECESSARIO MEDIANTE OS SEUS INPUTS, COLOCAR O SOMATORIO NOS SEUS INPUTS*/
            if (this.getOperadores().isEmpty() == false) {
                for (Operador oe : this.getOperadores()) {
                    int soma_and_inputs = -1;
                    if (oe.qual == AND) {
                        soma_and_inputs = oe.calculaSomaInputs();
                    }
                    if (oe.qual == OR) {
                        soma_and_inputs = oe.calculaOrInputs();
                    }
                    if (soma_and_inputs != -1) {
                        this.getInputs().add(new Input(soma_and_inputs));
                    }
                }
            }
            
            /*CASO ESTEJA LIGADO A OUTPUT ENTAO FACO A ADICAO DE TODOS OS SEUS INPUTS E COLOCO O OUTPUT COM O VALOR DA SUA SOMA*/
            if(this.getOutputs().isEmpty()==false){
                /*EFETUAR O SOMATORIO DE TODOS OS INPUTS*/
                /*DEFINIR AGORA OS SEUS OUTPUTS COM O VALOR DE x*/
                for(Output o :  this.getOutputs()){
                    if(this.qual==AND){
                        o.setBinario(this.calculaSomaInputs());
                    }
                    if(this.qual==OR){
                        o.setBinario(this.calculaOrInputs());
                    }
                }
            }      
            
            return true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }

    public int getId_operador() {
        return id_operador;
    }

    public void setId_operador(int id_operador) {
        this.id_operador = id_operador;
    }
    
    @Override
    public String toString(){

        String info_operador="";
        
        info_operador+="\nOperador: "+this.getQual()+"\n";
        
        return info_operador;
    }
    
}
