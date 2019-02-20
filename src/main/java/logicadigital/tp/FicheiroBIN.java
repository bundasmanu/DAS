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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class FicheiroBIN{
    
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
            FileOutputStream fos = new FileOutputStream("historico_"+u.getNome()+".bin");
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
    public boolean ReadBinaryFile(Utilizador u) throws FileNotFoundException, IOException {
        FileInputStream ficheiro = new FileInputStream("historico_"+u.getNome()+".bin");
        ObjectInputStream reader = new ObjectInputStream(ficheiro);

        while (true) {
            try {
                Utilizador a = (Utilizador) reader.readObject();
                System.out.println("O objeto foi lido do ficheiro" + a.toString());
                reader.close();

            } catch (Exception e) {
                System.err.println("" + e.getMessage());
                break;
            }
        }

        return true;
    }
    
}
