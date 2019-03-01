/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Armando
 */
public class CRUDFicheiro {
    
    private Connection con;
    
    public CRUDFicheiro() throws ClassNotFoundException, SQLException{
        con=Fachada.getConnection();
    }
    
    public boolean insereFicheiro(String nomePessoa, String nomeFicheiro){
        
        try{
            
            /**/
            int valor_operador=Fachada.getUtilizdorOperacaoCRUD().getIDUtilizador(nomePessoa);
            if(valor_operador!=-1){
                
                PreparedStatement statement = con.prepareStatement("insert into ficheiros (nome_ficheiro,data_ficheiro,id_pessoa) values(?,?,?)");
                //statement.setQueryTimeout(30);
                statement.setString(1, nomeFicheiro);
                statement.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
                statement.setInt(3, valor_operador);
                int verifica=statement.executeUpdate();
            
                if(verifica==0){
                    return false;
                }
            
                return true;
            }
            
            return false;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    public List<String> getNomesFicheirosPessoa(String nomePessoa){
        
        try{
            
            /*OBTENCAO DO ID DAQUELA PESSOA*/
            int valor_operador=Fachada.getUtilizdorOperacaoCRUD().getIDUtilizador(nomePessoa);
            if(valor_operador!=-1){
            
                PreparedStatement statement = con.prepareStatement("select nome_ficheiro from ficheiros where id_pessoa=?"); 
                statement.setInt(1, valor_operador);
                ResultSet rs=statement.executeQuery();
                List<String> nome_ficheiros_pessoa=new ArrayList<String>();
                while(rs.next()){
                    nome_ficheiros_pessoa.add(rs.getString("nome_ficheiro"));
                }
                
                return nome_ficheiros_pessoa;
            }
            
            return null;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
}
