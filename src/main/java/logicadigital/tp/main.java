/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.IOException;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Ola mundo");
        System.out.println("oi");
        System.out.println("ok zes");
        System.out.println("ola");
       Scanner sc = new Scanner(System.in);

//        System.out.println("Introduza um nome");
//        String nome= sc.next();
//        System.out.println("Introduza a password");
//        String pass= sc.next();
//        CRUDUtilizador crud= new CRUDUtilizador();
//        boolean estado= crud.VerificaLogin(nome, pass);
//        System.out.println(""+estado);
        
        
               
        
        
        
        /*TESTE A UM MODULO*/
       /* Modulo x = new Modulo();
        Input x1 = new Input();
        Input x2 = new Input();
        Operador w = new Operador();
        x.getInputs().add(x1);
        x.getInputs().add(x2);
        x.getOperador().add(w);
        Output out = new Output();
        x.getOutputs().add(out);
        w.getOutputs().add(out);
        w.getInputs().add(x1);
        w.getInputs().add(x2);
        System.out.println(x.toString());*/
        /*CHAMADA AO MENU PRINCIPAL*/
        FicheirosFabrica ficheiro_fabrica = new FicheirosFabrica();
        AbstractFactory f= ficheiro_fabrica.getTipoFicheiros("BLIF");
        
        
     //parte referente aos ficheiros
//        ComandoFicheiros comando_ficheiros= new ComandoFicheiros();
//        String comando=comando_ficheiros.executaComandoModulo();
//        System.out.println(""+comando);
//        comando_ficheiros.escreverComandoParaFicheiroBlif(comando);
//        Input x1= new Input(0);
//        String comando_input= comando_ficheiros.executaComandoInput("A");
//        comando_ficheiros.escreverComandoParaFicheiroBlif(comando_input);
//        Output x2= new Output(1);
//        String comando_output= comando_ficheiros.executaComandoOutput(x2);
//        comando_ficheiros.escreverComandoParaFicheiroBlif(comando_output);
//        String comando_end= comando_ficheiros.executaComandoEnd();
//        comando_ficheiros.escreverComandoParaFicheiroBlif(comando_end);
        
        //f.ImportaFicheiro();
        //f.ExportaFicheiro();
        MenuInicial m= new MenuInicial();   
        m.setVisible(true);
        
        
        

    }
}
