/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class AdaptadorBIN extends Ficheiro {

    static FicheiroBIN ficheiroBIN = null;

    public AdaptadorBIN() {

    }

    public static FicheiroBIN getFicheiroBIN() {
        if (ficheiroBIN == null) {
            return ficheiroBIN = new FicheiroBIN();
        }

        return ficheiroBIN;

    }



@Override
        public boolean LerFicheiro(Utilizador u) {
       try{
           return ficheiroBIN.ReadBinaryFile(u);
       } catch(Exception e){
           System.out.println(""+e.getMessage());
           return false;
       }
      
    }
    
}
