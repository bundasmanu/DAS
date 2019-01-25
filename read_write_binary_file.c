/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author carlo
 */
public class blif implements Serializable {

    int num1;
    int num2;

    public blif() {

    }

    public blif(int n1, int n2) {
        this.num1 = n1;
        this.num2 = n2;
        System.out.println("" + this.num1 + "" + this.num2);
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public boolean WriteToTextFile(int n1, int n2) throws FileNotFoundException, UnsupportedEncodingException {
        try {
            PrintWriter writer = new PrintWriter("exemplo.txt", "UTF-8");
            writer.println("Numero1: " + n1 + "Numero2: " + n2);
            writer.close();

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            return false;
        }
        return true;
    }

    //nao e preciso em principio
    public void criaFicheiro() throws IOException {
        File novo_ficheiro = new File("C:\\Users\\carlo\\OneDrive\\Documentos\\NetBeansProjectse\\TP_DAS\\TrabalhoDAS-SimuladorLogicaDigital\\src\\main\\java\\logicadigital\\tp");
        boolean sucesso = novo_ficheiro.createNewFile();
        if (sucesso == true) {
            System.out.println("Ficheiro criado com sucesso");
        } else {
            System.out.println("Erro ao criar o ficheiro");
        }
    }

    public boolean ReadTextFile(String ficheiro_txt) throws FileNotFoundException, IOException {
        File file = new File(ficheiro_txt);
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String str;
        while ((str = bf.readLine()) != null) {
            System.out.println(str);
        }
        return true;
    }

    public boolean WriteBinaryFile(blif ob) throws FileNotFoundException, IOException {
        try {
            FileOutputStream fos = new FileOutputStream("exemplo.bin");
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(ob);
            System.out.println("Escrito em binario");
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return true;
    }

    public boolean ReadBinaryFile(blif ob) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream ficheiro = new FileInputStream("exemplo.bin");
        ObjectInputStream reader = new ObjectInputStream(ficheiro);

        while (true) {
            try {
                blif a = (blif) reader.readObject();
                System.out.println(""+a.getNum1()+"\t"+a.getNum2());
            } catch( Exception e) {
                System.err.println("Final do ficheiro lido");
                break;
            } 
       }
    
        return true;
    }

}
//main para testar
//  blif c= new blif();
   //blif b= new blif(2,3);
   boolean status= c.WriteBinaryFile(b);
//    if(status==true){
//        System.out.println("Escreveu para ficheiro binario");
//    }
//    else{
//        System.out.println("Nao escreveu para binario");
//    }
//    
//    boolean verificaFicheiroLido= c.ReadBinaryFile(b);
//    if(verificaFicheiroLido==true){
//        System.out.println("Ficheiro binario lido");
//        
//    }
//    else{
//        System.out.println("Erro no ficheiro");
//    }
