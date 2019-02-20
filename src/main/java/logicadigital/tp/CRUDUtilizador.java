/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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
                JOptionPane.showMessageDialog(null, "Novo utilizador adicionado");
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
    public String SelectEspecifiedUser(String nome) throws SQLException {
        String info = "";
        try {

            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM utilizador Where nome=?");
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

        conexao.close();
        return info;
    }
    
    public int getIDUtilizador(String nome){
        
        try{
            
            /**/
            PreparedStatement statement = conexao.prepareStatement("SELECT id FROM utilizador where nome=?");
            //statement.setQueryTimeout(30);
            statement.setString(1, nome);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int id_utilizador= rs.getInt(1);
                return id_utilizador;
            }
            
            return -1;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        
    }

    public boolean VerificaLogin(String username, String password) throws SQLException {
        try {
        int status = 0;
        String query = "select count(*) from utilizador where nome='"+username+"' and pass='"+password+"'";

        PreparedStatement stmt = conexao.prepareStatement(query);
        ResultSet rs=stmt.executeQuery();
        
        while(rs.next()){
            status=rs.getInt(1);
        }
        
        if(status==0){
            return false;
        }
        
        return true;
            
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            return false;
        }

    }
    
     
    
//     public void VerificaLogin(String username, String password) throws SQLException {
//         boolean flag=false;
//         try{
//             String query= "Select nome, pass from utilizador";
//             PreparedStatement stmt= conexao.prepareStatement(query);
//             ResultSet results= stmt.executeQuery(query);
//             while(results.next()){
//                 String user= results.getString("nome");
//                 String pass= results.getString("pass");
//                 
//                 if((username.equals(user)) && (password.equals(pass))){
//                     flag=true;
//                     JOptionPane.showMessageDialog(null,"O nome e a password existem");
//                 }
//                 results.close();
//                 if(!flag){
//                     JOptionPane.showMessageDialog(null,"Por favor verifique o seu nome e password");
//                 }
//             }
//             }
//         catch(Exception e){
//             System.out.println(""+e.getMessage());
//         }
//
//     }
}
