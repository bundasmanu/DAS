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
public interface Comando {
    
    void make(DadosJogo d);
    void undo(DadosJogo d);
    
}
