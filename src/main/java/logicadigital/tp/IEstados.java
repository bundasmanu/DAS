/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

/**
 *
 * @author Armando
 */
public interface IEstados {
    
    public IEstados aplica_registo();/*VAI PARA O REGISTO--> CONTROLO POR BOTOES*/
    public IEstados aplica_login();/*VAI PARA O LOGIN-->CONTROLO POR BOTOES*/
    public IEstados registo(String n, String p);
    public IEstados login(String n, String p);
    public IEstados voltar();
    
}
