/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Armando
 */
public class CRUDUtilizador {

    private Connection conexao;
    
    public CRUDUtilizador() throws ClassNotFoundException, SQLException{
        this.conexao=Session.getConnection();/*OBTENCAO DA REFERENCIA DO OBJETO*/
    }
    
    public boolean InsertUtilizador(String nome, String passwords) throws SQLException {
    //Insert    public boolean InsertUtilizador(Connection connection, String nome, String passwords) throws SQLException {

        try {
            
            PreparedStatement statement = conexao.prepareStatement("Insert into utilizador(nome,pass) values(?,?)");
            //Utilizador novo = new Utilizador(nome, passwords);
            statement.setString(1, nome);
            statement.setString(2, passwords);
            int result = statement.executeUpdate();

            if (result > 0) {
                System.out.println("Utilizador inserido com sucesso");
                return true;
            } else {
                System.out.println("Utilizador nao inserido");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Mensgaem:" + e.getMessage());
            return false;
        }

    }

    //Update
    public boolean UpdateUtilizador(Connection connection, String new_nome, String new_passwords) throws SQLException {
       
        try {
            PreparedStatement statement = conexao.prepareStatement("UPDATE cliente set password=? where nome=?");
            //Utilizador novo = new Utilizador(nome, passwords);
            statement.setString(1, new_nome);
            statement.setString(2, new_passwords);
            int result = statement.executeUpdate();

            if (result > 0) {
                System.out.println("Utilizador atualizado com sucesso");
                return true;
            } else {
                System.out.println("Utilizador nao atualizado");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Mensgaem:" + e.getMessage());
            return false;
        }


    }

    //Delete
    public boolean DeleteUtilizador(Connection connection, String nome) throws SQLException {
        
        try {

        } catch (Exception e) {
            System.out.println("Mensgaem:" + e.getMessage());
            return false;
        }

        return true;

    }

    //Display
    public boolean DisplayUtilizador(Connection connection, String nome) throws SQLException {
        
        try {


        } catch (Exception e) {
            System.out.println("Mensgaem:" + e.getMessage());
            return false;
        }

        return true;
    }
}
