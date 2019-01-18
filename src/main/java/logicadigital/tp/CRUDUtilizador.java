/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Armando
 */
public class CRUDUtilizador {

    private Connection conexao;

    public CRUDUtilizador() throws ClassNotFoundException, SQLException {
        this.conexao = Session.getConnection();/*OBTENCAO DA REFERENCIA DO OBJETO*/
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
                JOptionPane.showMessageDialog(null,"Novo utilizador adicionado");
                return true;
            } else {
                System.out.println("Utilizador nao inserido");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Mensagem:" + e.getMessage());
            return false;
        }

    }

    //Update
    public boolean UpdateUtilizador(String new_nome, String new_passwords) throws SQLException {

        try {
            PreparedStatement statement = conexao.prepareStatement("UPDATE cliente set password=? where nome=?");
            //Utilizador novo = new Utilizador(nome, passwords);
            statement.setString(1, new_passwords);
            statement.setString(2, new_nome);
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
    public boolean DeleteUtilizador(String nome) throws SQLException {

        try {
            PreparedStatement statement = conexao.prepareStatement("Delete From Utilizador Where nome=?");
            //statement.setQueryTimeout(30);
            statement.setString(1, nome);
            int count = statement.executeUpdate();
            if (count > 0) {
                System.out.println("Utilizador eliminado com sucesso na base de dados");
                return true;
            } else {
                System.out.println("Nao foi eliminado por alguma razao..");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Mensgaem:" + e.getMessage());
            return false;
        }

    }

    //Display
    public String SelectEspecifiedUser(Connection connection, String nome) throws SQLException {
        String info = "";
        try {
          
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM utilizador Where nome=?");
            //statement.setQueryTimeout(30);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            info = "ID: " + rs.getString("ID") + " Nome: " + rs.getString("NOME") + " Pass: " + rs.getString("PASS");

        }

            
        } catch (Exception e) {
            System.out.println("Mensgaem:" + e.getMessage());
            return "";
        }

        return info;
    }
    
      public String VerificaLogin(Connection connection, String username, String password) throws SQLException {

        String status = null;
        String query = "select nome,pass from utilizador Where nome=? and pass=?";

        PreparedStatement stmt = connection.prepareStatement(query);
        try {
            ResultSet rs = stmt.executeQuery(query);
            rs.getString(username);

//SELECT * FROM UTILIZADOR Where NOME='Pedro';
            //rs.getString(username);
            String checkUser = rs.getString(1);
            String checkPass = rs.getString(2);
            if (checkUser.equals(username) && checkPass.equals(password)) {
                status = "True";
            } else {
                status = "False";
            }
            connection.close();
            
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            return "excepcao";
        }
        return status;
}
}
