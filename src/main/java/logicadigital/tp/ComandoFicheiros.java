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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 */
public class ComandoFicheiros {

    Modulo modulo;
    //FicheiroBLIF ficheiro_blif;
    Randomm random = new Randomm();

    public ComandoFicheiros() {
    }

//    public boolean CriaFicheiroBlifCasoNaoExista() {
//        try {
//            File ficheiro = new File("ficheiro.blif");
//            if (ficheiro.createNewFile()) {
//                System.out.println("Ficheiro é criado");
//            } else {
//                System.out.println("Ficheiro ja existe");
//            }
//            return true;
//        } catch (Exception e) {
//            System.out.println("" + e.getMessage());
//            return false;
//        }
//
//    }

    public boolean escreverComandoParaFicheiroBlif(String comando) throws IOException {
        try {
            //com o true é possivel fazer o append do ficheiro,acrescentar info ao mesmo
            //nunca substituindo o ficheiro
            
                FileWriter writer = new FileWriter("ficheiro.blif", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                bufferedWriter.write(comando);
                bufferedWriter.newLine();
                bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            return false;
        }
        return true;
    }

    //comando .model + nome gerado aleatoriamente no modulo
    public   String executaComandoModulo() throws IOException {
        String str = "";
        str = ".model " + this.geraStringAleatorioParaNomeModulo();
        boolean estado_escrever_comando_modulo= this.escreverComandoParaFicheiroBlif(str);
        System.out.println("Flag escrever_comando_modulo:"+estado_escrever_comando_modulo);
        return str;
    }

    public String executaComandoInput(List<String> lista_strings) throws IOException {
        String str = ".inputs ";
        for(String input: lista_strings){
            str+=""+input+"\t";
        }
        
        boolean estado_escrever_comando_input= this.escreverComandoParaFicheiroBlif(str);
        System.out.println("Flag escrever_comando_input:"+estado_escrever_comando_input);
        return str;
    }

    public String executaComandoOutput(String output) throws IOException {
        String str = "";
        str = ".outputs " + output;
         boolean estado_escrever_comando_output= this.escreverComandoParaFicheiroBlif(str);
        System.out.println("Flag escrever_comando_output:"+estado_escrever_comando_output);
        return str;
    }

    public String executaComandoEnd() throws IOException {
        String str = "";
        str = ".end";
        boolean estado_escrever_comando_end= this.escreverComandoParaFicheiroBlif(str);
        System.out.println("Flag escrever_comando_end:" +estado_escrever_comando_end);
        return str;
    }

    public String geraStringAleatorioParaNomeModulo() {
        return random.generateRandomString();
    }

}
