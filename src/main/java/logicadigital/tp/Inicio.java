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
public class Inicio extends EstadoAdapter{
    
    public Inicio(DadosJogo d){
        super(d);
    }
    
    @Override
    public IEstados aplica_registo(){
        return new Registo(super.getDadosJogo());
    }
    
    @Override
    public IEstados aplica_login(){
        return new Login(super.getDadosJogo());
    }

   

  
    
}
