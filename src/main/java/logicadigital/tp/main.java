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
    public static void main(String[]args) throws ClassNotFoundException, SQLException{
        System.out.println("Ola mundo");
        System.out.println("oi");
        System.out.println("ok zes");System.out.println("ola");
        
        /*CHAMADA AO MENU PRINCIPAL*/
        MenuInicial m= new MenuInicial();   
        m.setVisible(true);
        
//        /*chamada ao form do registo do user*/
//        RegisterForm f= new RegisterForm();
//        f.setVisible(true);
    }
}
