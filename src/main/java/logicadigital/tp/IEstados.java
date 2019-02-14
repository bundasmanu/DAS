/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;



public interface IEstados {
    
    public logicadigital.tp.IEstados aplica_registo();/*VAI PARA O REGISTO--> CONTROLO POR BOTOES*/
    public logicadigital.tp.IEstados aplica_login();/*VAI PARA O LOGIN-->CONTROLO POR BOTOES*/
    public logicadigital.tp.IEstados registo(String n, String p);
    public logicadigital.tp.IEstados login(String n, String p);
    public logicadigital.tp.IEstados voltar();
    public int criaModulo();
    public int insereInputModulo(int id, int bin);
    public int insereOperadorModulo(int id, Opcao op);
    public boolean colocaInputOperador(int id_input,int id_modulo, int id_operador);
    public int adicionaOutputAoModuloEOperador(int id_modulo, int id_operador);
    public boolean adicionaOperadorOutroOperador(int id_modulo,int id_Operador_Adicionar,int id_Operador_Receber);/*AMBOS JÁ SE ENCONTRAM NO MODULO, BASTANDO APENAS ADICIONAR O OPERADOR NO OUTRO*/
    public void realizaOperacaoModulo(int id);
    public String listaModulo(int id);
    public boolean setValOutput(int id_modulo, int id_output, int bin);
    public String confirmaValoresOutput(int id_modulo);
   // public boolean WriteNameOfUserBinaryFile(Utilizador u) throws ClassNotFoundException, SQLException;
    //public boolean ReadBinaryFile(Object u) throws FileNotFoundException, IOException;
}



