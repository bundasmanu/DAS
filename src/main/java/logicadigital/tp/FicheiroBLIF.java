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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class FicheiroBLIF {

    private List<Modulo> lista_modulos;

    public FicheiroBLIF() {
        lista_modulos = new ArrayList<Modulo>();
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

    public boolean leComandoModel(int id_modulo) {
        try {
            Modulo novo = new Modulo(id_modulo);
            lista_modulos.add(novo);
            return true;
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            return false;
        }
    }

    public boolean leComandoInput(int id_modulo, List<Integer> lista_inputs) {
        try {

            Modulo m = this.lista_modulos.get(id_modulo);
            if (m == null) {
                return false;
            }
            for (int i = 0; i < lista_inputs.size(); i++) {
                Input x = new Input();
                x.setId_input(i);
                m.getInputs().add(x);
            }
            return true;

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            return false;
        }
    }

    public boolean LeComandoOutput(int id_modulo, List<Integer> lista_outputs) {
        try {

            Modulo m = this.lista_modulos.get(id_modulo);
            if (m == null) {
                return false;
            }
            for (int i = 0; i < lista_outputs.size(); i++) {
                Output x = new Output();
                x.setId_input(id_modulo);
                m.getOutputs().add(x);
            }
            return true;

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            return false;
        }
    }

    public boolean LeNamesInputOperador(int id_modulo, List<Integer> lista_inputs, int id_operador, List<Integer> lista_binarios, int valor_bin_operador) {
        Modulo m = this.lista_modulos.get(id_modulo);
        if (m == null) {
            return false;
        }
        Operador x = new Operador(id_operador);
        m.getOperador().add(x);

        for (int i = 0; i < m.inputs.size(); i++) {
            for (int j = 0; j < lista_inputs.size(); i++) {
                if (m.inputs.get(i).id_input == lista_inputs.get(j)) {
                    x.getInputs().add(m.getInputs().get(i));
                    for (int h = 0; h < lista_binarios.size(); i++) {
                        m.getInputs().get(j).setBinario(lista_binarios.get(h));
                    }

                }
            }
        }
        return true;
    }
    
    public boolean leNamesOutputOperador(int id_modulo,List<Integer> lista_operadores, int binario,int output) {
        Modulo m= this.lista_modulos.get(id_modulo);
        if(m==null){
            return false;
        }
        
        Output out=null;
        for(int i=0;i<m.outputs.size();i++){
            if(m.outputs.get(i).id_input==output){
                out=m.getOutputs().get(i);
                m.outputs.get(i).setBinario(binario);               
            }
        }
        
        for(int j=0;j<m.operador.size();j++){
            for(int h=0;h<lista_operadores.size();h++){
                if(lista_operadores.get(h)==m.operador.get(j).getId_operador()){
                   m.getOperador().get(j).getOutputs().add(out);
                }
            }
        }
        
        return true;
    }

    public boolean leNamesOperadoresOperador(int id_modulo,List<Integer> lista_operadores,int operador_que_vai_receber_outro_operador) {
        Modulo m = this.lista_modulos.get(id_modulo);
        if (m == null) {
            return false;
        }
        
        for(int i=0;i<m.getOperador().size();i++){
            if(m.operador.get(i).getId_operador()==operador_que_vai_receber_outro_operador){
                for(int j=0;j<lista_operadores.size();j++){
                    m.operador.get(i).getOperadores().add(m.getOperador().get(j));
                }
            }
    }
        return true;
    }

    
    public boolean LerFicheiroBlif(DadosJogo d, String name) throws FileNotFoundException, IOException {
        try {
            String expressao_regular = "([A-Z|a-z]:\\\\[^*|\"<>?\\n]*)|(\\\\\\\\.*?\\\\.*)";
            int flag_controlo = 0;
            File f = new File("D:\\" + name);
            List<Integer> lista_int = new ArrayList<Integer>();
            List<Integer> lista_names_inputs = new ArrayList<Integer>();
            List<Integer> lista_binarios = new ArrayList<Integer>();
            List<Integer> lista_operadores__passar = new ArrayList<Integer>();
            List<Integer> lista_outputs = new ArrayList<Integer>();
            List<Integer> lista_operadores = new ArrayList<Integer>();
            if (f.exists() && !f.isDirectory()) {
                String linha = "";
                int operador = 0;
                FileReader fileReader = new FileReader(f);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((linha = bufferedReader.readLine()) != null) {
                    String last = linha.substring(linha.lastIndexOf(" ") + linha.length() - 1);

                    System.out.println(linha);
                    if (linha.startsWith(".model")) {
                        boolean status = leComandoModel(Integer.parseInt(last));
                        System.out.println("" + status);
                    } else if (linha.contains(".inputs")) {
                        String ultimo = linha.substring(linha.lastIndexOf(" ") + linha.lastIndexOf(linha.length()));
                        String[] a = ultimo.split(" ");

                        for (int i = 0; i < a.length; i++) {
                            lista_int.add(Integer.parseInt(a[i]));
                        }
                        leComandoInput(Integer.parseInt(last), lista_int);
                    } else if (linha.contains(".outputs")) {
                        String ultimo = linha.substring(linha.lastIndexOf(" ") + linha.lastIndexOf(linha.length()));
                        String[] a = ultimo.split(" ");

                        for (int i = 0; i < a.length; i++) {
                            lista_outputs.add(Integer.parseInt(a[i]));
                        }
                        LeComandoOutput(Integer.parseInt(last), lista_outputs);
                    } else if (linha.contains(".names") && flag_controlo == 0) {
                        for (int i = 0; i < lista_int.size() - 1; i++) {
                            String l = linha.substring(linha.lastIndexOf(" ") + linha.length());
                            String[] s = l.split(" ");
                            for (int j = 0; j < s.length - 1; j++) {
                                lista_names_inputs.add(Integer.parseInt(s[j]));
                            }

                            String b = s[s.length];
                            operador = Integer.parseInt(b);
                            String next;
                            next = bufferedReader.readLine();
                            System.out.println("Linha atual: " + linha);
                            System.out.println("Linha seguinte: " + next);
                            int valor = 0;
                            for (int j = 0; j < lista_names_inputs.size(); j++) {
                                valor = Character.getNumericValue(next.charAt(j));
                                lista_binarios.add(valor);
                            }
                            LeNamesInputOperador(Integer.parseInt(last), lista_int, operador, lista_binarios, valor);
                            bufferedReader.readLine();
                        }
                        flag_controlo = 1;
                    } else if (linha.contains(".names") && flag_controlo == 1) {
                        int x = linha.trim().split("\\s+").length;
                        String ultimo = linha.substring(linha.lastIndexOf(" ") + linha.lastIndexOf(linha.length()));
                        String[] a = ultimo.split(" ");
                        for (int j = 0; j < a.length - 1; j++) {
                            if (x == 4) {
                                for (int h = 0; h < a.length - 1; h++) {
                                    lista_operadores__passar.add(Integer.parseInt(a[h]));
                                }
                            }
                        }

                        String b = a[a.length];
                        operador = Integer.parseInt(b);
                        leNamesOperadoresOperador(Integer.parseInt(last), lista_operadores__passar, operador);
                        flag_controlo = 2;
                    } else if (linha.contains(".names") && flag_controlo == 2) {
                        int ultimo_output=0;
                        for (int i = 0; i < lista_outputs.size(); i++) {
                            ultimo_output=0;
                            String l = linha.substring(linha.lastIndexOf(" ") + linha.length());
                            String[] s = l.split(" ");
                            for (int j = 0; j < s.length - 1; j++) {
                                lista_operadores.add(Integer.parseInt(s[j]));
                            }

                            String b = s[s.length];
                            operador = Integer.parseInt(b);
                            String next;
                            next = bufferedReader.readLine();
                            String[] sp = next.split(" ");
                            ultimo_output = Integer.parseInt(sp[sp.length]);
                            System.out.println("Linha atual: " + linha);
                            System.out.println("Linha seguinte: " + next);
                            int valor = 0;
                            for (int j = 0; j < lista_outputs.size(); j++) {
                                valor = Character.getNumericValue(next.charAt(j));
                                lista_binarios.add(valor);
                            }
                        }
                        leNamesOutputOperador(Integer.parseInt(last), lista_operadores, ultimo_output, operador);
                        bufferedReader.readLine();

                    }

                    bufferedReader.close();

                }
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
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
