/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

/**
 *
 * @author Armando
 */
public class Pessoa {
    
    String nome;
    String pass;
    
    public Pessoa(String n, String p){
        this.nome=n;
        this.pass=p;
    }

    public String getNome() {
        return nome;
    }

    public String getPass() {
        return pass;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    @Override
    public String toString(){
        
        String info_player="";
        
        info_player+=this.getNome()+"\t"+this.getPass()+"\n";
        
        return info_player;
    }
    
}
