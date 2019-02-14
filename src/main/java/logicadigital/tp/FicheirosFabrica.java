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
    public  AbstractFactory getTipoFicheiros(String tipo_ficheiros){
        if(tipo_ficheiros==null){
            return null;
        }
        if(tipo_ficheiros.equalsIgnoreCase("BLIF")){
            return new FicheiroBLIF();
        }
        else if(tipo_ficheiros.equalsIgnoreCase("BIN")){
            return new FicheiroBIN();
        }
        return null;
    }
}
