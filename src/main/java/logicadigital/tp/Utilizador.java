/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

/**
 *
 * @author Stefan Loureiro
 */
public class Utilizador {
    
    public static int id;
    public String nome;
    public String password;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Utilizador.id = id;
    }

    public Utilizador(String nome, String passwords) {
      this.nome = nome;
      this.password = passwords;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString() {
        String str = "";
        System.out.println(" Id do user: " + this.id + " Nome do user: " + this.nome + "Pass do user: " + this.password);
        return str;
    }
    
    
}
