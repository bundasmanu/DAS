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
//estrategia servira para o botao importar consoante a string conter a extensao
//.blif ou .bin
public interface EstrategiaBotao_Importar {
   public  boolean importarFicheiro(DadosJogo j,String nome_ficheiro_selecionado);
}
