/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Armando
 */
public class DadosJogo {

    Utilizador utilizador = null;
    /**/
    private FicheirosFabrica fich;
    private List<Modulo> m;
    private FicheiroBuilder ficheiro_builder;

    /*COLOCAR AQUI UM GESTOR DE COMANDOS*/
    GestorComandos com = null;

    public DadosJogo() {
        this.m = new ArrayList<Modulo>();
        this.com = new GestorComandos(this);
        this.fich = new FicheirosFabrica();
    }

    public FicheirosFabrica getFich() {
        return fich;
    }

    public void setFich(FicheirosFabrica fich) {
        this.fich = fich;
    }

    public FicheiroBuilder getFicheiro_builder() {
        return ficheiro_builder;
    }

    public void setFicheiro_builder(FicheiroBuilder ficheiro_builder) {
        this.ficheiro_builder = ficheiro_builder;
    }

    public GestorComandos getCom() {
        return com;
    }

    public Utilizador getUtilizador() {

        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {

        this.utilizador = utilizador;
    }

    public List<Modulo> getM() {
        return m;
    }

    public void setM(List<Modulo> m) {
        this.m = m;
    }

    public void setCom(GestorComandos com) {
        this.com = com;
    }

    public List<Modulo> getListaModulo() {
        return m;
    }

    public void setListaModulo(List<Modulo> m) {
        this.m = m;
    }

    public Modulo getModulo(int id) {
        /*QUANDO SELECCIONA O MODULO*/

        for (Modulo x : this.m) {
            if (x.getId_modulo() == id) {
                return x;
            }
        }

        return null;
    }

    public int criaModulo() {
        Modulo mo = new Modulo();
        int x = mo.getId_modulo();
        this.m.add(mo);
        return x;
    }

    public boolean removeModulo(int id) {

        for (Modulo x : this.m) {
            if (x.getId_modulo() == id) {
                return this.m.remove(x);
            }
        }

        return false;
    }

    public boolean limpaTudoDadosJogo() {

        try {

            /*LIMPA TODOS OS DADOS QUE SE ENCONTRAM NO "JOGO" (DADOSJOGO)*/
            this.com = null;
            this.m = null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

}
