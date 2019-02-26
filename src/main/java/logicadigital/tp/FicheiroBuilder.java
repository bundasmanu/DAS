/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author carlo
 */
public abstract class FicheiroBuilder {
    
    //retorna o tipo de ficheiro builder
    public static FicheiroBuilder getFicheiroBuilder(String tipo_ficheiro_builder) throws IOException{
        if(tipo_ficheiro_builder.equals("BuilderBLIF")){
            return new BuilderBLIF();
        }
        else if(tipo_ficheiro_builder.equals("BuilderBIN")){
            return new BuilderBIN();
        }
        return null;
    }
    
    abstract public FicheiroBuilder setModulo(DadosJogo x, int id_mod);
    abstract public FicheiroBuilder setInputs(DadosJogo x, int id_mod);
    abstract public FicheiroBuilder setOutputs(DadosJogo x, int id_mod);
    abstract public FicheiroBuilder setOperadores(DadosJogo x, int id_mod);
    public FicheiroBuilder estabeleceLigacaoEntreOperadores(DadosJogo x, int id_mod, int id_op){
        return this;
    }
    public FicheiroBuilder estabeleceLigacaoOutputs(DadosJogo x, int id_mod){
        return this;
    }
    abstract public FicheiroBuilder build() throws Exception;
    
}
