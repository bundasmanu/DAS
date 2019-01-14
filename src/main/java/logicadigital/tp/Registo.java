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
public class Registo extends EstadoAdapter{
    
    public Registo(DadosJogo d){
        super(d);
    }
    
    @Override
    public IEstados registo(String n, String p){
        /*VERIFICAR SE ESTA TUDO EM ORDEM
        /*SE ESTIVER --> INSERE NA BD, E PASSA PARA O ESTADO MODOGAME*/
        /*SENAO ESTIVER PASSAR PARA O ESTADO ANTERIOR INICIO*/
        return new ModoGame(super.getDadosJogo());
    }
    
    @Override
    public IEstados voltar(){
        return new Inicio(new DadosJogo());/*NOVA INSTANCIA DE DADOS DO JOGO, NAO FAZ SENTIDO PASSAR A MSM*/
    }
    
}
