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
public class Login extends EstadoAdapter{
    
    public Login(DadosJogo d){
        super(d);
    }
    
    @Override
    public IEstados login(String n, String p){
        
        /*IR À BD, VERIFICAR SE EXISTE, SE EXISTIR PASSA PARA O ESTADO MODOGAME*/
        /*SENAO EXISTIR VOLTA AO INICIO*/
        return new ModoGame(super.getDadosJogo());
    }
    
    @Override
    public IEstados voltar(){
        return new Inicio(new DadosJogo());/*NOVA INSTANCIA DE JOGO*/
    }
    
}
