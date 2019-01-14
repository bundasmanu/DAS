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

        Scanner sc = new Scanner(System.in);
        Fachada fac = new Fachada();

        String nome = null;
        String passwords = null;
        String n = null;
        Connection conn = fac.getFachada().getSessao().getConnection();
        System.out.println("" + conn);
        CRUDUtilizador u = new CRUDUtilizador();

        System.out.println("--------MENU---------");
        System.out.println("1 - Insert Utilizador");
        System.out.println("2 - Update Utilizador");
        System.out.println("3 - Delete Utilizador");
        System.out.println("4 - Display Utilizador");
        while (n != "q") {
            n = sc.next();

            switch (n) {
                case "1":
                    System.out.println("Indique o nome:");
                    nome = sc.next();
                    System.out.println("Indique a password");
                    passwords = sc.next();

                    Boolean status = u.InsertUtilizador(conn, nome, passwords);
                    System.out.println("" + status);
                    break;
                case "2":
                    System.out.println("Indique o nome:");
                    nome = sc.next();
                    System.out.println("Indique a password");
                    passwords = sc.next();

                    u.UpdateUtilizador(conn, nome, passwords);
                    break;
                case "3":
                    System.out.println("Indique o nome a eliminar:");
                    nome = sc.next();
                    u.DeleteUtilizador(conn, nome);
                    break;
                case "4":
                    System.out.println("Indique o nome:");
                    nome = sc.next();
                    u.DisplayUtilizador(conn, nome);
                    break;
                case "q":
                    exit(0);
                    break;
                default:
                    System.out.println("Erro Switch");
                    break;
            }
        }

    }
}
