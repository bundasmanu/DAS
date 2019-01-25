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
    public int criaModulo();
    public int insereInputModulo(int id, int bin);
    public int insereOperadorModulo(int id, Opcao op);
    public boolean colocaInputOperador(int id_input,int id_modulo, int id_operador);
    public boolean adicionaOutputAoModuloEOperador(int id_modulo, int id_operador);
    public boolean adicionaOperadorOutroOperador(int id_modulo,int id_Operador_Adicionar,int id_Operador_Receber);/*AMBOS JÁ SE ENCONTRAM NO MODULO, BASTANDO APENAS ADICIONAR O OPERADOR NO OUTRO*/
    public void realizaOperacaoModulo(int id);
    public String listaModulo(int id);
    
}
