/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.Serializable;

/**
 *
 * @author Stefan Loureiro
 */
public class Utilizador implements Serializable{
    
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
        String str = "ID: "+ this.id+"Nome: "+ this.nome+ "Password: "+this.password;
        return str;
    }
    
    
}
