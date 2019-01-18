/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Armando
 */
public class Registo extends EstadoAdapter{
    
    public Registo(DadosJogo d){
        super(d);
    }
    
    //método para registar um novo utilizador
    @Override
    public IEstados registo(String n, String p){
        try {
            /*VERIFICAR SE ESTA TUDO EM ORDEM
            /*SE ESTIVER --> INSERE NA BD, E PASSA PARA O ESTADO MODOGAME*/
            /*SENAO ESTIVER PASSAR PARA O ESTADO ANTERIOR INICIO*/
            boolean retorno=Session.getUtilizdorOperacaoCRUD().InsertUtilizador(n, p);
            if(retorno==true){
                return new ModoGame(super.getDadosJogo());
            }
            else{
                return new Inicio(new DadosJogo());/*VOLTO AO INICIO, INICIALIZA NOVA REFERENCIA DO OBJETO JOGO*/ 
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
            return new Inicio(new DadosJogo());/*VOLTO AO INICIO, INICIALIZA NOVA REFERENCIA DO OBJETO JOGO*/
        } catch (SQLException ex) {
            Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
            return new Inicio(new DadosJogo());/*VOLTO AO INICIO, INICIALIZA NOVA REFERENCIA DO OBJETO JOGO*/
        }

    }
    
    @Override
    public IEstados voltar(){
        return new Inicio(new DadosJogo());/*NOVA INSTANCIA DE DADOS DO JOGO, NAO FAZ SENTIDO PASSAR A MSM*/
    }
    
}
