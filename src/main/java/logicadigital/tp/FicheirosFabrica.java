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
public class FicheirosFabrica {
    public static Ficheiro getTipoFicheiros(String tipo_ficheiros,DadosJogo d,String nome_file){
        if(tipo_ficheiros==null){
            return null;
        }
        if(tipo_ficheiros.equalsIgnoreCase("BLIF")){
            return new AdaptadorBLIF(d, nome_file);
        }
        else if(tipo_ficheiros.equalsIgnoreCase("BIN")){
            return new AdaptadorBIN(d, nome_file);
        }
        return null;
    }
}
