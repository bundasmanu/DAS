/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author carlo
 */
public class ComandoFicheiros {
    Modulo modulo;
    FicheiroBLIF ficheiro_blif;
    Randomm random= new Randomm();
    public ComandoFicheiros() {
    }
    
    public boolean escreverComandoParaFicheiroBlif(String comando) throws IOException{
        try{
            //com o true é possivel fazer o append do ficheiro,acrescentar info ao mesmo
            //nunca substituindo o ficheiro
            
            FileWriter writer= new FileWriter("ficheiro.blif",true);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            
            bufferedWriter.write(comando);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch(Exception e){
            System.out.println(""+e.getMessage());
            return false;
        }
        return true;
    }
    
    //comando .model + nome gerado aleatoriamente no modulo
    public String executaComandoModulo(){
        String str="";
        str=".model "+ this.geraStringAleatorioParaNomeModulo();
        return str;
    }
    
    public String executaComandoInput(Input i){
        String str="";
        str=".inputs "+ i.getBinario();
        return str;    
    }
    
    public String executaComandoOutput(Output x){
        String str="";
        str=".outputs "+x.getBinario();
        return str;
    }
    
    public String executaComandoEnd(){
        String str="";
        str=".end";
        return str;
    }
    
    
    public String geraStringAleatorioParaNomeModulo(){
        return random.generateRandomString();
    }
    
    
}
