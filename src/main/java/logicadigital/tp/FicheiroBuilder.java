/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

/**
 *
 * @author carlo
 */
public abstract class FicheiroBuilder {
    //retorna o tipo de ficheiro builder
    public static FicheiroBuilder getFicheiroBuilder(String tipo_ficheiro_builder){
        if(tipo_ficheiro_builder.equals("BuilderBLIF")){
            return new BuilderBLIF();
        }
        else if(tipo_ficheiro_builder.equals("BuilderBIN")){
            return new BuilderBIN();
        }
        return null;
    }
    public abstract boolean exportaFicheiro();
    public abstract boolean gravaFicheiro();
    
}
