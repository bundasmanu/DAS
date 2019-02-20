package logicadigital.tp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlo
 */
public abstract class Ficheiro {
    
    EstrategiaLerFicheiro eLer;
    public DadosJogo d;
    String name_ficheiro;
    
    public abstract boolean LerFicheiro();
    
}
