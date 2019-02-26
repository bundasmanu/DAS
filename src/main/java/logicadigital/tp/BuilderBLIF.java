/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

/**
 *
 * @author carlo
 */
public class BuilderBLIF extends FicheiroBuilder{

    public BuilderBLIF(){
        eEscrever= new EscritaBLIF();
    }

    @Override
    public boolean exportaFicheiro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean gravaFicheiro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FicheiroBuilder build() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FicheiroBuilder setInfo_Ficheiro(Object x) {
        eEscrever.escreveFicheiro(x);
        return null;
       // return FicheiroBuilder.getFicheiroBuilder("BuilderBIN");
    }

}
