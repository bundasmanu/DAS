/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class AdaptadorBLIF extends Ficheiro{
    //instancia do tipo blif
    static FicheiroBLIF ficheiroBLIF= null;
    public AdaptadorBLIF() {
    }
    
    public static FicheiroBLIF getFicheiroBLIF(){
        if(ficheiroBLIF==null){
            return ficheiroBLIF= new FicheiroBLIF();
        }
        return ficheiroBLIF;
    }

    @Override
    public boolean LerFicheiro(Utilizador  u) {
        try {
            return ficheiroBLIF.LerFicheiroBlif();
        } catch (IOException ex) {
            System.out.println(""+ex.getMessage());
          return false;
        }
    }
    }
     
    


