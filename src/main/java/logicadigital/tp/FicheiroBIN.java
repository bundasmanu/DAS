/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class FicheiroBIN {

    public FicheiroBIN() {

    }

    /*@Override
    public boolean LerFicheiro(){
        
    }*/
    //metodo para escrita num ficherio binario
    public boolean WriteNameOfUserBinaryFile(Utilizador u) throws ClassNotFoundException, SQLException {
        CRUDUtilizador crud = new CRUDUtilizador();
        //if (crud.VerificaLogin(u.getNome(), u.getPassword()) == true) {
        try {
            FileOutputStream fos = new FileOutputStream("historico_" + u.getNome() + ".bin");
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(u);
            System.out.println("O nome do utilizador foi guardado num ficheiro");
            return true;
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            return false;
        }

    }

    //metodo para leitura de um ficheiro binario
    public boolean ReadBinaryFile(DadosJogo d, String name) throws FileNotFoundException, IOException {

        try {
            FileInputStream ficheiro;
            ficheiro = new FileInputStream(name);
            ObjectInputStream reader = new ObjectInputStream(ficheiro);
            
            List<Modulo> lista_modulos = null;
            Object x;
            x = (Object) reader.readObject();
            lista_modulos = (List<Modulo>) x;
            for (int i = 0; i < lista_modulos.size(); i++) {
                System.out.println("O objeto foi lido do ficheiro de nome" + lista_modulos.get(i).toString());
            }

            reader.close();

            return true;

        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
            return false;
        }
    }
}
