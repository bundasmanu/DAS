/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Ola mundo");
        System.out.println("oi");
        System.out.println("ok zes");
        System.out.println("ola");

        /*TESTE A UM MODULO*/
        Modulo x = new Modulo();
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
        System.out.println(x.toString());
        /*CHAMADA AO MENU PRINCIPAL*/
 /*MenuInicial m= new MenuInicial();   
        m.setVisible(true);*/

    }
}
