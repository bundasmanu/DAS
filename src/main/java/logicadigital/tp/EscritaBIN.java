/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.util.List;

/**
 *
 * @author carlo
 */
public class EscritaBIN implements EstrategiaEscrever{

    @Override
    public boolean escreveFicheiro(Object x) {
        x=(List<Modulo>)x;
        return true;
    }
    
}
