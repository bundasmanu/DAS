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

    private FicheiroBIN ficheiroBIN = null;
    private DadosJogo dj;
  

    public AdaptadorBIN(DadosJogo d, String nome) { /*TEM DE SE PASSAR POR PARAMETRO UM FICHEIRO*/
        ficheiroBIN= new FicheiroBIN();
        super.name_ficheiro=nome;
        dj=d;
       
    }

    public FicheiroBIN getFicheiroBIN() {
        return ficheiroBIN;
    }

    public void setFicheiroBIN(FicheiroBIN ficheiroBIN) {
        this.ficheiroBIN = ficheiroBIN;
    }

    public DadosJogo getDj() {
        return dj;
    }

    public void setDj(DadosJogo dj) {
        this.dj = dj;
    }

   
    @Override
    public boolean LerFicheiro() {
       try{
           return ficheiroBIN.ReadBinaryFile(dj, name_ficheiro);
       } catch(Exception e){
           System.out.println(""+e.getMessage());
           return false;
       }
      
    }
    
}
