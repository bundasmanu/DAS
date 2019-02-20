/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class FicheiroBLIF {
    
    public FicheiroBLIF() {
        
    }

    public File CriaFicheiro() throws FileNotFoundException {
        try {
            File f = null;
            Randomm rand = new Randomm();
            String str_gerada = rand.generateRandomString();
            f = new File("ficheiro" + str_gerada + ".blif");
            if (f.exists()) {
                System.out.println("O ficheiro  existe");

            } else {
                System.out.println("o ficheiro nao existe");
                f.createNewFile();
            }

            return f;
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            return null;
        }

    }

    public boolean LerFicheiroBlif() throws FileNotFoundException, IOException {
        try{
        File f = new File("C:\\Users\\carlo\\OneDrive\\Documentos\\NetBeansProjectse\\TP_DAS\\ProjetoDas-SimuladorLogicaDigital");
        if (f.exists() && !f.isDirectory()) {
            String linha = null;

            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

            bufferedReader.close();
          
        }
        }
        catch(Exception e){
            System.out.println(""+e.getMessage());
            return false;
        }
        return true;
    }

    public boolean verificaSeFicheiroExiste() {
        File f = new File("C:\\Users\\carlo\\OneDrive\\Documentos\\NetBeansProjectse\\TP_DAS\\ProjetoDas-SimuladorLogicaDigital");

        if (f.exists()) {
            System.out.println("Ficheiro existe");        //if file exists
            return true;
        } else {
            System.out.println("Nao existe o ficheiro");         //if file doesn't exist
            return false;
        }

    }

    /*@Override
    public boolean ExportaFicheiro() {

        PrintWriter out;
        try {
            out = new PrintWriter("ficheiro.blif");
            out.println();
            out.close();
        } catch (FileNotFoundException e) {
            System.err.println("O ficheiro nao existe");
            e.getMessage();
        }
        return true;
    }

    ;
    

    @Override
    public boolean ImportaFicheiro() {
        try {
            File f = this.CriaFicheiro();
            return this.LerFicheiroBlif();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return false;
    }*/

}
