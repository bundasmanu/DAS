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
public class ImportarFicheiroBlif implements EstrategiaBotao_Importar{
   
    @Override
    public boolean importarFicheiro(DadosJogo j,String nome_ficheiro_selecionado) {
        if (nome_ficheiro_selecionado.contains(".blif")) {
            //vai ler ficheiro bin
            Ficheiro ficheiro = FicheirosFabrica.getTipoFicheiros("BLIF", j, nome_ficheiro_selecionado);
            //vai ler ficheiro blif
            ficheiro.LerFicheiro();
            return true;
        } else {
            return false;
        }
    }
    
}
