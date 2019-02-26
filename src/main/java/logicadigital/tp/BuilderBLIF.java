/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static logicadigital.tp.Opcao.AND;

/**
 *
 * @author carlo
 */
public class BuilderBLIF extends FicheiroBuilder{
    
    FileWriter f=null;
    
    public BuilderBLIF() throws IOException{
        f=new FileWriter("historico" +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")+ ".blif",true);
    }

    public FileWriter getF() {
        return f;
    }

    public void setF(FileWriter f) {
        this.f = f;
    }

    @Override
    public FicheiroBuilder build() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FicheiroBuilder setModulo(DadosJogo x, int id_modulo) {
        String str = ".model " +id_modulo;
        try {
            f.write(str);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return this;
       // return FicheiroBuilder.getFicheiroBuilder("BuilderBIN");
    }
    
    @Override
    public FicheiroBuilder setInputs(DadosJogo x, int id_modulo) {
        String str = ".inputs ";
        try {
            
            /*VERIFICAR SE EXISTE O MODULO A VERIFICAR EXISTE*/
            Modulo m=x.getModulo(id_modulo);
            
            if(m==null){
                return this;
            }
            
            for(Input in : m.getInputs()){
                str+=in.getId_input()+"/t";
            }
            
            f.write(str);
            
            return this;
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return this;
        }
    }
    
    @Override
    public FicheiroBuilder setOutputs(DadosJogo x, int id_mod){
        String str = ".outputs ";
        try{
            
            /*VERIFICAR SE EXISTE O MODULO A VERIFICAR EXISTE*/
            Modulo m=x.getModulo(id_mod);
            
            if(m==null){
                return this;
            }
            
            for(Output out : m.getOutputs()){
                str+=out.getId_input()+"\t";
            }
            
            f.write(str);
            return this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return this;
        }
    }
    
    @Override
    public FicheiroBuilder setOperadores(DadosJogo x, int id_mod){
        String str = ".names ";
        String str2="";
        String str3="";
        try{
            
            /*VERIFICAR SE EXISTE O MODULO A VERIFICAR EXISTE*/
            Modulo m=x.getModulo(id_mod);
            
            if(m==null){
                return this;
            }
            
            for(Operador op : m.getOperador()){
                for(Input in : op.getInputs()){
                    str+=in.getId_input()+"\t";
                    str2+=in.getBinario()+"\t";
                }
                str+=op.getId_operador()+"\n";
                if(op.getQual()==AND){
                    str2+=op.calculaSomaInputs()+"\n";
                }
                else{
                    str2+=op.calculaOrInputs()+"\n";
                }
                str3+=str+str2;
                str="";
                str2="";
            }
            
            f.write(str3);
            return this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return this;
        }
        
    }
    
    @Override
    public FicheiroBuilder estabeleceLigacaoOutputs(DadosJogo x, int id_mod){
        
        String str=".names ";
        String str2="";
        String str3="";
        try{
            
            /*VERIFICAR SE EXISTE O MODULO A VERIFICAR EXISTE*/
            Modulo m=x.getModulo(id_mod);
            
            if(m==null){
                return this;
            }
            
            for(Operador op : m.getOperador()){
                str+=op.getId_operador()+"\t";
                if(op.getQual()==AND){
                    str2+=op.calculaSomaInputs()+"\t";
                }
                else{
                    str2+=op.calculaOrInputs()+"\t";
                }
                for(Output out : m.getOutputs()){
                    str+=out.getId_input()+"\t";
                    str2+=out.getBinario()+"\t";
                }
                str+="\n";
                str2+="\n";
                str3+=str+str2;
                str="";
                str2="";
            }
            
            f.write(str3);
            return this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return this;
        }
        
    }
    
    @Override
    public FicheiroBuilder estabeleceLigacaoEntreOperadores(DadosJogo x, int id_mod, int id_op){
        
        String str=".names ";
        String str2="";
        String str3="";
        try{
            
            /*VERIFICAR SE EXISTE O MODULO A VERIFICAR EXISTE*/
            Modulo m=x.getModulo(id_mod);
            
            if(m==null){
                return this;
            } 

            for (Operador op : m.getOperador()) {
                if (op.getId_operador() == id_op) {
                    if (op.getOperadores().isEmpty() == false) {
                        if (op.getQual() == AND) {
                            str += op.getId_operador() + "\t";
                            str2 += op.calculaSomaInputs() + "\t";
                        } else {
                            str += op.getId_operador() + "\t";
                            str2 += op.calculaOrInputs() + "\t";
                        }
                    }
                    if (op.getQual() == AND) {
                        str2+=op.calculaSomaInputs()+"\n";
                    } else {
                        str2+=op.calculaOrInputs()+"\n";
                    }
                    str += op.getId_operador()+"\n";
                    str3+=str+str2;
                }     
            }
            
            f.write(str3);
            return this;
            
        }        
        catch(Exception e){
            System.out.println(e.getMessage());
            return this;
        }
        
    }
    
}
