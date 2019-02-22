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
    private FicheiroBLIF ficheiro= null;
   // private EstrategiaLerFicheiro eLer;
    private DadosJogo dj;
    
    public AdaptadorBLIF(DadosJogo d,String nome) {
        ficheiro=new FicheiroBLIF();
        super.name_ficheiro=nome;
        dj=d;
    }

    public FicheiroBLIF getFicheiro() {
        return ficheiro;
    }

    public void setFicheiro(FicheiroBLIF ficheiro) {
        this.ficheiro = ficheiro;
    }

    public DadosJogo getDj() {
        return dj;
    }

    public void setDj(DadosJogo dj) {
        this.dj = dj;
    }

   

    
    @Override
    public boolean LerFicheiro() {
        try {
            return ficheiro.LerFicheiroBlif(d, name_ficheiro);
        } catch (Exception ex) {
            System.out.println(""+ex.getMessage());
          return false;
        }
    }
}
     
    


