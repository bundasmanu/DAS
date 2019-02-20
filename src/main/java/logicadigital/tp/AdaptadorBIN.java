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
    private EstrategiaLerFicheiro eLer;

    public AdaptadorBIN(DadosJogo d, String nome) { /*TEM DE SE PASSAR POR PARAMETRO UM FICHEIRO*/
        ficheiroBIN= new FicheiroBIN();
        super.name_ficheiro=nome;
        dj=d;
        eLer=new LerBIN();
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

    public EstrategiaLerFicheiro geteLer() {
        return eLer;
    }

    public void seteLer(EstrategiaLerFicheiro eLer) {
        this.eLer = eLer;
    }
    
    @Override
    public boolean LerFicheiro() {
       try{
           return eLer.lerFicheiro(this.getDj(), this.name_ficheiro);
       } catch(Exception e){
           System.out.println(""+e.getMessage());
           return false;
       }
      
    }
    
}
