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
public class ImportarFicheiroBin implements EstrategiaBotao_Importar{

    @Override
    public boolean importarFicheiro(DadosJogo j, String nome_ficheiro_selecionado) {
        if (nome_ficheiro_selecionado.contains(".bin")) {
            Ficheiro ficheiro = FicheirosFabrica.getTipoFicheiros("BIN", j, nome_ficheiro_selecionado);
            //vai ler ficheiro .bin
            ficheiro.LerFicheiro();
            return true;
        } else {
            return false;
        }

    }

}
